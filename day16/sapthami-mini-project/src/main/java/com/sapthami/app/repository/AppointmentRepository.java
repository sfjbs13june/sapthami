package com.sapthami.app.repository;
import com.sapthami.app.model.Appointment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public interface AppointmentRepository extends CrudRepository<Appointment, String>{
}
