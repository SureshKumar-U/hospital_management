package com.example.hospital_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class DoctorModel extends BaseModel {

    private String name;

    private int age;

    private String  speciality;
}
