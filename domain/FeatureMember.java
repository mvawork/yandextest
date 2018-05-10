
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "GeoObject"
})
public class FeatureMember {

    @JsonProperty("GeoObject")
    private GeoObject geoObject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("GeoObject")
    public GeoObject getGeoObject() {
        return geoObject;
    }

    @JsonProperty("GeoObject")
    public void setGeoObject(GeoObject geoObject) {
        this.geoObject = geoObject;
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
