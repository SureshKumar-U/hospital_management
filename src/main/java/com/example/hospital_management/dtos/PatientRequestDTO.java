package com.example.hospital_management.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
public class PatientRequestDTO {
    String name;
    int age;
    String gender;

}
