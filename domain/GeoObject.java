
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metaDataProperty",
    "description",
    "name",
    "boundedBy",
    "Point"
})
public class GeoObject {

    @JsonProperty("metaDataProperty")
    private MetaDataProperty_ metaDataProperty;
    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("boundedBy")
    private BoundedBy boundedBy;
    @JsonProperty("Point")
    private Point point;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("metaDataProperty")
    public MetaDataProperty_ getMetaDataProperty() {
        return metaDataProperty;
    }

    @JsonProperty("metaDataProperty")
    public void setMetaDataProperty(MetaDataProperty_ metaDataProperty) {
        this.metaDataProperty = metaDataProperty;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("boundedBy")
    public BoundedBy getBoundedBy() {
        return boundedBy;
    }

    @JsonProperty("boundedBy")
    public void setBoundedBy(BoundedBy boundedBy) {
        this.boundedBy = boundedBy;
    }

    @JsonProperty("Point")
    public Point getPoint() {
        return point;
    }

    @JsonProperty("Point")
    public void setPoint(Point point) {
        this.point = point;
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
