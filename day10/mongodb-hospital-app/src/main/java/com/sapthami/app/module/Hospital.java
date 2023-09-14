package com.sapthami.app.module;

import org.springframework.data.annotation.Id;

public class Hospital {

    @Id
    String hospital_id;
    String hospital_name;
    String address;

    public Hospital() {
    }

    public Hospital(String hospital_id, String hospital_name, String address) {
        this.hospital_id = hospital_id;
        this.hospital_name = hospital_name;
        this.address = address;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
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
