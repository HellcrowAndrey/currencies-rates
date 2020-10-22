package com.github.currencies.rates.controllers.impl;

import com.github.currencies.rates.services.IExchangeService;
import com.github.currencies.rates.payload.RatePayload;
import com.github.currencies.rates.payload.RatesPayload;
import com.github.currencies.rates.payload.SpecificRate;
import com.github.currencies.rates.services.impl.ExchangeService;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ExchangeControllerTest {

    private IExchangeService controller;

    private String apiKEy = "189C07D6-A305-4EB7-8B03-9CA3DD50819E";

    @Before
    public void setUp() throws Exception {
        this.controller = new ExchangeService("https://rest.coinapi.io");
    }

    @Test
    public void findRates() throws InterruptedException {
//        CompletableFuture<CurrentRates> f1 = CompletableFuture
//                .supplyAsync(() -> this.controller.findRates(apiKEy, "BTC", Boolean.FALSE).orElse(null));
//        CompletableFuture<CurrentRates> f2 = CompletableFuture
//                .supplyAsync(() -> this.controller.findRates(apiKEy, "ETH", Boolean.FALSE).orElse(null));
//
//        Map<String, List<Rate>> result = Stream.of(f1, f2)
//                .map(CompletableFuture::join)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toMap(CurrentRates::getAssetIdBase, v -> v.getRates().stream()
//                        .filter(r -> fiats.contains(r.getAssetIdQuote()))
//                        .collect(Collectors.toList())));
//        List<String> currencies = Arrays.asList("BTC", "ETH");
//
//        CompletableFuture.supplyAsync(() -> this.controller.findRates(apiKEy, "BTC", Boolean.FALSE).orElse(null))
//                .thenApply(CurrentRates::getRates)
//                .thenAccept(rates -> {
//                    System.out.println(rates);
//                });

        Optional<RatesPayload> result = this.controller.findRates(apiKEy, "USDT", Boolean.FALSE);
        RatesPayload tmp = result.orElse(null);
        List<RatePayload> rates = tmp.getRates();
        RatePayload usdRate = rates.stream().filter(r -> r.getAssetIdQuote().equals("USD")).findFirst().orElse(null);
        result.ifPresent(System.out::println);
    }

    @Test
    public void findRate() {
        Optional<SpecificRate> result = this.controller.findRate(apiKEy, "ETH", "USD");
        SpecificRate tmp = result.orElse(null);
        System.out.println(tmp);
    }

}