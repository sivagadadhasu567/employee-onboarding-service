package com.hpinfo.model;


import lombok.Data;

@Data
public class FirstLoginReq {

    private String empId;
    private String email;
    private String newPassword;
    private String confirmPassword;
}
