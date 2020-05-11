package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAllPaymentsByProjectId(Long id);
    List<Payment> findAllPaymentsByEstimateId(Long id);
    Payment save(Payment payment);
}
