package com.example.hospital_management.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @PostMapping()
    public ResponseEntity<String> createDoctor(){
        return new ResponseEntity<>("Doctor created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long doctorId){
        return ResponseEntity.ok("doctor details updated successfully");

    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId){
        return ResponseEntity.ok("doctor deleted successfully");
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<String> getDoctorDetails(@PathVariable Long doctorId){
        return ResponseEntity.ok("doctor details fetched successfully");
    }

}
