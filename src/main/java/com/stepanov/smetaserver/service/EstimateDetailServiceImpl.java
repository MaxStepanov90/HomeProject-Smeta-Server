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
    private final MarkUpServiceImpl markUpService;

    @Autowired
    public EstimateDetailServiceImpl(EstimateDetailRepository estimateDetailRepository,
                                     MarkUpServiceImpl markUpService) {
        this.estimateDetailRepository = estimateDetailRepository;
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
        String category = estimateDetail.getCategory();
        double markUpPercent = markUpService.findMarkUpPercentByMarkUpName(category);
        log.info("save new estimateDetail by category: {} with markUp percent: {}", category, markUpPercent);
        EstimateDetail newEstimateDetail = EstimateDetail.builder()
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
        return estimateDetailRepository.save(newEstimateDetail);
    }

    @Override
    public EstimateDetail update(EstimateDetail estimateDetail) {
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
