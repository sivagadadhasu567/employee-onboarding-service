package com.hpinfo.service;

import com.hpinfo.config.ClientConfig;
import com.hpinfo.entity.LoginEntity;
import com.hpinfo.entity.NewEmpEntity;
import com.hpinfo.exception.PassWordMisMatchException;
import com.hpinfo.model.*;
import com.hpinfo.repository.EmpLoginRepo;
import com.hpinfo.repository.NewEmployeeRepo;
import com.hpinfo.util.EmployeeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EmployeeOnboardServiceImpl implements EmployeeOnboardService {

    private final NewEmployeeRepo newEmployeeRepo;

    private final EmpLoginRepo empLoginRepo;

    private final WebClient webClient;

    private final ClientConfig clientConfig;


    public EmployeeOnboardServiceImpl(NewEmployeeRepo newEmployeeRepo, EmpLoginRepo empLoginRepo, WebClient webClient, ClientConfig clientConfig) {
        this.newEmployeeRepo = newEmployeeRepo;
        this.empLoginRepo = empLoginRepo;
        this.webClient = webClient;
        this.clientConfig = clientConfig;
    }

    @Override
    public Mono<NewEmpRes> crtnewemp(NewEmpReq newEmpReq) {
        NewEmpEntity newEmpEntity = new NewEmpEntity();
        newEmpEntity.setEmpId(EmployeeUtil.generateEmployeeId());
        newEmpEntity.setEmail(EmployeeUtil.generateEmail(newEmpReq.getFname(), newEmpReq.getLname()));
        newEmpEntity.setProject(newEmpReq.getProject());
        newEmpEntity.setAddress(newEmpReq.getAddress());
        newEmpEntity.setLname(newEmpReq.getLname());
        newEmpEntity.setFname(newEmpReq.getFname());
        newEmpEntity.setDept(newEmpEntity.getDept());
        newEmpEntity.setDob(newEmpEntity.getDob());
        newEmpEntity.setPhone(newEmpEntity.getPhone());
        newEmpEntity.setPassPortNo(newEmpEntity.getPassPortNo());
        newEmpEntity.setDoj(newEmpEntity.getDoj());
        newEmpEntity.setDept(newEmpEntity.getDept());
        log.info("Creating new employee with req :{}", newEmpEntity);
        return newEmployeeRepo.save(newEmpEntity).map(newEmpEntity1 -> {
            NewEmpRes newEmpRes = new NewEmpRes();
            newEmpRes.setEmail(newEmpEntity.getEmail());
            newEmpRes.setEmpId(newEmpEntity.getEmpId());
            newEmpRes.setMessage("employee created sucessfull");
            log.info("employee response {}", newEmpRes);
            return newEmpRes;
        }).onErrorResume(e -> {
            log.error("unable to create the employee", e);
            return Mono.error(e);
        });
    }

    @Override
    public Mono<FirstLoginRes> firstlogin(FirstLoginReq firstLoginReq) throws PassWordMisMatchException {
        if (firstLoginReq.getNewPassword()==(firstLoginReq.getConfirmPassword()))
        {
            throw new PassWordMisMatchException();
        }
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setEmpId(firstLoginReq.getEmpId());
        loginEntity.setEmail(firstLoginReq.getEmail());
        loginEntity.setPassword(EmployeeUtil.base64Encode(firstLoginReq.getNewPassword()));
        loginEntity.setConfirmPassword(EmployeeUtil.base64Encode(firstLoginReq.getConfirmPassword()));
        log.info("first login details :{}", loginEntity);
        return empLoginRepo.save(loginEntity).map(empentity -> {
            FirstLoginRes firstLoginRes = new FirstLoginRes();
            firstLoginRes.setMessage("password created successfully");
            log.info("first login response :{}", firstLoginRes);
            return firstLoginRes;
        }).onErrorResume(e -> {
            log.error("unable to create the password", e);
            return Mono.error(e);
        });
    }
}

