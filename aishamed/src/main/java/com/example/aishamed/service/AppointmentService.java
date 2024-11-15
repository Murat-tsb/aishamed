package com.example.aishamed.service;

import com.example.aishamed.model.Appointment;
import com.example.aishamed.model.Doctor;
import com.example.aishamed.model.Patient;
import com.example.aishamed.repository.AppointmentRepository;
import com.example.aishamed.repository.DoctorRepository;
import com.example.aishamed.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment getById(Long id){
        return appointmentRepository.getReferenceById(id);
    }
    public List<Appointment> getByDoctor(Long doctorId){
        return appointmentRepository.getByDoctor_Id(doctorId);
    }
    public List<Appointment> getByPatient(Long patientId){
        return appointmentRepository.getByPatient_Id(patientId);
    }
    public List<Appointment> getAll(){
        return appointmentRepository.findAll();
    }

    public void createAppointment(Long doctorId, Long patientId, LocalDateTime dateTime){
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctorRepository.getReferenceById(doctorId));
        appointment.setPatient(patientRepository.getReferenceById(patientId));
        appointment.setDateTime(dateTime);
        appointmentRepository.save(appointment);
    }
    public void updateAppointment(Long id ,Long doctorId, Long patientId, LocalDateTime dateTime){
        Appointment appointment = appointmentRepository.getReferenceById(id);
        appointment.setDoctor(doctorRepository.getReferenceById(doctorId));
        appointment.setPatient(patientRepository.getReferenceById(patientId));
        appointment.setDateTime(dateTime);
        appointmentRepository.save(appointment);
    }
    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }
}
