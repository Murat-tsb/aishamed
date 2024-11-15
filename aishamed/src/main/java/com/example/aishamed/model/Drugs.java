package com.example.aishamed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "drugs")
public class Drugs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer amount;
    private String description;
    private String instruction;
}
