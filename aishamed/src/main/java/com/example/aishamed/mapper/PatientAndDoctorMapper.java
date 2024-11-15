package com.example.aishamed.mapper;

import com.example.aishamed.dto.DoctorDto;
import com.example.aishamed.dto.PatientDto;
import com.example.aishamed.model.Doctor;
import com.example.aishamed.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PatientAndDoctorMapper {
    public PatientDto patientToDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        if (Objects.nonNull(patient.getId())){patientDto.setId(patient.getId());}
        if (Objects.nonNull(patient.getName())){patientDto.setName(patient.getName());}
        if (Objects.nonNull(patient.getSurname())){patientDto.setSurname(patient.getSurname());}
        if (Objects.nonNull(patient.getAge())){patientDto.setAge(patient.getAge());}
        if (Objects.nonNull(patient.getGender())){patientDto.setGender(patient.getGender());}
        if (Objects.nonNull(patient.getStatus())){patientDto.setStatus(patient.getStatus());}
        if (Objects.nonNull(patient.getSymptoms())){patientDto.setSymptoms(patient.getSymptoms());}
        if (Objects.nonNull(patient.getEmail())){patientDto.setEmail(patient.getEmail());}
        if (Objects.nonNull(patient.getDiagnosis())){patientDto.setDiagnosis(patient.getDiagnosis());}
        if (Objects.nonNull(patient.getDrug())){patientDto.setDrug(patient.getDrug());}
        return patientDto;
    }

    public DoctorDto doctorToDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto();
        if(Objects.nonNull(doctor.getId())){doctorDto.setId(doctor.getId());}
        if(Objects.nonNull(doctor.getName())){doctorDto.setName(doctor.getName());}
        if(Objects.nonNull(doctor.getSurname())){doctorDto.setSurname(doctor.getSurname());}
        if(Objects.nonNull(doctor.getAge())){doctorDto.setAge(doctor.getAge());}
        if(Objects.nonNull(doctor.getEmail())){doctorDto.setEmail(doctor.getEmail());}
        if(Objects.nonNull(doctor.getGender())){doctorDto.setGender(doctor.getGender());}
        if(Objects.nonNull(doctor.getClinic())){doctorDto.setClinic(doctor.getClinic());}
        if(Objects.nonNull(doctor.getProfession())){doctorDto.setProfession(doctor.getProfession());}
        return doctorDto;
    }

}
