package com.caroba.techchallenge.feedback.service;

import com.caroba.techchallenge.feedback.model.Feedback;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyAdmin(Feedback feedback) {
        System.out.println("🚨 ALERTA CRÍTICO 🚨");
        System.out.println("Descrição: " + feedback.getDescricao());
        System.out.println("Nota: " + feedback.getNota());
        System.out.println("Data: " + feedback.getData());
    }
}
