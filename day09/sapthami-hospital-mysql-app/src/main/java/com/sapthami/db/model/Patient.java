package com.sapthami.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "p_id")
    private Integer p_id;
    @Column(name = "patient_name")
    private String patient_name;
    @Column(name = "hospital_name")
    private String hospital_name;
    @Column(name = "disease")
    private String disease;

    public Patient() {
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
