
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lowerCorner",
    "upperCorner"
})
public class Envelope {

    @JsonProperty("lowerCorner")
    private String lowerCorner;
    @JsonProperty("upperCorner")
    private String upperCorner;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lowerCorner")
    public String getLowerCorner() {
        return lowerCorner;
    }

    @JsonProperty("lowerCorner")
    public void setLowerCorner(String lowerCorner) {
        this.lowerCorner = lowerCorner;
    }

    @JsonProperty("upperCorner")
    public String getUpperCorner() {
        return upperCorner;
    }

    @JsonProperty("upperCorner")
    public void setUpperCorner(String upperCorner) {
        this.upperCorner = upperCorner;
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
