package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Estimate;
import com.stepanov.smetaserver.repository.EstimateRepository;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EstimateServiceImpl implements EstimateService {

    private final EstimateRepository estimateRepository;

    @Autowired
    public EstimateServiceImpl(EstimateRepository estimateRepository) {
        this.estimateRepository = estimateRepository;
    }

    @Override
    public List<Estimate> findEstimatesByProjectId(Long id) {
        return estimateRepository.findEstimatesByProjectId(id);
    }

    @Override
    public Estimate findById(Long id) {
        return estimateRepository.findById(id).get();
    }

    @Override
    public Estimate saveOrUpdate(Estimate estimate) {
        return estimateRepository.save(estimate);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            estimateRepository.deleteById(id);
            jsonObject.put("message", "Estimate deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public void updateEstimateCost(Long estimateId, double sum) {
        Estimate foundEstimate = estimateRepository.findById(estimateId).get();
        foundEstimate.setEstimateCost(foundEstimate.getEstimateCost() + sum);
        log.info("update estimate: {} estimateCost: {}",
                foundEstimate.getEstimateName(), foundEstimate.getEstimateCost());
        estimateRepository.save(foundEstimate);
    }
    @Override
    public void updateEstimatePerformance(Long estimateId, boolean isComplete, double sum) {
        Estimate foundEstimate = estimateRepository.findById(estimateId).get();
        foundEstimate.setEstimatePerformance(isComplete ? foundEstimate.getEstimatePerformance() + sum :
                foundEstimate.getEstimatePerformance() - sum);
        foundEstimate.setEstimateNotPayment(isComplete ? foundEstimate.getEstimateNotPayment() + sum :
                foundEstimate.getEstimateNotPayment() - sum);
        log.info("update estimate: {} estimatePerformance: {} estimateNotPayment: {}", foundEstimate.getEstimateName(),
                foundEstimate.getEstimatePerformance(), foundEstimate.getEstimateNotPayment());
        estimateRepository.save(foundEstimate);
    }
    @Override
    public void updateEstimatePayment(Long estimateId, double sum) {
        Estimate foundEstimate = estimateRepository.findById(estimateId).get();
        foundEstimate.setEstimateNotPayment(foundEstimate.getEstimatePerformance() -
                (foundEstimate.getEstimatePayment() + sum));
        foundEstimate.setEstimatePayment(foundEstimate.getEstimatePayment() + sum);
        log.info("update estimate: {} estimatePayment: {} estimateNotPayment: {}", foundEstimate.getEstimateName(),
                foundEstimate.getEstimatePayment(), foundEstimate.getEstimateNotPayment());
        estimateRepository.save(foundEstimate);
    }
}
