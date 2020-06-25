package com.stepanov.smetaserver.controller;

import com.stepanov.smetaserver.service.DownloadExcelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/download/excel")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = {"Content-Disposition"})
public class DownloadExcelController {

    private final DownloadExcelService excelService;

    @Autowired
    public DownloadExcelController(DownloadExcelService excelService) {
        this.excelService = excelService;
    }

    @GetMapping("/estimateId/{id}/category/{category}")
    public ResponseEntity<InputStreamResource> downLoadExcelFile(HttpServletResponse response,
                                                                 @PathVariable Long id,
                                                                 @PathVariable String category) throws IOException {

        ByteArrayInputStream inputStream = excelService.createExcelFile(id, category);
        IOUtils.copy(inputStream, response.getOutputStream());
        response.setHeader("Content-Disposition",
                String.format("attachment; filename=EstimateDetails %s.xlsx", LocalDate.now()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
