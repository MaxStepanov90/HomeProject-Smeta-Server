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
        foundEstimate.setCost(foundEstimate.getCost() + sum);
        log.info("updateEstimateCost estimate: {} estimateCost: {}", foundEstimate.getName(), foundEstimate.getCost());
        estimateRepository.save(foundEstimate);
    }
    @Override
    public void updateEstimatePerformance(Long estimateId, boolean isComplete, double sum) {
        Estimate foundEstimate = estimateRepository.findById(estimateId).get();
        foundEstimate.setPerformance(isComplete ? foundEstimate.getPerformance() + sum :
                foundEstimate.getPerformance() - sum);
        foundEstimate.setNotPayment(isComplete ? foundEstimate.getNotPayment() + sum :
                foundEstimate.getNotPayment() - sum);
        log.info("updateEstimatePerformance estimate: {} estimatePerformance: {} estimateNotPayment: {}",
                foundEstimate.getName(), foundEstimate.getPerformance(), foundEstimate.getNotPayment());
        estimateRepository.save(foundEstimate);
    }
    @Override
    public void updateEstimatePayment(Long estimateId, double sum) {
        Estimate foundEstimate = estimateRepository.findById(estimateId).get();
        foundEstimate.setNotPayment(foundEstimate.getPerformance() -
                (foundEstimate.getPayment() + sum));
        foundEstimate.setPayment(foundEstimate.getPayment() + sum);
        log.info("updateEstimatePayment estimate: {} estimatePayment: {} estimateNotPayment: {}",
                foundEstimate.getName(), foundEstimate.getPayment(), foundEstimate.getNotPayment());
        estimateRepository.save(foundEstimate);
    }
}
