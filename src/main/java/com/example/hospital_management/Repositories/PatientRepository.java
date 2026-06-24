package com.example.hospital_management.Repositories;

import com.example.hospital_management.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel,Long > {
}
