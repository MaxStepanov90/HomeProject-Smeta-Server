package com.stepanov.smetaserver.repository;

import com.stepanov.smetaserver.model.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstimateRepository extends JpaRepository<Estimate,Long> {
    @Query("From Estimate e WHERE e.projectId=:id")
    List<Estimate> findEstimatesByProjectId(Long id);
}
