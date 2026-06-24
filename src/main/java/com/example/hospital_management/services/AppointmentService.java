package com.example.hospital_management.services;


import com.example.hospital_management.Repositories.AppointmentRepository;
import com.example.hospital_management.Repositories.DoctorRepository;
import com.example.hospital_management.Repositories.PatientRepository;
import com.example.hospital_management.dtos.AppointmentRequestDto;
import com.example.hospital_management.dtos.AppointmentResponseDto;
import com.example.hospital_management.exceptions.BadRequestException;
import com.example.hospital_management.exceptions.ResouceNotFoundException;
import com.example.hospital_management.models.AppointMentModel;
import com.example.hospital_management.models.DoctorModel;
import com.example.hospital_management.models.PatientModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

   public AppointmentResponseDto getAppointmentById(Long appointmentId){

       AppointMentModel appointmentEntity = appointmentRepository.findById(appointmentId).orElseThrow(
               ()-> new ResouceNotFoundException("Appointment was not Found")
       );
       AppointmentResponseDto responseDto = new AppointmentResponseDto();
       responseDto.setAppointment_id(appointmentEntity.getId());
       responseDto.setPatient(appointmentEntity.getPatient());
       responseDto.setDoctor(appointmentEntity.getDoctor());
       return responseDto;
   }

    public AppointmentResponseDto createAppointment(AppointmentRequestDto requestDto)  {

        Long doctorId = requestDto.getDoctorId();
        Long patientId  = requestDto.getPatientId();

        if(doctorId == null || patientId == null){
            throw new BadRequestException("patient Id or Doctor Id missing");
        }

        PatientModel patientEntity = patientRepository.findById( patientId).orElseThrow(
                ()-> new ResouceNotFoundException("Patient was Not Found with Id: " + patientId)
        );

        DoctorModel doctorEntity = doctorRepository.findById(doctorId).orElseThrow(
                ()->new ResouceNotFoundException("Doctor was Not Found with Id: " + doctorId)
        );
        AppointMentModel appointmentEntity = new AppointMentModel();
        appointmentEntity.setDoctor(doctorEntity);
        appointmentEntity.setPatient(patientEntity);
        appointmentEntity.setAppointmentDateTime(requestDto.getAppointmentTime());

        AppointMentModel savedAppointment = appointmentRepository.save(appointmentEntity);

        AppointmentResponseDto responseDto = new AppointmentResponseDto();
        responseDto.setAppointment_id(savedAppointment.getId());
        responseDto.setPatient(savedAppointment.getPatient());
        responseDto.setDoctor(savedAppointment.getDoctor());
       return responseDto;
    }
}

