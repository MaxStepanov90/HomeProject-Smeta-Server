package com.stepanov.smetaserver.repository;

import com.stepanov.smetaserver.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("From Payment p WHERE p.projectId=:id")
    List<Payment> findPaymentsByProjectId(Long id);
    @Query("From Payment p WHERE p.estimateId=:id")
    List<Payment> findPaymentsByEstimateId(Long id);

}
