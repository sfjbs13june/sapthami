package com.sapthami.app.repository;


import com.sapthami.app.module.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface HopsitalRepository extends MongoRepository<Hospital, Integer> {
    public Hospital findById(int id);
    public void deleteById(int id);
    public Hospital save(Hospital hospital);
}
