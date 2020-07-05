package com.stepanov.smetaserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Payment {
    @Id
    @SequenceGenerator( name = "jpaPaymentSequence", sequenceName = "JPA_PAYMENT_SEQUENCE", allocationSize = 1, initialValue = 5 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaPaymentSequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String estimateName;
    private double amount;
    private String comment;
    private LocalDate date;
    private String category;
    private long estimateId;
    private long projectId;

}
