
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "LocalityName",
    "Thoroughfare"
})
public class Locality {

    @JsonProperty("LocalityName")
    private String localityName;
    @JsonProperty("Thoroughfare")
    private Thoroughfare thoroughfare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("LocalityName")
    public String getLocalityName() {
        return localityName;
    }

    @JsonProperty("LocalityName")
    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    @JsonProperty("Thoroughfare")
    public Thoroughfare getThoroughfare() {
        return thoroughfare;
    }

    @JsonProperty("Thoroughfare")
    public void setThoroughfare(Thoroughfare thoroughfare) {
        this.thoroughfare = thoroughfare;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
