package com.api.koperasi_sci.Model.Koperasi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pinjaman", schema = "appkoperasi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pinjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 32)
    private String employeeno;

    @Column(precision = 24, scale = 2)
    private BigDecimal jumlah_pinjaman;

    @Column
    private Short tenor;

    @Column(precision = 24, scale = 2)
    private BigDecimal cicilan_perbulan;

    @Column
    private Short status;

    @Column
    private LocalDateTime create_at;

    @Column(columnDefinition = "text")
    private String keterangan;

    @Column(length = 50)
    private String apprvlby;

    @Column
    private LocalDateTime apprvlat;

    @Column
    private Short acc_mic;

    @Column(length = 50)
    private String mic;

    @Column
    private LocalDateTime acc_mic_at;

    @Column
    private Short acc_hrd;

    @Column(length = 50)
    private String hrd;

    @Column
    private LocalDateTime acc_hrd_at;

    @Column
    private Short acc_head_unit;

    @Column(length = 50)
    private String head_unit;

    @Column
    private LocalDateTime acc_head_unit_at;

    @Column
    private LocalDateTime acc_at;

    @Column
    private Short sudah_tf;

    @Column
    private LocalDateTime tgl_trf;

    @Column(length = 50)
    private String transfer_by;

    @Column
    private LocalDateTime transfer_at;

    @Column(precision = 24, scale = 2)
    private BigDecimal jumlah_pinjaman_awal;

    @Column(columnDefinition = "text")
    private String note_mic;

    @Column(columnDefinition = "text")
    private String note_hrd;

    @Column
    private String note_headunit;

    @Column
    private Short tahun;
}
