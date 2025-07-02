package com.api.koperasi_sci.Model.Koperasi;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "locator_wh_koperasi", schema = "appkoperasi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Locator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "locator")
    private String locator;

    @Column(name = "name_locator")
    private String nameLocator;

    @Column(name = "active")
    private Integer active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private LocalDateTime createdBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "pt")
    private Integer pt;

    @Column(name = "office")
    private Integer office;

    @Column(name = "area")
    private String area;

    @Column(name = "kabupaten")
    private String kabupaten;

    @Column(name = "company_id")
    private Integer companyId;
}
