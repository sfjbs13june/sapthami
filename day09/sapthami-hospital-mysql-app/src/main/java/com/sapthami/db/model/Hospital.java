package com.sapthami.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "hospital_name")
    private String hospital_name;
    @Column(name = "address")
    private String address;


    public Hospital() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
