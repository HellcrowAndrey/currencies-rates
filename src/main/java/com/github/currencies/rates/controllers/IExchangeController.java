package com.github.currencies.rates.controllers;

import com.github.currencies.rates.payload.RatesPayload;
import com.github.currencies.rates.payload.SpecificRate;

import java.util.Optional;

public interface IExchangeController  {

    Optional<RatesPayload> findRates(String key, String name, Boolean invert);

    Optional<SpecificRate> findRate(String key, String base, String quote);

}
