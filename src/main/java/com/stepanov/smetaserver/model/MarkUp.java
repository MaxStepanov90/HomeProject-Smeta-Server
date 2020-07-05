package com.stepanov.smetaserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MarkUp {
    @Id
    @SequenceGenerator( name = "jpaMarkUpSequence", sequenceName = "JPA_MARK_UP_SEQUENCE", allocationSize = 1, initialValue = 3 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaMarkUpSequence")
    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    private String markUpName;
    private double markUpPercent;
}
