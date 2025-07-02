package com.api.koperasi_sci.Model.Koperasi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_angsuran_pinjaman", schema = "appkoperasi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AngsuranPinjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_pinjaman")
    private Integer pinjamanId;

    @Column(name = "jumlah_pinjaman")
    private BigDecimal jumlahPinjaman;

    @Column(name = "periode")
    private String periode;

    @Column(name = "status")
    private Short status;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "file")
    private String file;

    @Column(name = "jumlah_cicilan")
    private BigDecimal jumlahCicilan;

    @Column(name = "employeeno")
    private String employeeno;

    @Column(name = "apprvl_at")
    private LocalDateTime approvalAt;

    @Column(name = "apprvl_by")
    private String approvalBy;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "bayar_at")
    private LocalDateTime bayarAt;

    @Column(name = "updatedat")
    private LocalDateTime updatedAt;

    @Column(name = "updatedby")
    private Integer updatedBy;

    @Column(name = "tahun")
    private String tahun;

    @Column(name = "headunit")
    private String headUnit;

}
