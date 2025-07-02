package com.api.koperasi_sci.Model.Koperasi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pegawai_pboz_koperasi", schema = "appkoperasi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pegawai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employeeno")
    private String employeeNo;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "grade_id")
    private String gradeId;

    @Column(name = "code")
    private String code;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "employee_status_name")
    private String employeeStatusName;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "locator")
    private String locator;

    @Column(name = "division_name")
    private String divisionName;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "active")
    private String active;

    @Column(name = "sync")
    private String sync;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "join_date_koperasi")
    private LocalDate joinDateKoperasi;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "mutasi_at")
    private LocalDateTime mutasiAt;

    @Column(name = "mutasi_by")
    private String mutasiBy;

    @Column(name = "inactive_at")
    private LocalDateTime inactiveAt;

    @Column(name = "inactive_by")
    private String inactiveBy;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "iuran_perbulan", precision = 19, scale = 2)
    private Integer iuranPerbulan;
}
