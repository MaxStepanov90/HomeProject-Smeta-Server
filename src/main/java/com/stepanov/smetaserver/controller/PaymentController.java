package com.stepanov.smetaserver.controller;

import com.stepanov.smetaserver.model.Payment;
import com.stepanov.smetaserver.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentServiceImpl paymentService;
    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/projectId/{id}")
    public ResponseEntity<List<Payment>> findPaymentsByProjectId(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.findAllPaymentsByProjectId(id), HttpStatus.OK);
    }
    @GetMapping("/estimateId/{id}")
    public ResponseEntity<List<Payment>> findPaymentsByEstimateId(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.findAllPaymentsByEstimateId(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }
}
