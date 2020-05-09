package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.MarkUp;
import com.stepanov.smetaserver.repository.MarkUpRepository;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MarkUpServiceImpl implements MarkUpService {

    private final MarkUpRepository markUpRepository;
    @Autowired
    public MarkUpServiceImpl(MarkUpRepository markUpRepository) {
        this.markUpRepository = markUpRepository;
    }

    @Override
    public List<MarkUp> findAllMarkUps() {
        return markUpRepository.findAll();
    }

    @Override
    public MarkUp findMarkUpById(Integer id){
        return markUpRepository.findById(id).get();
    }

    @Override
    public MarkUp saveOrUpdate(MarkUp markUp) {
        return markUpRepository.save(markUp);
    }

    @Override
    public String deleteById(Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            markUpRepository.deleteById(id);
            jsonObject.put("message", "MarkUpList deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public double findMarkUpPercentByMarkUpName(String category){
        return markUpRepository.findByMarkUpName(category).getMarkUpPercent();
    }
}
