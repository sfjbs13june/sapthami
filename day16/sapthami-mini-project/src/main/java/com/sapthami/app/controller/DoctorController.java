package com.sapthami.app.controller;


import com.sapthami.app.model.Appointment;
import com.sapthami.app.repository.AppointmentRepository;
import com.sapthami.app.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MapKeyColumn;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @GetMapping("/doctorappointment")
    public @ResponseBody Object getAppointments(@RequestParam final String doctorName) {
       Iterable<Appointment> appointments = appointmentRepository.findAll();
        List<Appointment> required = new ArrayList<>();
        for (Appointment appointment :
                appointments) {
            if (appointment.getDoctorName().equals(doctorName)) {
                required.add(appointment);
            }
        }

        return required.size()>0?required:"Appointments Not Found";
    }

    @PostMapping("/save")
    public @ResponseBody String saveAppointment(@RequestBody final Appointment appointment) {
        Iterable<Appointment> appointments = appointmentRepository.findAll();
        for (Appointment ap : appointments) {
            if(ap.getAppointmentId().equals(appointment.getAppointmentId())) {
                return "Appointment ID already exists";
            }

            if(ap.getDoctorName().equals(appointment.getDoctorName()) && ap.getPatientName().equals(appointment.getPatientName())){
                return "Appointment already exists for " + appointment.getPatientName() + " with Dr. " + appointment.getDoctorName();
            }

            if( ap.getPrescription().getPrescriptionId().equals(appointment.getPrescription().getPrescriptionId())) {
                return "Prescription ID already exists";
            }
        }
        if(appointment.getAppointmentId().equals(appointment.getPrescription().getAppointmentId()) &&
                appointment.getPatientName().equals(appointment.getPrescription().getPatientName()) &&
                appointment.getDoctorName().equals(appointment.getPrescription().getDoctorName())
        ) {
            appointmentRepository.save(appointment);
            prescriptionRepository.save(appointment.getPrescription());
            return "Appointment " + appointment.getAppointmentId() + " saved Successfully";
        }
        else return "Please check the input Data";
    }

}
