package com.api.koperasi_sci.Repository.Koperasi;

import com.api.koperasi_sci.Model.Koperasi.AngsuranPinjaman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AngsuranPinjamanRepo extends JpaRepository<AngsuranPinjaman, Integer> {
    List<AngsuranPinjaman> findAllByPinjamanId(Integer pinjamanId);

    List<AngsuranPinjaman> getAngsuranPinjamanById(Integer id);
}
