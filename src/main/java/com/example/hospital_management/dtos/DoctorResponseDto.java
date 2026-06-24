package com.example.hospital_management.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DoctorResponseDto {
    Long id;
    String name;
    int age;
    String speciality;
}
