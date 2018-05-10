
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "text",
    "precision",
    "Address",
    "AddressDetails"
})
public class GeocoderMetaData {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("text")
    private String text;
    @JsonProperty("precision")
    private String precision;
    @JsonProperty("Address")
    private Address address;
    @JsonProperty("AddressDetails")
    private AddressDetails addressDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("precision")
    public String getPrecision() {
        return precision;
    }

    @JsonProperty("precision")
    public void setPrecision(String precision) {
        this.precision = precision;
    }

    @JsonProperty("Address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("AddressDetails")
    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    @JsonProperty("AddressDetails")
    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
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
