package com.example.aishamed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String gender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private PatientStatus status;
    private String symptoms;
    private String diagnosis;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drugs drug;
    private String password;
}
