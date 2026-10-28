package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repositry.PatientRepositry;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {
    private PatientRepositry patientRepositry;

    public PatientService(PatientRepositry patientRepositry){
        this.patientRepositry = patientRepositry;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> patients = patientRepositry.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient(
            @Valid PatientRequestDTO patientRequestDTO) {

        Patient newPatient = PatientMapper.toModel(patientRequestDTO);

        Patient savedPatient = patientRepositry.save(newPatient);

        return PatientMapper.toDTO(savedPatient);
    }
}
