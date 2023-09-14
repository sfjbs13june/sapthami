package com.sapthami.app.controller;

import com.sapthami.app.module.Patients;
import com.sapthami.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepo;

    @RequestMapping(value = "/save",method= RequestMethod.POST)
    public Patients create(@RequestBody Patients patients){
        patients =patientRepo.save(patients);
        return patients;
    }
    @RequestMapping(value="/get",method=RequestMethod.GET)
    public List<Patients> readPatient(){return patientRepo.findAll();}

    @RequestMapping(value = "/update",method=RequestMethod.PUT)
    public void modifyByID(@RequestParam String patient_id,@RequestParam String hospital_name){
        Patients patients =patientRepo.findBypatientId(patient_id);
        patients.setHospital_name(hospital_name);
        patientRepo.save(patients);
    }
    @RequestMapping(value = "/delete",method=RequestMethod.DELETE)
    public void deleteById(@RequestParam String patient_id){
        patientRepo.deleteBypatientId(patient_id);

    }
}
