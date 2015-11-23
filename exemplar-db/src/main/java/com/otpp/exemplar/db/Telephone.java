package com.otpp.exemplar.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@Entity
@IdClass(Telephone.class)
@Table(name = "CDP110")
public class Telephone implements Serializable {

    private static final long serialVersionUID = -5295623777870960565L;

    @Id
    @Column(name = "TEIENT")
    private String entityIrn;

    @Id
    @Column(name = "TECTEL")
    private String type;

    @Column(name = "TECROU")
    private String routing;

    @Column(name = "TECCOU")
    private String country;

    @Id
    @Column(name = "TECARE")
    private String areaCode;

    @Id
    @Column(name = "TECNUM")
    private String number;

    @Id
    @Column(name = "TECEXT")
    private String extension;

    @Column(name = "TENCOM")
    private String comment;
}
