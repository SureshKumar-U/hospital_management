package com.example.hospital_management.services;

import com.example.hospital_management.Repositories.PatientRepository;
import com.example.hospital_management.dtos.PatientRequestDTO;
import com.example.hospital_management.dtos.PatientResponseDTO;
import com.example.hospital_management.exceptions.ResouceNotFoundException;
import com.example.hospital_management.models.PatientModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService{

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepo){
      this.patientRepository = patientRepo;
    }



    @Override
    public List<PatientResponseDTO> getAllPatients(){
        List<PatientModel> patients = patientRepository.findAll();
         return patients.stream().map(
                 patient-> {
                      PatientResponseDTO patientResponse = new PatientResponseDTO();
                      patientResponse.setId(patient.getId());
                      patientResponse.setName(patient.getName());
                      patientResponse.setAge(patient.getAge());
                      patientResponse.setGender(patient.getGender());
                      return patientResponse ;
                 }
         ).collect(Collectors.toList());
    };
    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientDto ){
        PatientModel patient = new PatientModel();
                patient.setName(patientDto.getName());
                patient.setAge(patientDto.getAge());
                patient.setGender(patientDto.getGender());
                patientRepository.save(patient);

        return PatientResponseDTO.builder()
                .age(patient.getAge())
                .name(patient.getName())
                .gender(patient.getGender())
                .id(patient.getId())
                .build();


    };
    @Override
    public void deletePatient(Long patientId){
        patientRepository.deleteById(patientId);

    };

    public PatientResponseDTO getPatientById(Long patientId){
      PatientModel patientEntity =   patientRepository.findById(patientId).orElseThrow(()-> new ResouceNotFoundException("Patient Not Found"));
           return PatientResponseDTO.builder()
                   .id(patientEntity.getId())
                   .name(patientEntity.getName())
                   .gender(patientEntity.getGender())
                   .age(patientEntity.getAge())
                   .build();


    };

    @Override
    public PatientResponseDTO updatePatient(Long patientId, PatientRequestDTO updatePatientDto){
        PatientModel patientEntity = patientRepository.findById(patientId).orElse(null);
        if(patientEntity == null){
            return null;
        }

        patientEntity.setName(updatePatientDto.getName());
        patientEntity.setGender(updatePatientDto.getGender());
        patientEntity.setAge(updatePatientDto.getAge());

        patientRepository.save(patientEntity);

    return PatientResponseDTO.builder()
            .id(patientEntity.getId())
            .name(patientEntity.getName())
            .age(patientEntity.getAge())
            .gender(patientEntity.getGender())
            .build();
    };





}
