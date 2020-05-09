package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.EstimateDetail;

import java.util.List;

public interface EstimateDetailService {

    List<EstimateDetail> findEstimateDetailsByEstimateId(Long id);

    List<EstimateDetail> findEstimateDetailsByEstimateIdAndCategory(Long id, String category);

    EstimateDetail findById(Long id);

    EstimateDetail save(EstimateDetail estimateDetail);

    EstimateDetail update(EstimateDetail estimateDetail);

    String deleteById(Long id);
}
