package com.hpinfo.service;

import com.hpinfo.model.LoginReq;
import com.hpinfo.model.LoginRes;
import reactor.core.publisher.Mono;

public interface EmpLoginService {

    Mono<LoginRes> emplogin(LoginReq loginReq);
}
