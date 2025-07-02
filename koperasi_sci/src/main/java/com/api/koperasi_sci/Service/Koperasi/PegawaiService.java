//package com.api.koperasi_sci.Service.Koperasi;
//
//import com.api.koperasi_sci.DTO.PegawaiKoperasiDTO;
//import com.api.koperasi_sci.Model.Koperasi.Pegawai;
//import com.api.koperasi_sci.Model.Koperasi.Setoran;
//import com.api.koperasi_sci.Repository.Koperasi.PegawaiRepo;
//import com.api.koperasi_sci.Repository.Koperasi.SetoranRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class PegawaiService {
//
//    @Autowired
//    PegawaiRepo repository;
//
//    @Autowired
//    SetoranRepo setoranRepo;
//
//    public List<PegawaiKoperasiDTO> getAllPegawai(String NIK) {
//        List<PegawaiKoperasiDTO> listStaff;
//
//        if(!NIK.equalsIgnoreCase("")) {
//            List<String> staffIds = Arrays.asList(NIK.split(","));
//            listStaff = repository.getActiceStaffNotSync(staffIds);
//        } else {
//            listStaff = repository.getAllActiveStaffNotSync(List.of(6, 34, 36, 40));
//        }
//
//        int currentYear = LocalDate.now().getYear();
//
//        List<Integer> years = Arrays.asList(
//                currentYear,
//                currentYear+1
//        );
//
//        List<String> months = Arrays.asList(
//                "JANUARI",
//                "FEBRUARI",
//                "MARET",
//                "APRIL",
//                "MEI",
//                "JUNI",
//                "JULI",
//                "AGUSTUS",
//                "SEPTEMBER",
//                "OKTOBER",
//                "NOVEMBER",
//                "DESEMBER"
//        );
//
//
//        for (PegawaiKoperasiDTO p : listStaff) {
//            LocalDate a = p.getJoin_date();
//            LocalDate b = LocalDate.now().withDayOfMonth(26);
//
//            long dateDiff = Math.abs(ChronoUnit.DAYS.between(a, b));
//
//            if(dateDiff > 90) {
//                for(Integer year : years) {
//                    for (String month : months) {
//                        List<Setoran> setoranList = setoranRepo.findAllByEmployeenoAndPeriodeAndTahun(
//                                p.getEmployeeno(),
//                                month,
//                                year
//                        );
//
//                        if(!setoranList.isEmpty()) {
//                            Integer selectedYear = month.equalsIgnoreCase("DESEMBER") ? year : year+1;
//                            Setoran s = new Setoran();
//                            s.setPeriode(month);
//                            s.setEmployeeno(p.getEmployeeno());
//                            s.setCreatedat(LocalDateTime.now());
//                            s.setTahun(year);
//                            s.setPeriode_koperasi(String.valueOf(selectedYear));
//
//                            Setoran saved = setoranRepo.save(s);
//                            if(saved != null) {
//
//                                repository.save()
//                            }
//
//                            $dataupdate['sync'] = 1;
//                            $where['employeeno'] = $value['employeeno'];
//                            $dataupdate['join_date_koperasi'] = date('Y-m-d');
//                            $dataupdate['update_at'] = date('Y-m-d H:i:s');
//                            $this->Main_model->update_ci_v2("appkoperasi.pegawai_pboz_koperasi", $dataupdate, $where);
//
//                        }
//                        $this->db->select("*");
//                        $this->db->from("appkoperasi.tb_setoran");
//                        $this->db->where("employeeno", $EmployeeNo);
//                        $this->db->where("periode", $periode);
//                        $this->db->where("tahun", $year);
//                    }
//
//                }
//                System.out.println("yes");
//            } else {
//                System.out.println("no");
//            }
//
//
//        }
//
//
//
//
//        return listStaff;
//    }
//}
