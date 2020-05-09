package com.stepanov.smetaserver.controller;

import com.stepanov.smetaserver.model.Payment;
import com.stepanov.smetaserver.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.findPaymentUpById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.saveOrUpdate(payment), HttpStatus.CREATED);
    }

    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Payment> update(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.saveOrUpdate(payment), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.deleteById(id), HttpStatus.OK);
    }
}
