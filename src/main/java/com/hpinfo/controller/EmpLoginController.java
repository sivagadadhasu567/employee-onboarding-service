package com.hpinfo.controller;


import com.hpinfo.model.LoginReq;
import com.hpinfo.model.LoginRes;
import com.hpinfo.service.EmpLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/login")
public class EmpLoginController {

    private final EmpLoginService empLoginService;

    public EmpLoginController(EmpLoginService empLoginService) {
        this.empLoginService = empLoginService;
    }


    @PostMapping(produces = "application/json",consumes = "application/json")
    public Mono<LoginRes>emplogin(@RequestBody LoginReq loginReq){
        return  empLoginService.emplogin(loginReq);
    }

}
