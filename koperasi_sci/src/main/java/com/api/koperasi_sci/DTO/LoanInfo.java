package com.api.koperasi_sci.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanInfo {
    String borrower;
    LocalDateTime createdAt;
    String loanStatus;
    BigDecimal totalLoan;
    Integer tenor;
    BigDecimal paymentPerMonth;
    String micNIK;
    String micName;
    String micApproval;
    String hrdNIK;
    String hrdName;
    String hrdApproval;
    String headUnitNIK;
    String headUnitName;
    String headUnitApproval;
    String conclusion;
}