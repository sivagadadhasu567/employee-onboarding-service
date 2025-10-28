package com.hpinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Projects")
public class ProjectDetailsEntity {
    @Id
    @Column("projectId")
    private String projectId;

    @Column("employeeId")
    private String employeeId;

    @Column("projectName")
    private String projectName;

    @Column("BillingRate")
    private String billingRate;

    @Column("PayRate")
    private String payRate;

    @Column("projectStartDate")
    private String projectStartDate;

    @Column("projectEndDate")
    private String projectEndDate;

    @Column("invoicingEmail")
    private String invoicingEmail;

    @Column("billingCycle")
    private String billingCycle;
}