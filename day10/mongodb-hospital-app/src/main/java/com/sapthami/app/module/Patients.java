package com.sapthami.app.module;

public class Patients {

    String patient_name;
    String patient_id;
    String hospital_name;
    String disease;


    public Patients() {
    }

    public Patients(String patient_name, String patient_id, String hospital_name, String disease) {
        this.patient_name = patient_name;
        this.patient_id = patient_id;
        this.hospital_name = hospital_name;
        this.disease = disease;
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
