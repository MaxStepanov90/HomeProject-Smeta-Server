package com.stepanov.smetaserver.service;


import com.stepanov.smetaserver.model.Estimate;

import java.util.List;

public interface EstimateService {

    List<Estimate> findEstimatesByProjectId(Long id);

    Estimate findById(Long id);

    Estimate saveOrUpdate(Estimate estimate);

    String deleteById(Long id);
}
