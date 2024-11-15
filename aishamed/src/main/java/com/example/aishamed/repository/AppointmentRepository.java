package com.example.aishamed.repository;

import com.example.aishamed.model.Appointment;
import com.example.aishamed.model.Doctor;
import com.example.aishamed.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> getByDoctor_Id(Long doctorId);
    List<Appointment> getByPatient_Id(Long patientId);
}
