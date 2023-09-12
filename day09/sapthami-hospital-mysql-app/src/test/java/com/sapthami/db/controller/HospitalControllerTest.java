package com.sapthami.db.controller;

import com.sapthami.db.model.Hospital;
import com.sapthami.db.model.Patient;
import com.sapthami.db.repository.HospitalRepository;
import com.sapthami.db.repository.PatientRepository;
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
public class HospitalControllerTest {
    @InjectMocks
    private HospitalController hospitalController;
    private PatientController patientController;

    @Mock
    private HospitalRepository hospitalRepository;
    private PatientRepository patientRepository;

    @Test
    public void getAllTest(){
        Hospital user1=new Hospital();
        user1.setId(1);
        user1.setHospital_name("hospital1");
        user1.setAddress("address1");

        Patient user2=new Patient();
        user2.setP_id(101);
        user2.setPatient_name("Patient1");
        user2.setHospital_name("hospital1");
        user2.setDisease("disease1");

        List<Hospital> hospitalList=new ArrayList<>();

        hospitalList.add(user1);
        when(hospitalRepository.findAll()).thenReturn(hospitalList);
        List<Hospital> results= (List<Hospital>) hospitalController.getAll();
        Hospital result =results.get(0);
        assertEquals(1,result.getId());
        assertEquals("hospital1",result.getHospital_name());
        assertEquals("bangalore",result.getAddress());

        List<Patient> patientList=new ArrayList<>();
        patientList.add(user2);
        when(patientRepository.findAll()).thenReturn(patientList);
        List<Patient> results1= (List<Patient>) patientController.getAll();
        Patient result2 =results1.get(0);
        assertEquals(1,result2.getP_id());
        assertEquals("patient1",result2.getPatient_name());
        assertEquals("hospital1",result2.getHospital_name());
        assertEquals("dengue fever",result2.getDisease());

    }

    @Test
    public void storeTest(){

    }

}
