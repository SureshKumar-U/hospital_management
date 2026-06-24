package com.example.hospital_management.services;

import com.example.hospital_management.Repositories.DoctorRepository;
import com.example.hospital_management.dtos.DoctorRequestDto;
import com.example.hospital_management.dtos.DoctorResponseDto;
import com.example.hospital_management.exceptions.ResouceNotFoundException;
import com.example.hospital_management.models.DoctorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService implements IDoctorService{
      private final DoctorRepository doctorRepository;

       @Override
      public DoctorResponseDto createDoctor(DoctorRequestDto requestDto){
          DoctorModel doctorEntity = new DoctorModel();
          doctorEntity.setName(requestDto.getName());
          doctorEntity.setAge(requestDto.getAge());
          doctorEntity.setSpeciality(requestDto.getSpeciality());

          DoctorModel savedDoctorEntity = doctorRepository.save(doctorEntity);
          return DoctorResponseDto.builder()
                  .id(savedDoctorEntity.getId()).name(savedDoctorEntity.getName())
                  .speciality(savedDoctorEntity.getSpeciality())
                  .age(savedDoctorEntity.getAge())
                  .build();

      }

      @Override
      public DoctorResponseDto getDoctorById(Long doctorId){
          DoctorModel  doctorEntity = doctorRepository.findById(doctorId).orElseThrow(()->new ResouceNotFoundException("Doctor Was Not Found With dkctorId : " + doctorId));
          return DoctorResponseDto.builder()
                  .name(doctorEntity.getName())
                  .speciality(doctorEntity.getSpeciality())
                  .age(doctorEntity.getAge())
                  .id(doctorEntity.getId())
                  .build();
      }

      @Override
      public void deleteDoctorById(Long doctorId){
            doctorRepository.deleteById(doctorId);
      }
}
