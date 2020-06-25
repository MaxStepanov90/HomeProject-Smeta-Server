package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Estimate;
import com.stepanov.smetaserver.model.EstimateDetail;
import com.stepanov.smetaserver.model.Project;
import com.stepanov.smetaserver.service.EstimateDetailService;
import com.stepanov.smetaserver.service.EstimateService;
import com.stepanov.smetaserver.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class DownloadExcelService {

    private final EstimateDetailService estimateDetailService;
    private final EstimateService estimateService;
    private final ProjectService projectService;

    @Autowired
    public DownloadExcelService(EstimateDetailService estimateDetailService,
                                EstimateService estimateService,
                                ProjectService projectService) {
        this.estimateDetailService = estimateDetailService;
        this.estimateService = estimateService;
        this.projectService = projectService;
    }

    private final String[] columns = {"Наименование позиции", "Ед.изм", "Кол-во", "Цена", "Стоимость"};

    public ByteArrayInputStream createExcelFile(Long estimateId, String category) {
        log.info("Create Excel EstimateDetails with category: {}", category);
        List<EstimateDetail> estimateDetails =
                estimateDetailService.findEstimateDetailsByEstimateIdAndCategory(estimateId, category);
        Estimate foundEstimate = estimateService.findById(estimateId);
        Project foundProject = projectService.findById(foundEstimate.getProjectId());

        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Смета " + category);

            CellStyle headerCellStyle = createHeaderStyle(workbook);
            createProjectDescription(sheet, foundProject, foundEstimate, category);
            createListHeaderRow(sheet, headerCellStyle);
            createListRows(estimateDetails, sheet);
            setAutosizeColumns(sheet);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CellStyle createHeaderStyle(Workbook workbook) {
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        return headerCellStyle;
    }

    public void createProjectDescription(Sheet sheet, Project foundProject, Estimate foundEstimate, String category) {
        Row titleRow0 = sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columns.length - 1));
        titleRow0.createCell(0).setCellValue("Объект: " + foundProject.getName());

        Row titleRow1 = sheet.createRow(1);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, columns.length - 1));
        titleRow1.createCell(0).setCellValue("Адрес: " + foundProject.getAddress());

        Row titleRow2 = sheet.createRow(2);
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, columns.length - 1));
        titleRow2.createCell(0).setCellValue(
                "Название сметы: " + foundEstimate.getName() + "(" + category + ")");
    }

    public void createListHeaderRow(Sheet sheet, CellStyle headerCellStyle) {
        Row headerRow = sheet.createRow(4);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }

    public void createListRows(List<EstimateDetail> estimateDetails, Sheet sheet) {
        int rowNum = 5;
        double result = 0;
        for (EstimateDetail estimateDetail : estimateDetails) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(estimateDetail.getName());
            row.createCell(1).setCellValue(estimateDetail.getUnit());
            row.createCell(2).setCellValue(estimateDetail.getQuantity());
            row.createCell(3).setCellValue(estimateDetail.getPriceClient());
            row.createCell(4).setCellValue(estimateDetail.getCostClient());
            result += estimateDetail.getCostClient();
        }
        createResultRow(estimateDetails, result, sheet);
    }

    public void createResultRow(List<EstimateDetail> estimateDetails, double result, Sheet sheet) {
        Row rowResult = sheet.createRow(estimateDetails.size() + 6);
        rowResult.createCell(0).setCellValue("Всего на сумму: ");
        rowResult.createCell(columns.length - 1).setCellValue(result);
    }

    public void setAutosizeColumns(Sheet sheet) {
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}