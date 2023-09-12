package com.sapthami.db.repository;

import com.sapthami.db.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}

