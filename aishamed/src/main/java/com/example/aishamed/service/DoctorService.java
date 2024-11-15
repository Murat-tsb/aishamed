package com.example.aishamed.service;

import com.example.aishamed.dto.DoctorDto;
import com.example.aishamed.mapper.PatientAndDoctorMapper;
import com.example.aishamed.model.Clinic;
import com.example.aishamed.model.Doctor;
import com.example.aishamed.repository.ClinicRepository;
import com.example.aishamed.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final PatientAndDoctorMapper patientAndDoctorMapper;
    private final DoctorRepository doctorRepository;
    private final ClinicRepository clinicRepository;


    public DoctorService(PatientAndDoctorMapper patientAndDoctorMapper, DoctorRepository doctorRepository, ClinicRepository clinicRepository) {
        this.patientAndDoctorMapper = patientAndDoctorMapper;
        this.doctorRepository = doctorRepository;
        this.clinicRepository = clinicRepository;
    }

    public DoctorDto getById(Long id){
        return patientAndDoctorMapper.doctorToDto(doctorRepository.getReferenceById(id));
    }
    public List<DoctorDto> getAll(){
        return doctorRepository.findAll().stream().map(patientAndDoctorMapper::doctorToDto).collect(Collectors.toList());
    }
    public List<DoctorDto> getByClinic(Long clinicId){
        return doctorRepository.getByClinic_Id(clinicId).stream().map(patientAndDoctorMapper::doctorToDto).collect(Collectors.toList());
    }
    public void createDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public void updateDoctor(Long id, Doctor doctor){
        Doctor doctorDto = doctorRepository.getReferenceById(id);
        if(Objects.nonNull(doctor.getId())){doctorDto.setId(doctor.getId());}
        if(Objects.nonNull(doctor.getName())){doctorDto.setName(doctor.getName());}
        if(Objects.nonNull(doctor.getSurname())){doctorDto.setSurname(doctor.getSurname());}
        if(Objects.nonNull(doctor.getAge())){doctorDto.setAge(doctor.getAge());}
        if(Objects.nonNull(doctor.getEmail())){doctorDto.setEmail(doctor.getEmail());}
        if(Objects.nonNull(doctor.getGender())){doctorDto.setGender(doctor.getGender());}
        if(Objects.nonNull(doctor.getClinic())){doctorDto.setClinic(doctor.getClinic());}
        if(Objects.nonNull(doctor.getProfession())){doctorDto.setProfession(doctor.getProfession());}
        doctorRepository.save(doctorDto);
    }
    public void deleteDoctor(Long id ){
        doctorRepository.deleteById(id);
    }

}
