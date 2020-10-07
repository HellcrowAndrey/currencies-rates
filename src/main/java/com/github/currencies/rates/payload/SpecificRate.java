package com.github.currencies.rates.payload;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "asset_id_base",
        "asset_id_quote",
        "rate"
})
public class SpecificRate {

    @JsonProperty("time")
    private String time;
    @JsonProperty("asset_id_base")
    private String assetIdBase;
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

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("asset_id_base")
    public String getAssetIdBase() {
        return assetIdBase;
    }

    @JsonProperty("asset_id_base")
    public void setAssetIdBase(String assetIdBase) {
        this.assetIdBase = assetIdBase;
    }

    @JsonProperty("asset_id_quote")
    public String getAssetIdQuote() {
        return assetIdQuote;
    }

    @JsonProperty("asset_id_quote")
    public void setAssetIdQuote(String assetIdQuote) {
        this.assetIdQuote = assetIdQuote;
    }

    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificRate that = (SpecificRate) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(assetIdBase, that.assetIdBase) &&
                Objects.equals(assetIdQuote, that.assetIdQuote) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, assetIdBase, assetIdQuote, rate, additionalProperties);
    }

    @Override
    public String toString() {
        return "SpecificRate{" +
                "time='" + time + '\'' +
                ", assetIdBase='" + assetIdBase + '\'' +
                ", assetIdQuote='" + assetIdQuote + '\'' +
                ", rate=" + rate +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
