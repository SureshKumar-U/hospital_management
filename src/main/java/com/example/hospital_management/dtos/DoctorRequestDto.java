package com.example.hospital_management.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorRequestDto {
    String name;
    int age;
    String speciality;
}
