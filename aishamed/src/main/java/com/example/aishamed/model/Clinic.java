package com.example.aishamed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clinic")
public class Clinic {
    @Id
    private Long id;
    private String name;
    private String address;
}
