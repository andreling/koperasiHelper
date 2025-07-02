package com.api.koperasi_sci.Repository.Koperasi;

import com.api.koperasi_sci.Model.Koperasi.Pinjaman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PinjamanRepo extends JpaRepository<Pinjaman, Integer> {
    List<Pinjaman> getPinjamanByEmployeenoOrderByIdDesc(String employeeno);
}
