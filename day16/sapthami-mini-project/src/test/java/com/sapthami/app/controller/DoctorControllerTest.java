package com.sapthami.app.controller;

import com.sapthami.app.model.Appointment;
import com.sapthami.app.model.Prescription;
import com.sapthami.app.repository.AppointmentRepository;
import com.sapthami.app.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {


    @InjectMocks
    private DoctorController doctorController;

    @InjectMocks
    private PatientController patientController;

    @InjectMocks
    private PrescriptionController prescriptionController;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    public void getDoctorAppointmentTest() {
        Prescription prescription = new Prescription("12ab","2","The patient had throat Infection","Sapthami","Prem");
        Appointment appointment = new Appointment("2","Sapthami","Prem","23092023",prescription);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment);
        when(appointmentRepository.findAll()).thenReturn(appointments);
        List<Appointment> result = (List<Appointment>) doctorController.getAppointments("Prem");
        for (Appointment apnt:
                result) {
            assertEquals(appointment.getAppointmentId(),apnt.getAppointmentId());
            assertEquals(appointment.getPatientName(),apnt.getPatientName());
            assertEquals(appointment.getDoctorName(),apnt.getDoctorName());
            assertEquals(appointment.getDate(),apnt.getDate());
            assertEquals(appointment.getPrescription(),apnt.getPrescription());
        }

    }

    @Test
    public void saveDoctorAppointmentTest() {
        Prescription prescription = new Prescription("101ab","2","The patient had throat Infection","Sapthami","Prem");
        Appointment appointment = new Appointment("2","Sapthami","Prem","23092023",prescription);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        String response = doctorController.saveAppointment(appointment);
        assertEquals("Appointment " + appointment.getAppointmentId() + " saved Successfully",response);
    }

    @Test
    public void getPatientAppointmentTest() {
        Prescription prescription = new Prescription("101ab","2","The patient had throat Infection","Sapthami","Prem");
        Appointment appointment = new Appointment("2","Sapthami","Prem","23092023",prescription);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment);
        when(appointmentRepository.findAll()).thenReturn(appointments);
        List<Appointment> result = (List<Appointment>) patientController.getAppointments("Sapthami");
        for (Appointment ap:
                result) {
            assertEquals(appointment.getAppointmentId(),ap.getAppointmentId());
            assertEquals(appointment.getPatientName(),ap.getPatientName());
            assertEquals(appointment.getDoctorName(),ap.getDoctorName());
            assertEquals(appointment.getDate(),ap.getDate());
            assertEquals(appointment.getPrescription(),ap.getPrescription());
        }
    }

    @Test
    public void savePatientAppointmentTest() {
        Prescription prescription = new Prescription("101ab","2","The patient had throat Infection","Sapthami","Prem");
        Appointment appointment = new Appointment("2","Sapthami","Prem","23092023",prescription);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        String response = patientController.saveAppointment(appointment);
        assertEquals("Appointment " + appointment.getAppointmentId() + " saved Successfully",response);
    }

    @Test
    public void viewPrescriptionTest() {
        Prescription prescription = new Prescription("101ab","2","The patient had throat Infection","Sapthami","Prem");
        List<Prescription> list = new ArrayList<>();
        list.add(prescription);
        when(prescriptionRepository.findAll()).thenReturn(list);
        List<Prescription> response = (List<Prescription>) prescriptionController.getAllPrescriptions("Sapthami");
        for (Prescription pr:
                response) {
            assertEquals(prescription.getPrescriptionId(),pr.getPrescriptionId());
            assertEquals(prescription.getAppointmentId(),pr.getAppointmentId());
            assertEquals(prescription.getPatientName(),pr.getPatientName());
            assertEquals(prescription.getDoctorName(),pr.getDoctorName());
            assertEquals(prescription.getDescription(),pr.getDescription());
        }

    }

    @Test
    public void savePrescription() {
        Prescription prescription = new Prescription("101ab","2","The patient had throat Infection","Sapthami","Prem");
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        String response = prescriptionController.store(prescription);
        assertEquals("Prescription Saved Successsfully",response);
    }


}

