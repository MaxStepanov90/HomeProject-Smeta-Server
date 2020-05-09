package com.stepanov.smetaserver.repository;

import com.stepanov.smetaserver.model.EstimateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstimateDetailRepository extends JpaRepository<EstimateDetail,Long> {
    @Query("From EstimateDetail e WHERE e.estimateId=:id")
    List<EstimateDetail> findEstimateDetailsByEstimateId(Long id);
    @Query("From EstimateDetail e WHERE e.estimateId=:id and e.category=:category")
    List<EstimateDetail> findEstimateDetailsByEstimateIdAndCategory(Long id, String category);
}
