package com.example.hospital_management.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PatientResponseDTO {
    Long id;
    String name;
    String gender;
    int age;
}
