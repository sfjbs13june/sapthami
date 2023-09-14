package com.sapthami.db.controller;


import com.sapthami.db.model.Patient;
import com.sapthami.db.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/save")
    public @ResponseBody
    String createPatient(@RequestBody final Patient patient){
       patientRepository.save(patient);
       return "saved";
    }

    @GetMapping("/get")
    public @ResponseBody
    Iterable<Patient> getAll(){
        return patientRepository.findAll();
    }

    @DeleteMapping("/delete")
    public @ResponseBody
    String store(@RequestParam("id") final int id) {
        patientRepository.deleteById(id);
        return "deleted";
    }
}
