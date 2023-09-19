package com.eureka.app.patient.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eureka.app.patient.dto.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientServiceController {
 
    private static Map<String, List<Patient>> hospDB = new HashMap<String, List<Patient>>();
 
    static {
        hospDB = new HashMap<String, List<Patient>>();
 
        List<Patient> lst = new ArrayList<Patient>();
        Patient pnt = new Patient("Patient1", "Disease1");
        lst.add(pnt);
        pnt = new Patient("Patient2", "Disease2");
        lst.add(pnt);
 
        hospDB.put("Hospital1", lst);
 
        lst = new ArrayList<Patient>();
        pnt = new Patient("Patient3", "Disease3");
        lst.add(pnt);
        pnt = new Patient("Patient4", "Disease4");
        lst.add(pnt);
 
        hospDB.put("hospital2", lst);
 
    }
 
    @RequestMapping(value = "/getPatientDetailsForHospital/{hospitalname}", method = RequestMethod.GET)
    public List<Patient> getPatients(@PathVariable String hospitalname) {
        System.out.println("Getting Patient details for " + hospitalname);
 
        List<Patient> patientList = hospDB.get(hospitalname);
        if (patientList == null) {
            patientList = new ArrayList<Patient>();
            Patient pnt = new Patient("Not Found", "N/A");
            patientList.add(pnt);
        }
        return patientList;
    }
}