package com.hpinfo.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewEmpReq {
    @NotNull
    private String fname;
    @NotNull
    private String lname;
    private String empId;
    private String address;
    private String email;
    private String project;
    private String phone;
    private String dept;
    private String doj;
    private String dob;
    private String passPortNo;
}
