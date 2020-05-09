package com.stepanov.smetaserver.controller;

import com.stepanov.smetaserver.model.EstimateDetail;
import com.stepanov.smetaserver.service.EstimateDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/estimateDetails")
@CrossOrigin(origins = "http://localhost:3000")
public class EstimateDetailController {

    private final EstimateDetailServiceImpl estimateDetailService;

    @Autowired
    public EstimateDetailController(EstimateDetailServiceImpl estimateDetailService) {
        this.estimateDetailService = estimateDetailService;
    }

    @GetMapping("/estimateId/{estimateId}")
    public ResponseEntity<List<EstimateDetail>> findEstimateDetailsByEstimateId(@PathVariable Long estimateId) {
        return new ResponseEntity<>(estimateDetailService.findEstimateDetailsByEstimateId(estimateId), HttpStatus.OK);
    }

    @GetMapping("/estimateId/{estimateId}/category/{category}")
    public ResponseEntity<List<EstimateDetail>> findEstimateDetailsByEstimateIdAndCategory(
            @PathVariable Long estimateId,
            @PathVariable String category) {
        return new ResponseEntity<>(
                estimateDetailService.findEstimateDetailsByEstimateIdAndCategory(estimateId,category)
                , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EstimateDetail> findById(@PathVariable Long id) {
        return new ResponseEntity<>(estimateDetailService.findById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EstimateDetail> save(@RequestBody EstimateDetail estimateDetail) {
        return new ResponseEntity<>(estimateDetailService.save(estimateDetail), HttpStatus.CREATED);
    }

    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EstimateDetail> update(@RequestBody EstimateDetail estimateDetail) {
        return new ResponseEntity<>(estimateDetailService.update(estimateDetail), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(estimateDetailService.deleteById(id), HttpStatus.OK);
    }
}
