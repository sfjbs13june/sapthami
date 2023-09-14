package com.sapthami.app.repository;

import com.sapthami.app.module.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

    public Hospital findByhospitalID(String hospital_id);
    public Hospital deleteByhospital_id(String hospital_id);
    public Hospital save(Hospital hospital);
}
