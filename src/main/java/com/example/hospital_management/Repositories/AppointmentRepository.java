package com.example.hospital_management.Repositories;

import com.example.hospital_management.models.AppointMentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointMentModel, Long> {


}

