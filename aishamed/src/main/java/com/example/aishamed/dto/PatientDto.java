package com.example.aishamed.dto;

import com.example.aishamed.model.Drugs;
import com.example.aishamed.model.PatientStatus;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PatientDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String gender;
    private PatientStatus status;
    private String symptoms;
    private String diagnosis;
    private Drugs drug;
}
