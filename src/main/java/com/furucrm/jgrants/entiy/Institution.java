package com.furucrm.jgrants.entiy;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jg2_institution")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 18)
    private String createdById;

    @Column
    private Date createdDate;

    @Column(length = 255)
    private String governmentType;

    @Column(length = 150)
    private String institutionName;

    @Column(length = 40)
    private String institutionNameShort;

    @Column(length = 255)
    private String institutionType;

    @Column(length = 80)
    private String jurisdictionOrganization;

    @Column(length = 18)
    private String lastModifiedById;

    @Column
    private Date lastModifiedDate;

    @Column(length = 255)
    private String ministry;

    @Column(length = 40)
    private String municipality;

    @Column(length = 255)
    private String prefecture;

    @Column(length = 80)
    private String name;
    
    @OneToMany(mappedBy = "institution")
    private Set<Subsidy> subsidies;
}
