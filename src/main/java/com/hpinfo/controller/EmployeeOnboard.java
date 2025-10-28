package com.hpinfo.controller;


import com.hpinfo.exception.PassWordMisMatchException;
import com.hpinfo.model.*;
import com.hpinfo.service.EmployeeOnboardService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/emponboard")
public class EmployeeOnboard {

    private final EmployeeOnboardService employeeOnboardService;

    public EmployeeOnboard(EmployeeOnboardService employeeOnboardService) {
        this.employeeOnboardService = employeeOnboardService;
    }

    @PostMapping("/newemp")
    public Mono<NewEmpRes> reactiveResMono(@RequestBody NewEmpReq newEmpReq) {
        return employeeOnboardService.crtnewemp(newEmpReq);
    }

    @PostMapping("/firstlogin")
    public Mono<FirstLoginRes> emplogin(@RequestBody FirstLoginReq firstLoginReq ) throws PassWordMisMatchException {
        return employeeOnboardService.firstlogin(firstLoginReq);
    }

}
