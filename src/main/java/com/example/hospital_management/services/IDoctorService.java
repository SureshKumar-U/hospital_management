package com.example.hospital_management.services;

import com.example.hospital_management.dtos.DoctorRequestDto;
import com.example.hospital_management.dtos.DoctorResponseDto;

public interface IDoctorService {
    DoctorResponseDto createDoctor(DoctorRequestDto requestDto);
    DoctorResponseDto getDoctorById(Long doctorId);
    void deleteDoctorById(Long doctorId);
}
