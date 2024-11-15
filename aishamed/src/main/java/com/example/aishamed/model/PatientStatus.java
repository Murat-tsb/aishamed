package com.example.aishamed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patient_status")
public class PatientStatus {
    @Id
    private Long id;
    private String title;
}
