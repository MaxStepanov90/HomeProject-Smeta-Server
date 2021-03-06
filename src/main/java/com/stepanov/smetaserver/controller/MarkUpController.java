package com.stepanov.smetaserver.controller;

import com.stepanov.smetaserver.model.MarkUp;
import com.stepanov.smetaserver.service.MarkUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/markUps")
public class MarkUpController {

    private final MarkUpServiceImpl markUpService;
    @Autowired
    public MarkUpController(MarkUpServiceImpl markUpService) {
        this.markUpService = markUpService;
    }
    @GetMapping
    public ResponseEntity<List<MarkUp>> findAllMarkUps() {
        return new ResponseEntity<>(markUpService.findAllMarkUps(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MarkUp> findMarkUpById(@PathVariable Integer id) {
        return new ResponseEntity<>(markUpService.findMarkUpById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MarkUp> save(@RequestBody MarkUp markUp) {
        return new ResponseEntity<>(markUpService.saveOrUpdate(markUp), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MarkUp> update(@RequestBody MarkUp markUp) {
        return new ResponseEntity<>(markUpService.saveOrUpdate(markUp), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(markUpService.deleteById(id), HttpStatus.OK);
    }
}
