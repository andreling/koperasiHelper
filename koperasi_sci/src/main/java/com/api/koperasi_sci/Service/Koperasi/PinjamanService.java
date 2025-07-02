package com.api.koperasi_sci.Service.Koperasi;

import com.api.koperasi_sci.DTO.LoanInfo;
import com.api.koperasi_sci.Model.Koperasi.AngsuranPinjaman;
import com.api.koperasi_sci.Model.Koperasi.Pegawai;
import com.api.koperasi_sci.Model.Koperasi.Pinjaman;
import com.api.koperasi_sci.Repository.Koperasi.AngsuranPinjamanRepo;
import com.api.koperasi_sci.Repository.Koperasi.PegawaiRepo;
import com.api.koperasi_sci.Repository.Koperasi.PinjamanRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PinjamanService {

    @Autowired
    PinjamanRepo loanRepo;

    @Autowired
    AngsuranPinjamanRepo angsuranPinjamanRepo;

    @Autowired
    PegawaiRepo staffRepo;

    public List<LoanInfo> checkLoanByNIK(String NIK) {
        String[] staffIds = NIK.split(",");
        List<LoanInfo> result = new ArrayList<>();

        for (String staffId : staffIds) {
            List<Pinjaman> loanList = loanRepo.getPinjamanByEmployeenoOrderByIdDesc(
                    staffId
            );

            Optional<Pinjaman> latestLoan = loanList.stream().findFirst();
            if(latestLoan.isPresent()) {
                Pinjaman temp = latestLoan.get();
                LoanInfo loan = infoGenerator(temp, staffId);

                result.add(loan);
            }
        }
        return result;
    }

    public List<AngsuranPinjaman> getAngsuranPinjamanByNIK(String NIK) {
        String[] staffIds = NIK.split(",");
        List<AngsuranPinjaman> list = new ArrayList<>();
        for (String staffId : staffIds) {
            List<Pinjaman> loanList = loanRepo.getPinjamanByEmployeenoOrderByIdDesc(
                    staffId
            );

            Optional<Pinjaman> latestLoan = loanList.stream().findFirst();
            if(latestLoan.isPresent()) {
                Integer pinjamanId = latestLoan.get().getId();
                list = angsuranPinjamanRepo.findAllByPinjamanId(pinjamanId);
            }
        }
        return list;
    }

    public void deleteAngsuranRow(Integer id) {
        System.out.println("testing");
        angsuranPinjamanRepo.deleteById(id);
    }

    public AngsuranPinjaman getCurrentRow(Integer id) {
        Optional<AngsuranPinjaman> angsuran =  angsuranPinjamanRepo.findById(id);
        return angsuran.orElse(null);
    }


    public void updateAngsuranRow(AngsuranPinjaman angsuranPinjaman) {
        angsuranPinjamanRepo.save(angsuranPinjaman);
    }


    public List<AngsuranPinjaman> addAngsuranRow(AngsuranPinjaman angsuran) {
        angsuranPinjamanRepo.save(angsuran);
        return getAngsuranPinjamanByNIK(angsuran.getEmployeeno());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ApproverInfo {
        private String name;
        private String nik;
        private String approval;
    }

    private LoanInfo infoGenerator(Pinjaman temp, String staffId) {
        LoanInfo loan = new LoanInfo();

        String loanStatus;
        switch (temp.getStatus()) {
            case 0:
                loanStatus = "PENDING";
                break;
            case 1:
                loanStatus = "APPROVED";
                break;
            case 2:
                loanStatus = "REJECTED";
                break;
            default:
                loanStatus = "UNKNOWN";
                break;
        }

        loan.setBorrower(staffId);
        loan.setCreatedAt(temp.getCreate_at());
        loan.setLoanStatus(loanStatus);
        loan.setTotalLoan(temp.getJumlah_pinjaman());
        loan.setTenor(Integer.valueOf(temp.getTenor()));
        loan.setPaymentPerMonth(temp.getCicilan_perbulan());
        loan.setMicNIK(temp.getMic());

        ApproverInfo mic = approverInfoGenerator(temp.getMic(), temp.getAcc_mic());
        ApproverInfo hrd = approverInfoGenerator(temp.getHrd(), temp.getAcc_hrd());
        ApproverInfo headUnit = approverInfoGenerator(temp.getHead_unit(), temp.getAcc_head_unit());

        loan.setMicName(mic.getName());
        loan.setMicNIK(mic.getNik());
        loan.setMicApproval(mic.getApproval());

        loan.setHrdName(hrd.getName());
        loan.setHrdNIK(hrd.getNik());
        loan.setHrdApproval(hrd.getApproval());

        loan.setHeadUnitName(headUnit.getName());
        loan.setHeadUnitNIK(headUnit.getNik());
        loan.setHeadUnitApproval(headUnit.getApproval());

        loan.setConclusion(generateConclusion(loan));

        return loan;
    }

    private String approvalChecker(Short x) {
        return x == 0 ? "Rejected" : "Accepted";
    }

    private ApproverInfo approverInfoGenerator(String nik, Short approval) {
        ApproverInfo info = new ApproverInfo();

        if(nik == null || nik.isBlank()) {
            info.setName("Empty");
            info.setNik("Empty");
            info.setApproval("Empty");
        } else {
            Pegawai staff = staffRepo.findByEmployeeNo(nik);
            if(staff!=null) {
                info.setName(staff.getFullname());
            } else {
                info.setName("Empty");
            }
            info.setNik(nik);
            info.setApproval(approvalChecker(approval));
        }

        return info;
    }

    private String generateConclusion(LoanInfo info) {
        return String.format(
                "Pinjaman %s - proses_status = %s | MIC %s - %s - approval = %s | HRD %s - %s - approval = %s | Head Unit %s - %s - approval = %s",
                info.getBorrower(),
                info.getLoanStatus(),
                info.getMicNIK(), info.getMicName(), info.getMicApproval(),
                info.getHrdNIK(), info.getHrdName(), info.getHrdApproval(),
                info.getHeadUnitNIK(), info.getHeadUnitName(), info.getHeadUnitApproval()
        );
    }
}
