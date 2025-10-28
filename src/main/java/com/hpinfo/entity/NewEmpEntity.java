package com.hpinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "Employees")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewEmpEntity {
    @Column("empId")
    public String empId;
    @Column("email")
    public String email;
    @Column("fname")
    public String fname;
    @Column("lname")
    public String lname;
    @Column("project")
    public String project;
    @Column("address")
    public String address;
    @Column("phone")
    public String phone;
    @Column("passPortNo")
    public String passPortNo;
    @Column("dob")
    public String dob;
    @Column("doj")
    public String doj;
    @Column("dept")
    public String dept;
}
