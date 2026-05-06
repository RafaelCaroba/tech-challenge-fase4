package com.caroba.techchallenge.feedback.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class FeedBack {
    private String descricao;
    private int nota;
    private String urgencia;
    private LocalDateTime data;
}
