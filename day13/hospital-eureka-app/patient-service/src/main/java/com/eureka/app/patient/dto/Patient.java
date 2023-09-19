package com.eureka.app.patient.dto;

public class Patient
{
    private String patientname;
    private String disease;
     
    public Patient(String patientname, String disease) {
        super();
        this.patientname = patientname;
        this.disease = disease;
    }
 
    public String getPatientname() {
        return patientname;
    }
 
    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
 
    public String getDisease() {
        return disease;
    }
 
    public void setDisease(String disease) {
        this.disease = disease;
    }
}
