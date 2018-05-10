
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ThoroughfareName",
    "Premise"
})
public class Thoroughfare {

    @JsonProperty("ThoroughfareName")
    private String thoroughfareName;
    @JsonProperty("Premise")
    private Premise premise;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ThoroughfareName")
    public String getThoroughfareName() {
        return thoroughfareName;
    }

    @JsonProperty("ThoroughfareName")
    public void setThoroughfareName(String thoroughfareName) {
        this.thoroughfareName = thoroughfareName;
    }

    @JsonProperty("Premise")
    public Premise getPremise() {
        return premise;
    }

    @JsonProperty("Premise")
    public void setPremise(Premise premise) {
        this.premise = premise;
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
