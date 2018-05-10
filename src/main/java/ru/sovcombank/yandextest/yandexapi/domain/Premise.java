
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PremiseNumber"
})
public class Premise {

    @JsonProperty("PremiseNumber")
    private String premiseNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PremiseNumber")
    public String getPremiseNumber() {
        return premiseNumber;
    }

    @JsonProperty("PremiseNumber")
    public void setPremiseNumber(String premiseNumber) {
        this.premiseNumber = premiseNumber;
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
