package com.sapthami.db.controller;

import com.sapthami.db.model.Patient;
import com.sapthami.db.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    PatientRepository patientRepository;

    @GetMapping(value = "/get")
    public @ResponseBody
    Iterable<Patient> getAll() {
        return patientRepository.findAll();
    }


    @PostMapping(value = "/save")
    public @ResponseBody
    String store(@RequestBody final Patient patient) {
        patientRepository.save(patient);
        return "saved";
    }


    @DeleteMapping(value = "/delete")
    public @ResponseBody
    String store(@RequestParam("p_id") final int p_id) {
        patientRepository.deleteById(p_id);
        return "deleted";
    }
}
