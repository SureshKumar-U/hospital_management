package com.example.hospital_management.controllers;

import com.example.hospital_management.dtos.PatientRequestDTO;
import com.example.hospital_management.dtos.PatientResponseDTO;
import com.example.hospital_management.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor   // @RequiredArgsConstructor →  creates constructor for final fields
public class PatientController {

    private final PatientService patientService;

    @PostMapping()
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody PatientRequestDTO createPatientDTO){
        PatientResponseDTO newPatient = patientService.createPatient(createPatientDTO);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> getPatientDetails(@PathVariable Long patientId){
      PatientResponseDTO patient =   patientService.getPatientById(patientId);
       return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId){
        patientService.deletePatient(patientId);
        return ResponseEntity.ok("Patient delted successfully");
    }
    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable Long patientId, @RequestBody PatientRequestDTO patientDto){
      return  ResponseEntity.ok( patientService.updatePatient(patientId, patientDto));
    }



}
