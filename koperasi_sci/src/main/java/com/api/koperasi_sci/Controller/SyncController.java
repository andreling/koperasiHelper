//package com.api.koperasi_sci.Controller;
//
//import com.api.koperasi_sci.DTO.PegawaiKoperasiDTO;
//import com.api.koperasi_sci.Model.Koperasi.Pegawai;
//import com.api.koperasi_sci.Service.Koperasi.PegawaiService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/sync")
//public class SyncController {
//
//    @Autowired
//    PegawaiService service;
//
//    private static final Logger logger = LoggerFactory.getLogger(SyncController.class);
//
//    @GetMapping("/active/employee/new")
//    public ResponseEntity<?> activeNewEmployee(@RequestParam(value = "NIK", required = false) String NIK) {
//        List<PegawaiKoperasiDTO> result;
//        try {
//            result = service.getAllPegawai(NIK);
//        } catch (RuntimeException e) {
//            logger.error("An error occurred", e);
//            return new ResponseEntity<>("[Failed] - Reason = " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.ok(result);
//    }
//}
