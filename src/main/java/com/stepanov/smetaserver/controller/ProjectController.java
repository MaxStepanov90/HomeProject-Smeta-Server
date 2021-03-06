package com.stepanov.smetaserver.controller;

import com.stepanov.smetaserver.model.Project;
import com.stepanov.smetaserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/search/{searchText}")
    public ResponseEntity<Page<Project>> findAll(Pageable pageable, @PathVariable String searchText) {
        return new ResponseEntity<>(projectService.findAll(pageable, searchText), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.findById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> save(@RequestBody Project project) {
        return new ResponseEntity<>(projectService.saveOrUpdate(project), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> update(@RequestBody Project project) {
        return new ResponseEntity<>(projectService.saveOrUpdate(project), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.deleteById(id), HttpStatus.OK);
    }
}

