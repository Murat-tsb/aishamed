package com.example.aishamed.repository;

import com.example.aishamed.model.Drugs;
import com.example.aishamed.model.Patient;
import com.example.aishamed.model.PatientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> getByStatus_Id(Long statusId);
    List<Patient> getByDrug_Id(Long drugsId);
    Patient getByEmail(String email);
    @Query(nativeQuery = true, value = "select p.id as id, p.name, p.surname, p.email, p.age, p.gender, p.status_id, p.symptoms, p.diagnosis, p.drug_id, p.password " +
            "from patient p " +
            "inner join appointment a on a.patient_id = p.id " +
            "inner join doctors d on d.id = a.doctor_id " +
            "where d.id = :doctorId")
    List<Patient> getByDoctor(Long doctorId);

}
