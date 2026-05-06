package com.caroba.techchallenge.feedback.repository;

import com.caroba.techchallenge.feedback.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedBackRepository {
    private final List<Feedback> banco = new ArrayList<>();

    public void save(Feedback feedback) {
        banco.add(feedback);
    }

    public List<Feedback> findAll() {
        return banco;
    }

}
