package com.github.currencies.rates.payload;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "asset_id_quote",
        "rate"
})
public class RatePayload {

    @JsonProperty("time")
    private String time;

    @JsonProperty("asset_id_quote")
    private String assetIdQuote;

    @JsonProperty("rate")
    private Double rate;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("asset_id_quote")
    public String getAssetIdQuote() {
        return assetIdQuote;
    }

    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatePayload rate1 = (RatePayload) o;
        return Objects.equals(time, rate1.time) &&
                Objects.equals(assetIdQuote, rate1.assetIdQuote) &&
                Objects.equals(rate, rate1.rate) &&
                Objects.equals(additionalProperties, rate1.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, assetIdQuote, rate, additionalProperties);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "time='" + time + '\'' +
                ", assetIdQuote='" + assetIdQuote + '\'' +
                ", rate=" + rate +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
