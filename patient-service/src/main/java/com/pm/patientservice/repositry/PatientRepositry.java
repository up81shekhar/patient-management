package com.pm.patientservice.repositry;

import com.pm.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepositry extends JpaRepository<Patient, UUID> {

}
