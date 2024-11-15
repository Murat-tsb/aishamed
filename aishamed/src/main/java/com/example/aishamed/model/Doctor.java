package com.example.aishamed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String gender;
    private String profession;
    @JoinColumn(name = "clinic_id")
    @ManyToOne
    private Clinic clinic;
    private String password;


}
