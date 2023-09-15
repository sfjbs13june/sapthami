package com.sapthami.rabbitmq.controller;

import com.sapthami.rabbitmq.model.Hospital;
import com.sapthami.rabbitmq.model.Patient;
import com.sapthami.rabbitmq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class WebController {
  @Autowired
  RabbitMQSender rabbitMQSender;

  @GetMapping(value = "/producer")
  public String producer1(@RequestParam("hospitalName") String hospitalName,@RequestParam("hospitalId") String hospitalId, @RequestParam("hospitalAddress") String hospitalAddress) {

    Hospital hosp =new Hospital();
    hosp.setHospitalName(hospitalName);
    hosp.setHospitalId(hospitalId);
    hosp.setHospitalAddress(hospitalAddress);
    rabbitMQSender.send(hosp);
    return "Message sent to the hospital RabbitMQ  Successfully";
  }

  @GetMapping(value = "/producer")
  public String producer2(@RequestParam("patientId") String patientId, @RequestParam("patientName") String patientName,@RequestParam("hospitalName") String hospitalName, @RequestParam("disease") String disease) {

    Patient pnt =new Patient();
    pnt.setPatientId(patientId);
    pnt.setPatientName(patientName);
    pnt.setHospitalName(hospitalName);
    pnt.setDisease(disease);
    rabbitMQSender.send(pnt);
    return "Message sent to the patient RabbitMQ  Successfully";
  }

  @PostMapping(value = "/hospital")
  public String postHospital(@RequestBody Hospital hospital) {
    rabbitMQSender.send(hospital);

    return "Message sent to the RabbitMQ  Successfully";
  }

  @PostMapping(value = "/patient")
  public String postPatient(@RequestBody Patient patient) {

    rabbitMQSender.send(patient);

    return "Message sent to the Patient RabbitMQ  Successfully";
  }
}
