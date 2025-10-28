package com.hpinfo.model;

import lombok.Data;

@Data
public class LoginReq {

    private String empId;
    private String email;
    private  String password;

}
