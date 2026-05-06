package com.caroba.techchallenge.feedback.service;

import com.caroba.techchallenge.feedback.model.Feedback;
import com.caroba.techchallenge.feedback.model.FeedbackRequest;
import com.caroba.techchallenge.feedback.repository.FeedBackRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FeedbackService {

    private final FeedBackRepository repository;
    private final NotificationService notificationService;

    public FeedbackService(FeedBackRepository repository,
                           NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void processFeedback(FeedbackRequest request) {

        validar(request);

        String urgencia = definirUrgencia(request.getNota());

        Feedback feedback = new Feedback();
        feedback.setDescricao(request.getDescricao());
        feedback.setNota(request.getNota());
        feedback.setUrgencia(urgencia);
        feedback.setData(LocalDateTime.now());

        repository.save(feedback);

        if ("ALTA".equals(urgencia)) {
            notificationService.notifyAdmin(feedback);
        }
    }

    private void validar(FeedbackRequest request) {
        if (request.getDescricao() == null || request.getDescricao().isBlank()) {
            throw new RuntimeException("Descrição obrigatória");
        }

        if (request.getNota() < 0 || request.getNota() > 10) {
            throw new RuntimeException("Nota deve ser entre 0 e 10");
        }
    }

    private String definirUrgencia(int nota) {
        if (nota <= 4) return "ALTA";
        if (nota <= 7) return "MEDIA";
        return "BAIXA";
    }

}
