package com.example.aishamed.repository;

import com.example.aishamed.model.PatientStatus;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientStatusRepository extends JpaRepository<PatientStatus, Long> {
}
