package com.example.aishamed.service;

import com.example.aishamed.dto.PatientDto;
import com.example.aishamed.mapper.PatientAndDoctorMapper;
import com.example.aishamed.model.Drugs;
import com.example.aishamed.model.Patient;
import com.example.aishamed.model.PatientStatus;
import com.example.aishamed.repository.DrugsRepository;
import com.example.aishamed.repository.PatientRepository;
import com.example.aishamed.repository.PatientStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientAndDoctorMapper patientAndDoctorMapper;
    private final PatientStatusRepository patientStatusRepository;
    private final DrugsRepository drugsRepository;

    public PatientService(PatientRepository patientRepository, PatientAndDoctorMapper patientAndDoctorMapper, PatientStatusRepository patientStatusRepository, DrugsRepository drugsRepository) {
        this.patientRepository = patientRepository;
        this.patientAndDoctorMapper = patientAndDoctorMapper;
        this.patientStatusRepository = patientStatusRepository;
        this.drugsRepository = drugsRepository;
    }

    public PatientDto getById(Long id){
        return patientAndDoctorMapper.patientToDto(patientRepository.getReferenceById(id));
    }
    public List<PatientDto> getAll(){
        return patientRepository.findAll().stream().map(patientAndDoctorMapper::patientToDto).collect(Collectors.toList());
    }

    public List<PatientDto> getByStatus(Long statusId){
        return patientRepository.getByStatus_Id(statusId).stream().map(patientAndDoctorMapper::patientToDto).collect(Collectors.toList());
    }

    public List<PatientDto> getByDrugs(Long drugId){
        return patientRepository.getByDrug_Id(drugId).stream().map(patientAndDoctorMapper::patientToDto).collect(Collectors.toList());
    }

    public List<PatientDto> getByDoctor(Long doctorId){
        return patientRepository.getByDoctor(doctorId).stream().map(patientAndDoctorMapper::patientToDto).collect(Collectors.toList());
    }

    public void createPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void updatePatient(Long id, Patient patient){
        Patient patientDto = patientRepository.getReferenceById(id);
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
        patientRepository.save(patientDto);
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}
