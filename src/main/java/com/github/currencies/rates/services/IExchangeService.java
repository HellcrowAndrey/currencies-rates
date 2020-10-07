package com.github.currencies.rates.services;

import com.github.currencies.rates.payload.CurrentRates;
import com.github.currencies.rates.payload.SpecificRate;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IExchangeService {

    @GET(value = "/v1/exchangerate")
    Call<CurrentRates> findRates(
            @Header("X-CoinAPI-Key") String key,
            @Path(value = "currency") String name,
            @Query(value = "invert") Boolean invert);

    @GET(value = "/v1/exchangerate")
    Call<SpecificRate> findRate(
            @Header("X-CoinAPI-Key") String key,
            @Path(value = "base") String base,
            @Path(value = "quote") String quote
    );

}
