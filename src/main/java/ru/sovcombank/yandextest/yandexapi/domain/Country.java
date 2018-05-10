
package ru.sovcombank.yandextest.yandexapi.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AddressLine",
    "postal_code",
    "CountryNameCode",
    "CountryName",
    "AdministrativeArea"
})
public class Country {

    @JsonProperty("AddressLine")
    private String addressLine;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("CountryNameCode")
    private String countryNameCode;
    @JsonProperty("CountryName")
    private String countryName;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea administrativeArea;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AddressLine")
    public String getAddressLine() {
        return addressLine;
    }

    @JsonProperty("AddressLine")
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postal_code")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("CountryNameCode")
    public String getCountryNameCode() {
        return countryNameCode;
    }

    @JsonProperty("CountryNameCode")
    public void setCountryNameCode(String countryNameCode) {
        this.countryNameCode = countryNameCode;
    }

    @JsonProperty("CountryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("CountryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("AdministrativeArea")
    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    @JsonProperty("AdministrativeArea")
    public void setAdministrativeArea(AdministrativeArea administrativeArea) {
        this.administrativeArea = administrativeArea;
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
