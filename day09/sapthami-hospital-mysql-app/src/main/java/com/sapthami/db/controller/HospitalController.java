package com.sapthami.db.controller;

import com.sapthami.db.model.Hospital;
import com.sapthami.db.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/hospital")
public class HospitalController {
    @Autowired
    HospitalRepository hospitalRepository;
    @GetMapping(value = "/get")
    public @ResponseBody
    Iterable<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    @PostMapping(value = "/save")
    public @ResponseBody
    String store(@RequestBody final Hospital hospital) {
        hospitalRepository.save(hospital);
        return "saved";
    }


    @DeleteMapping(value = "/delete")
    public @ResponseBody
    String store(@RequestParam("id") final int id) {
        hospitalRepository.deleteById(id);
        return "deleted";
    }

}
