package com.sapthami.app.controller;

import com.sapthami.app.model.Prescription;
import com.sapthami.app.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionRepository prescriptionRepository;

    @GetMapping("/viewprescription")
    public @ResponseBody Object getAllPrescriptions(@RequestParam final String patientName) {
       Iterable<Prescription> prescriptionList = prescriptionRepository.findAll();
        List<Prescription> requiredPrescriptions = new ArrayList<>();
        for (Prescription prescription :prescriptionList) {
            if(prescription.getPatientName().equals(patientName)) {
                requiredPrescriptions.add(prescription);
            }
        }
        return requiredPrescriptions.size()>0?requiredPrescriptions:"No Prescriptions Found";
    }

    @PostMapping("/saveprescription")
    public @ResponseBody String store(@RequestBody final Prescription prescription) {
        Iterable<Prescription> prescriptionList = prescriptionRepository.findAll();
        for (Prescription data:
                prescriptionList) {
            if(data.getPrescriptionId().equals(prescription.getPrescriptionId())) return "Prescription ID already exists";
            if(data.getAppointmentId().equals(prescription.getAppointmentId())) return "Appointment ID already exists";
        }
        prescriptionRepository.save(prescription);
        return "Prescription Saved Successsfully";
    }
}
