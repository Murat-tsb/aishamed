package com.example.aishamed.dto;

import com.example.aishamed.model.Clinic;
import lombok.Data;

@Data
public class DoctorDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String gender;
    private String profession;
    private Clinic clinic;
}
