package com.api.koperasi_sci.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PegawaiKoperasiDTO {
    private Integer id;
    private String employeeno;
    private LocalDate join_date;
    private String grade_id;
    private String code;
    private String fullname;
    private String employee_status_name;
    private Integer company_id;
    private String company_name;
    private String locator;
    private String division_name;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private String active;
    private String sync;
    private String update_by;
    private LocalDate join_date_koperasi;
    private String bank_account_number;
    private LocalDateTime mutasi_at;
    private String mutasi_by;
    private LocalDateTime inactive_at;
    private String inactive_by;
    private String bank_name;
    private BigDecimal iuran_perbulan;
    private Short office;

    public PegawaiKoperasiDTO(
            Integer id,
            String employeeno,
            Date join_date,
            String grade_id,
            String code,
            String fullname,
            String employee_status_name,
            Integer company_id,
            String company_name,
            String locator,
            String division_name,
            Timestamp create_at,
            Timestamp update_at,
            String active,
            String sync,
            String update_by,
            Date join_date_koperasi,
            String bank_account_number,
            Timestamp mutasi_at,
            String mutasi_by,
            Timestamp inactive_at,
            String inactive_by,
            String bank_name,
            BigDecimal iuran_perbulan,
            Short office
    ) {
        this.id = id;
        this.employeeno = employeeno;
        this.join_date = join_date != null ? join_date.toLocalDate() : null;
        this.grade_id = grade_id;
        this.code = code;
        this.fullname = fullname;
        this.employee_status_name = employee_status_name;
        this.company_id = company_id;
        this.company_name = company_name;
        this.locator = locator;
        this.division_name = division_name;
        this.create_at = create_at != null ? create_at.toLocalDateTime() : null;
        this.update_at = update_at != null ? update_at.toLocalDateTime() : null;
        this.active = active;
        this.sync = sync;
        this.update_by = update_by;
        this.join_date_koperasi = join_date_koperasi != null ? join_date_koperasi.toLocalDate() : null;
        this.bank_account_number = bank_account_number;
        this.mutasi_at = mutasi_at != null ? mutasi_at.toLocalDateTime() : null;
        this.mutasi_by = mutasi_by;
        this.inactive_at = inactive_at != null ? inactive_at.toLocalDateTime() : null;
        this.inactive_by = inactive_by;
        this.bank_name = bank_name;
        this.iuran_perbulan = iuran_perbulan;
        this.office = office;
    }
}
