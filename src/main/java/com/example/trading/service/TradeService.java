package com.example.trading.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TradeService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTrade(String trade) {
        kafkaTemplate.send("trading_topic", trade);
    }
    
}
