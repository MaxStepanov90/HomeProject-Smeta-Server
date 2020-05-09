package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAllPaymentsByProjectId(Long id);
    Payment findPaymentUpById(Long id);
    Payment saveOrUpdate(Payment payment);
    String deleteById(Long id);
}
