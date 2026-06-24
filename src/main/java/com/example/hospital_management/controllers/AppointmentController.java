package com.example.hospital_management.controllers;


import com.example.hospital_management.dtos.AppointmentRequestDto;
import com.example.hospital_management.dtos.AppointmentResponseDto;
import com.example.hospital_management.models.AppointMentModel;
import com.example.hospital_management.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponseDto> createAppointment(@RequestBody AppointmentRequestDto request){
         return new ResponseEntity<>(appointmentService.createAppointment(request), HttpStatus.CREATED);
    }
    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponseDto> getAppointmentById(@PathVariable Long appointmentId){
        return  ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId));
    }
}
