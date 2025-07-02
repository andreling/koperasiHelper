package com.api.koperasi_sci.Model.Koperasi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_setoran", schema = "appkoperasi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String periode;

    private BigDecimal jumlah;

    private String employeeno;

    private String file;

    private Integer apprvl;

    private String apprvlby;

    private LocalDateTime apprvltat;

    private LocalDateTime createdat;

    private Integer status;

    @Column(columnDefinition = "text")
    private String keterangan;

    private Integer tahun;

    private String createdby;

    private LocalDateTime bayarat;

    private Integer isweb;

    private String useridweb;

    private LocalDateTime updatedat;

    private String updatedby;

    private String headunit;

    private LocalDateTime mutasi_at;

    private String mutasi_by;

    private BigDecimal setoran_bulan_ini;

    private String periode_koperasi;
}
