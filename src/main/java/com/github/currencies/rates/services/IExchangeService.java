package com.github.currencies.rates.services;

import com.github.currencies.rates.payload.RatesPayload;
import com.github.currencies.rates.payload.SpecificRate;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IExchangeService {

    @GET(value = "/v1/exchangerate/{currency}")
    Call<RatesPayload> findRates(
            @Header("X-CoinAPI-Key") String key,
            @Path(value = "currency") String currency,
            @Query(value = "invert") Boolean invert);

    @GET(value = "/v1/exchangerate/{base}/{quote}")
    Call<SpecificRate> findRate(
            @Header("X-CoinAPI-Key") String key,
            @Path(value = "base") String base,
            @Path(value = "quote") String quote
    );

}
