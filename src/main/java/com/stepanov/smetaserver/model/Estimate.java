package com.stepanov.smetaserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    название
    private String estimateName;
//    договорная цена
    private double estimateCost;
//    выполнено
    private double estimatePerformance;
//    оплачено
    private double estimatePayment;
//     к оплате
    private double estimateNotPayment;
    private Long projectId;
}
