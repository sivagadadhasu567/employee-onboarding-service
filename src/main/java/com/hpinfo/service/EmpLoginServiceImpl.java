package com.hpinfo.service;

import com.hpinfo.exception.UserException;
import com.hpinfo.model.LoginReq;
import com.hpinfo.model.LoginRes;
import com.hpinfo.repository.EmpLoginRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EmpLoginServiceImpl implements EmpLoginService {

    private final EmpLoginRepo empLoginRepo;

    public EmpLoginServiceImpl(EmpLoginRepo empLoginRepo) {
        this.empLoginRepo = empLoginRepo;
    }

    @Override
    public Mono<LoginRes> emplogin(LoginReq loginReq) {
        if (loginReq.getEmpId() == null || loginReq.getPassword() == null || loginReq.getEmail() == null) {
            return Mono.error(new UserException("Invalid username, email, or password"));
        }
        return empLoginRepo.findByEmail(loginReq.getEmail())
                .switchIfEmpty(Mono.error(new UserException("User not found")))
                .map(loginEntity -> {
                    if (loginEntity.getEmpId().equals(loginReq.getEmpId())
                            && loginEntity.getClass().equals(loginReq.getPassword())) {
                        LoginRes loginRes = new LoginRes();
                        loginRes.setMessage("Login successful");
                        return loginRes;
                    } else {
                        throw new UserException("Invalid credentials");
                    }
                });
    }

}
