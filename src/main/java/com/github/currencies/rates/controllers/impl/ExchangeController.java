package com.github.currencies.rates.controllers.impl;

import com.github.currencies.rates.config.AppConfig;
import com.github.currencies.rates.controllers.IExchangeController;
import com.github.currencies.rates.payload.RatesPayload;
import com.github.currencies.rates.payload.SpecificRate;
import com.github.currencies.rates.services.IExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Optional;

public class ExchangeController implements IExchangeController {

    private static final Logger log = LoggerFactory.getLogger(ExchangeController.class);

    private final String url;

    public ExchangeController(String url) {
        this.url = url;
    }

    @Override
    public Optional<RatesPayload> findRates(String key, String name, Boolean invert) {
        IExchangeService service = AppConfig.getInstance().exchangeService(this.url);
        Call<RatesPayload> call = service.findRates(key, name, invert);
        try {
            Response<RatesPayload> response = call.execute();
            if (response.isSuccessful()) {
                return Optional.ofNullable(response.body());
            }
        } catch (IOException e) {
            log.warn("Enter: {}", e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<SpecificRate> findRate(String key, String base, String quote) {
        IExchangeService service = AppConfig.getInstance().exchangeService(this.url);
        Call<SpecificRate> call = service.findRate(key, base, quote);
        try {
            Response<SpecificRate> response = call.execute();
            if (response.isSuccessful()) {
                return Optional.ofNullable(response.body());
            }
        } catch (IOException e) {
            log.warn("Enter: {}", e.getMessage());
        }
        return Optional.empty();
    }

}
