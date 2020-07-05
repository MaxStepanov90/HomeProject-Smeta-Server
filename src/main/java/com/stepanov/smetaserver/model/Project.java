package com.stepanov.smetaserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    @SequenceGenerator( name = "jpaProjectSequence", sequenceName = "JPA_PROJECT_SEQUENCE", allocationSize = 1, initialValue = 11 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaProjectSequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    private String contract;
    private String name;
    private String address;
    private LocalDate creationDate;
    private String owner;
    private String description;
}
