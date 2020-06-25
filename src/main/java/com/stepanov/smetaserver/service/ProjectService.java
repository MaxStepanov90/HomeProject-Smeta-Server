package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Page<Project> findAll(Pageable pageable, String searchText);

    List<Project> findAll();

    Project findById(Long id);

    Project saveOrUpdate(Project project);

    String deleteById(Long id);
}
