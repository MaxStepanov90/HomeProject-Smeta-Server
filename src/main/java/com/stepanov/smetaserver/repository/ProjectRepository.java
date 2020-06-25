package com.stepanov.smetaserver.repository;

import com.stepanov.smetaserver.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @Query("From Project p WHERE p.name=:searchText OR p.address=:searchText OR" +
            " p.contract=:searchText ORDER BY p.creationDate DESC")
    Page<Project> findAllProjects(Pageable pageable, @Param("searchText") String searchText);
}