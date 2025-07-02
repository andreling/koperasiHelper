package com.api.koperasi_sci.Controller;

import com.api.koperasi_sci.Model.Koperasi.AngsuranPinjaman;
import com.api.koperasi_sci.Service.Koperasi.PinjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    PinjamanService service;

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam String NIK) {
        List<AngsuranPinjaman> list = service.getAngsuranPinjamanByNIK(NIK);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> getAngsuranPinjaman(@RequestParam("id") Integer id) {

            System.out.println(id);
            service.deleteAngsuranRow(id);


        return new ResponseEntity<>(HttpStatus.OK);
    }
}