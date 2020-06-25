package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.EstimateDetail;
import com.stepanov.smetaserver.repository.EstimateDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EstimateDetailServiceImpl implements EstimateDetailService {

    private final EstimateDetailRepository estimateDetailRepository;
    private final EstimateServiceImpl estimateService;
    private final MarkUpServiceImpl markUpService;

    @Autowired
    public EstimateDetailServiceImpl(EstimateDetailRepository estimateDetailRepository,
                                     EstimateServiceImpl estimateService,
                                     MarkUpServiceImpl markUpService) {
        this.estimateDetailRepository = estimateDetailRepository;
        this.estimateService = estimateService;
        this.markUpService = markUpService;
    }

    @Override
    public List<EstimateDetail> findEstimateDetailsByEstimateId(Long id) {
        return estimateDetailRepository.findEstimateDetailsByEstimateId(id);
    }

    @Override
    public List<EstimateDetail> findEstimateDetailsByEstimateIdAndCategory(Long id, String category) {
        return estimateDetailRepository.findEstimateDetailsByEstimateIdAndCategory(id, category);
    }

    @Override
    public EstimateDetail findById(Long id) {
        return estimateDetailRepository.findById(id).get();
    }

    @Override
    public EstimateDetail save(EstimateDetail estimateDetail) {
        log.info("new estimateDetail: {}", estimateDetail);
        double markUpPercent = markUpService.findMarkUpPercentByMarkUpName(estimateDetail.getCategory());
        EstimateDetail newEstimateDetail = buildNewEstimateDetail(estimateDetail, markUpPercent);
        log.info("save new estimateDetail name: {} cost: {} by category: {} with markUp percent: {}",
                newEstimateDetail.getName(), newEstimateDetail.getCostClient(),
                newEstimateDetail.getCategory(), markUpPercent);
        estimateService.updateEstimateCost(newEstimateDetail.getEstimateId(),newEstimateDetail.getCostClient());
        return estimateDetailRepository.save(newEstimateDetail);
    }

    @Override
    public EstimateDetail update(EstimateDetail estimateDetail) {
        estimateService.updateEstimatePerformance(estimateDetail.getEstimateId(),
                estimateDetail.isComplete(),estimateDetail.getCostClient());
        log.info("update estimateDetail: {} category: {} toggleComplete: {}",
                estimateDetail.getName(), estimateDetail.getCategory(), estimateDetail.isComplete());
        return estimateDetailRepository.save(estimateDetail);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            estimateDetailRepository.deleteById(id);
            jsonObject.put("message", "EstimateDetail deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public EstimateDetail buildNewEstimateDetail(EstimateDetail estimateDetail, double markUpPercent) {
        return EstimateDetail.builder()
                .name(estimateDetail.getName())
                .unit(estimateDetail.getUnit())
                .quantity(estimateDetail.getQuantity())
                .price(estimateDetail.getPrice())
                .cost(calcCost(estimateDetail.getQuantity(), estimateDetail.getPrice()))
                .priceClient(calcPriceClient(estimateDetail.getPrice(), markUpPercent))
                .costClient(calcCostClient(estimateDetail.getPrice(), estimateDetail.getQuantity(), markUpPercent))
                .category(estimateDetail.getCategory())
                .complete(false)
                .estimateId(estimateDetail.getEstimateId())
                .build();
    }

    public double calcCost(double quantity, double price) {
        return quantity * price;
    }

    public double calcPriceClient(double price, double markUpPercent) {
        return Math.round((price + (price * markUpPercent / 100)) * 100) / 100.0d;
    }

    public double calcCostClient(double price, double quantity, double markUpPercent) {
        return Math.round((quantity * (price + (price * markUpPercent / 100))) * 100) / 100.0d;
    }
}
