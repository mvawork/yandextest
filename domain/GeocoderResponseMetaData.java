
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "found",
    "results"
})
public class GeocoderResponseMetaData {

    @JsonProperty("request")
    private String request;
    @JsonProperty("found")
    private String found;
    @JsonProperty("results")
    private String results;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
    }

    @JsonProperty("found")
    public String getFound() {
        return found;
    }

    @JsonProperty("found")
    public void setFound(String found) {
        this.found = found;
    }

    @JsonProperty("results")
    public String getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(String results) {
        this.results = results;
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
