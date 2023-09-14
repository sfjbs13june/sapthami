package com.sapthami.app.controller;


import com.sapthami.app.module.Hospital;
import com.sapthami.app.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalRepository hospitalRepo;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Hospital create(@RequestBody Hospital hospital) {
        hospital=hospitalRepo.save(hospital);
        return hospital;
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<Hospital> readHospital(){return hospitalRepo.findAll();}

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void modifyByID(@RequestParam String hospital_id,@RequestParam String address){
        Hospital hospital=hospitalRepo.findByhospitalID(hospital_id);
        hospital.setAddress(address);
        hospitalRepo.save(hospital);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void deleteById(@RequestParam String hospital_id){hospitalRepo.deleteByhospital_id(hospital_id);}

}