package com.caroba.techchallenge.feedback.repository;

import com.caroba.techchallenge.feedback.model.FeedBack;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedBackRepository {
    private final List<FeedBack> banco = new ArrayList<>();

    public void save(FeedBack feedback) {
        banco.add(feedback);
    }

    public List<FeedBack> findAll() {
        return banco;
    }

}
