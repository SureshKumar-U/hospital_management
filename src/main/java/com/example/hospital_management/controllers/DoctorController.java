package com.example.hospital_management.controllers;

import com.example.hospital_management.dtos.DoctorRequestDto;
import com.example.hospital_management.dtos.DoctorResponseDto;
import com.example.hospital_management.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {
   private final DoctorService doctorService;

    @PostMapping()
    public ResponseEntity<DoctorResponseDto> createDoctor(@RequestBody DoctorRequestDto requestDto){
        return new ResponseEntity<>(doctorService.createDoctor(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorResponseDto> getDoctorById(@PathVariable Long doctorId){
        return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
    }
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId){
        doctorService.deleteDoctorById(doctorId);
        return ResponseEntity.ok("Doctor deleted successfully");
    }


}
