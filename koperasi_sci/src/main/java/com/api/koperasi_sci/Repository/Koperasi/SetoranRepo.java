package com.api.koperasi_sci.Repository.Koperasi;

import com.api.koperasi_sci.Model.Koperasi.Setoran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetoranRepo extends JpaRepository<Setoran, Integer> {
    List<Setoran> findAllByEmployeenoAndPeriodeAndTahun(String employeeno, String periode, Integer tahun);
}
