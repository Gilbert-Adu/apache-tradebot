package com.example.trading.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trading.service.TradeService;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin(origins="http://localhost:3000")
public class TradeController {
    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public String createTrade(String trade) {
        tradeService.sendTrade(trade);

        return "Trade sent successfully";
    }
}
