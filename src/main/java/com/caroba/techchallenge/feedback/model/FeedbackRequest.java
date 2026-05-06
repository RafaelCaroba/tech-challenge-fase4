package com.caroba.techchallenge.feedback.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FeedbackRequest {

    private String descricao;
    private int nota;

}
