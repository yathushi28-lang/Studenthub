package com.nsbm.studenthub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String batch;

    private Double gpa;
}
