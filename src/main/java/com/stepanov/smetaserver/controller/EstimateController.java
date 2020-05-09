package com.stepanov.smetaserver.controller;

import com.stepanov.smetaserver.model.Estimate;
import com.stepanov.smetaserver.service.EstimateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/estimates")
@CrossOrigin(origins = "http://localhost:3000")
public class EstimateController {

    private final EstimateServiceImpl estimateService;

    @Autowired
    public EstimateController(EstimateServiceImpl estimateService) {
        this.estimateService = estimateService;
    }

    @GetMapping("/projectId/{id}")
    public ResponseEntity<List<Estimate>> findEstimatesByProjectId(@PathVariable Long id) {
        return new ResponseEntity<>(estimateService.findEstimatesByProjectId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estimate> findById(@PathVariable Long id) {
        return new ResponseEntity<>(estimateService.findById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Estimate> save(@RequestBody Estimate estimate) {
        return new ResponseEntity<>(estimateService.saveOrUpdate(estimate), HttpStatus.CREATED);
    }

    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Estimate> update(@RequestBody Estimate estimate) {
        return new ResponseEntity<>(estimateService.saveOrUpdate(estimate), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(estimateService.deleteById(id), HttpStatus.OK);
    }
}