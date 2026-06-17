package com.example.hospital_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class PatientModel extends BaseModel  {
    private String name;

    private int age;

    private String Gender;




}
