package com.example.hospital_management.services;

import com.example.hospital_management.dtos.PatientRequestDTO;
import com.example.hospital_management.dtos.PatientResponseDTO;
import com.example.hospital_management.models.PatientModel;

import java.util.List;

public interface IPatientService {
    List<PatientResponseDTO> getAllPatients();
    PatientResponseDTO createPatient(PatientRequestDTO patient);
    void deletePatient(Long patientId);
    PatientResponseDTO updatePatient(Long patientId, PatientRequestDTO updatePatientDto);
}
