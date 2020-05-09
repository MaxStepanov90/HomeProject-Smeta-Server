package com.stepanov.smetaserver.repository;

import com.stepanov.smetaserver.model.MarkUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkUpRepository extends JpaRepository<MarkUp, Integer> {
    MarkUp findByMarkUpName(String category);
}
