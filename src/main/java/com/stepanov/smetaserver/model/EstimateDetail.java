package com.stepanov.smetaserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class EstimateDetail {
    @Id
    @SequenceGenerator( name = "jpaEstimateDetailSequence", sequenceName = "JPA_ESTIMATE_DETAIL_SEQUENCE", allocationSize = 1, initialValue = 7 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaEstimateDetailSequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    private String name;
    private String unit;
    private double quantity;
    private double price;
    private double cost;
    private double priceClient;
    private double costClient;
    private String category;
    private boolean complete;
    private Long estimateId;

}
