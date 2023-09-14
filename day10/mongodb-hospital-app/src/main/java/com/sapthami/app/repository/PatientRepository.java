package com.sapthami.app.repository;

import com.sapthami.app.module.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patients,String> {
    public Patients findBypatientId(String patient_id);
    public Patients deleteBypatientId(String patient_id);
    public Patients save(Patients patients);

}
