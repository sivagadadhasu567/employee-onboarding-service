package com.hpinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table(name = "emplogin")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginEntity {
    
    @Column("empId")
    private String empId;
    @Column("email")
    private String email;
    @Column("password")
    private String password;
    @Column("confirmPassword")
    private  String confirmPassword;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("updated_at")
    private LocalDateTime updatedAt;

}
