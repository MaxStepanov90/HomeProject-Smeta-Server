package com.stepanov.smetaserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Estimate {
    @Id
    @SequenceGenerator( name = "jpaEstimateSequence", sequenceName = "JPA_ESTIMATE_SEQUENCE", allocationSize = 1, initialValue = 3 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaEstimateSequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
//    название
    private String name;
//    договорная цена
    private double cost;
//    выполнено
    private double performance;
//    оплачено
    private double payment;
//     к оплате
    private double notPayment;
    private Long projectId;
}
