package com.api.koperasi_sci.Controller;

import com.api.koperasi_sci.DTO.LoanInfo;
import com.api.koperasi_sci.DTO.PegawaiKoperasiDTO;
import com.api.koperasi_sci.Model.Koperasi.AngsuranPinjaman;
import com.api.koperasi_sci.Repository.Koperasi.AngsuranPinjamanRepo;
import com.api.koperasi_sci.Repository.Koperasi.PinjamanRepo;
import com.api.koperasi_sci.Service.Koperasi.PinjamanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/loan")
public class PinjamanController {

    @Autowired
    PinjamanService service;

    @Autowired
    AngsuranPinjamanRepo repo;

    private static final Logger logger = LoggerFactory.getLogger(PinjamanController.class);

    @GetMapping("/check")
    public String getLoanInfo(@RequestParam(required = false) String nik, Model model) {
        try {
            List<LoanInfo> loans = service.checkLoanByNIK(nik);
            model.addAttribute("loans", loans);
        } catch (RuntimeException e) {
            logger.error("An error occurred", e);
            e.printStackTrace();
        }

        return "fragments/loan_result :: loanTableFragment";
    }

//    @GetMapping("/view")
//    public String getAngsuranPinjaman(@RequestParam(required = false) String nik, Model model) {
//        try {
//            List<AngsuranPinjaman> angsuran = service.getAngsuranPinjamanByNIK(nik);
//
//            if (angsuran.isEmpty()) {
//                return "fragments/no_data :: noData";
//            }
//
//            model.addAttribute("angsuran", angsuran);
//        } catch (RuntimeException e) {
//            logger.error("An error occurred", e);
//            e.printStackTrace();
//        }
//
//        return "index :: table";
//    }

    @GetMapping("/view")
    public String getAngsuranPinjaman(@RequestParam(required = false) String nik, Model model) {
        try {
            List<AngsuranPinjaman> angsuran = service.getAngsuranPinjamanByNIK(nik);

            if (angsuran.isEmpty()) {
                return "fragments/no_data :: noData";
            } else {
                Integer loanId = angsuran.getFirst().getPinjamanId();

                model.addAttribute("angsuran", angsuran);
                model.addAttribute("nik", nik);
                model.addAttribute("loanId", loanId);
            }


        } catch (RuntimeException e) {
            logger.error("An error occurred", e);
            e.printStackTrace();
        }

        return "fragments/angsuran :: loanViewWrapper";
    }

    @GetMapping("/state-fragment")
    public String getNikFragment(@RequestParam String nik, Model model) {
        // Your logic to fetch loan ID by nik
        List<AngsuranPinjaman> list = service.getAngsuranPinjamanByNIK(nik);
        if(!list.isEmpty()) {
            Integer loanId = list.getFirst().getPinjamanId();

            model.addAttribute("nik", nik);
            model.addAttribute("loanId", loanId);
        } else {
            model.addAttribute("nik", "");
            model.addAttribute("loanId", "");
        }




        return "fragments/hidden_value_nik :: nikField"; // This returns just the fragment
    }

    @PostMapping("/load/data")
    public String setValue(@RequestParam("nik") String nik, Model model) {
        System.out.println("testing" + nik);
        model.addAttribute("nik", nik);
        return "index :: nik";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<?> getAngsuranPinjaman(@RequestParam("id") Integer id) {
        try {
            System.out.println(id); // Debug log
            service.deleteAngsuranRow(id);
            return ResponseEntity.ok().build(); // Return success status
        } catch (RuntimeException e) {
            logger.error("An error occurred", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/add")
    public String addRow(@RequestParam(required = false) String nik, @RequestParam(required = false) Integer loanId,Model model) {
        try {
            AngsuranPinjaman angsuran = new AngsuranPinjaman();
            angsuran.setCreatedAt(LocalDateTime.now());
            angsuran.setStatus((short) 0);
            angsuran.setEmployeeno(nik);
            angsuran.setPinjamanId(loanId);
            System.out.println(nik);
            System.out.println(loanId);
            List<AngsuranPinjaman> angsurans = service.addAngsuranRow(angsuran);
            model.addAttribute("angsuran", angsurans);
        } catch (RuntimeException e) {
            logger.error("An error occurred", e);
            e.printStackTrace();
        }

        return "fragments/Angsuran_table :: angsuran";
    }

    @GetMapping("/get/current/row")
    public String getCurrentRow(@RequestParam(required = false) Integer id, Model model) {
        AngsuranPinjaman angsuran = service.getCurrentRow(id);
        System.out.println("here");
        System.out.println(id);
        System.out.println(angsuran);
        model.addAttribute("item", angsuran);

        return "fragments/Update_table :: editRow";
    }
    @PutMapping("/update")
    public String updateAngsuran(
            @RequestParam Integer id,
                                 @RequestParam String tahun,
                                 @RequestParam String periode,
                            @RequestParam BigDecimal jumlahPinjaman,
                                 @RequestParam BigDecimal jumlahCicilan,
                                 Model model) {
        AngsuranPinjaman test = service.getCurrentRow(id);
        test.setTahun(tahun);
        test.setPeriode(periode);
        test.setJumlahPinjaman(jumlahPinjaman);
        test.setJumlahCicilan(jumlahCicilan);

        AngsuranPinjaman updated = repo.save(test);
        model.addAttribute("item", updated);
        return "fragments/view_row :: viewRow"; // back to non-edit row
    }

    @GetMapping("/view-row")
    public String updateAngsuran(
            @RequestParam Integer id,
            Model model) {
        AngsuranPinjaman test = service.getCurrentRow(id);
        model.addAttribute("item", test);
        return "fragments/view_row :: viewRow"; // back to non-edit row
    }




    @GetMapping("/")
    public String index() {
        return "index";
    }

}
