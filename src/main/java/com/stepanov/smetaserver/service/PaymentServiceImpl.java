package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Estimate;
import com.stepanov.smetaserver.model.Payment;
import com.stepanov.smetaserver.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final EstimateServiceImpl estimateService;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository,EstimateServiceImpl estimateService) {
        this.paymentRepository = paymentRepository;
        this.estimateService = estimateService;
    }

    @Override
    public List<Payment> findAllPaymentsByProjectId(Long id) {
        return paymentRepository.findPaymentsByProjectId(id);
    }

    @Override
    public List<Payment> findAllPaymentsByEstimateId(Long id) {
        return paymentRepository.findPaymentsByEstimateId(id);
    }

    @Override
    public Payment save(Payment payment) {
        Estimate foundEstimate = estimateService.findById(payment.getEstimateId());
        payment.setEstimateName(foundEstimate.getName());
        payment.setDate(LocalDate.now());
        payment.setProjectId(foundEstimate.getProjectId());
        log.info("save new payment estimateName: {} amount: {} category: {} date: {}",
                payment.getEstimateName(), payment.getAmount(), payment.getCategory(), payment.getDate());
        estimateService.updateEstimatePayment(payment.getEstimateId(),payment.getAmount());
        return paymentRepository.save(payment);
    }
}
