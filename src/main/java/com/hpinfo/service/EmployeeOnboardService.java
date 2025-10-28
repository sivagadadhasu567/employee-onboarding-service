package com.hpinfo.service;

import com.hpinfo.exception.PassWordMisMatchException;
import com.hpinfo.model.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EmployeeOnboardService {


    Mono<NewEmpRes> crtnewemp(NewEmpReq newEmpReq);

    Mono<FirstLoginRes> firstlogin(FirstLoginReq firstLoginReq) throws PassWordMisMatchException;
}
