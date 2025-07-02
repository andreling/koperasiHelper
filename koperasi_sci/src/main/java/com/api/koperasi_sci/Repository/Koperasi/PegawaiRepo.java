package com.api.koperasi_sci.Repository.Koperasi;

import com.api.koperasi_sci.DTO.PegawaiKoperasiDTO;
import com.api.koperasi_sci.Model.Koperasi.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PegawaiRepo extends JpaRepository<Pegawai, Integer> {

    @Query(value = """
        SELECT a.*, b.office
        FROM appkoperasi.pegawai_pboz_koperasi a
        JOIN appkoperasi.locator_wh_koperasi b ON b.locator = a.locator
        WHERE a.sync = '0'
          AND a.active = '1'
          AND b.office = '0'
          AND a.company_id IN (:companyIds)
        ORDER BY a.join_date
    """, nativeQuery = true)
    List<PegawaiKoperasiDTO> getAllActiveStaffNotSync(@Param("companyIds") List<Integer> companyIds);

    @Query(value = """
        SELECT a.*, b.office
        FROM appkoperasi.pegawai_pboz_koperasi a
        JOIN appkoperasi.locator_wh_koperasi b ON b.locator = a.locator
        WHERE a.sync = '0' 
          AND a.active = '1' 
          AND b.office = '0' 
          AND a.employeeno IN (:staffIds)
        ORDER BY a.join_date
    """, nativeQuery = true)
    List<PegawaiKoperasiDTO> getActiceStaffNotSync(@Param("staffIds") List<String> staffIds);

    Pegawai findByEmployeeNo(String employeeNo);
}
