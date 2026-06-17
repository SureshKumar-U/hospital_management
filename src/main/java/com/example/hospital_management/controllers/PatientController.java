package com.example.hospital_management.controllers;

import com.example.hospital_management.dtos.CreatePatientRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @PostMapping()
    public ResponseEntity<String> createPatient(@RequestBody CreatePatientRequestDTO createPatientDTO){
        return new ResponseEntity<>("patient created successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{patientId}")
    public ResponseEntity<String> getPatientDetails(@PathVariable Long patientId){
        return ResponseEntity.ok("patient details fetche successfully");
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId){
        return ResponseEntity.ok("Patient delted successfully");
    }
    @PutMapping("/{patientId")
    public ResponseEntity<String> updatePatient(@PathVariable Long patientId){
        return ResponseEntity.ok("patient deleted succesfully");
    }



}
