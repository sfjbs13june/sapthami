package com.sapthami.app.repository;


import com.sapthami.app.module.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient,Integer> {
    public Patient findById(int pid);
    public void deleteById(int pid);
    public Patient save(Patient patient);
}
