package com.stepanov.smetaserver.service;


import com.stepanov.smetaserver.model.MarkUp;

import java.util.List;

public interface MarkUpService {

    List<MarkUp> findAllMarkUps();
    MarkUp findMarkUpById(Integer id);
    MarkUp saveOrUpdate(MarkUp markUp);
    String deleteById(Integer id);
    double findMarkUpPercentByMarkUpName(String category);
}
