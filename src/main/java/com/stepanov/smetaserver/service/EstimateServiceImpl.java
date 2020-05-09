package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Estimate;
import com.stepanov.smetaserver.repository.EstimateRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
