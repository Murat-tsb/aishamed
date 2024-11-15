package com.example.aishamed.repository;

import com.example.aishamed.model.Clinic;
import com.example.aishamed.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

List<Doctor> getByClinic_Id(Long clinicId);
}
