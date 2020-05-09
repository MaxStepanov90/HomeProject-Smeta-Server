package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Payment;
import com.stepanov.smetaserver.repository.PaymentRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAllPaymentsByProjectId(Long id) {
        return paymentRepository.findPaymentsByProjectId(id);
    }

    @Override
    public Payment findPaymentUpById(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public Payment saveOrUpdate(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            paymentRepository.deleteById(id);
            jsonObject.put("message", "Payment deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
