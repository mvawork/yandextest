package ru.sovcombank.yandextest.yandexapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sovcombank.yandextest.yandexapi.domain.YandexGeocoderResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class YandexGeocoderClient {

    private static Logger logger = LoggerFactory.getLogger(YandexGeocoderClient.class);

    private final Client client;


    @Autowired
    public YandexGeocoderClient(Client client) {
        this.client = client;
    }

    public String RequestGeo(String address) {
        try {
            logger.info("Request position for address " + address);
            Response response = client
                    //.target("https://geocode-maps.yandex.ru/1.x/?format=json&geocode=" + address)
                    .target("http://localhost:8090/get")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();
            if (response.getStatus() == 200) {
                logger.info("Reading response");
                YandexGeocoderResponse geocoderResponse = response.readEntity(YandexGeocoderResponse.class);
                if (geocoderResponse != null &&
                        geocoderResponse.getResponse() != null &&
                        geocoderResponse.getResponse().getGeoObjectCollection() != null &&
                        geocoderResponse.getResponse().getGeoObjectCollection().getFeatureMember() != null &&
                        !geocoderResponse.getResponse().getGeoObjectCollection().getFeatureMember().isEmpty() &&
                        geocoderResponse.getResponse().getGeoObjectCollection().getFeatureMember().get(0).getGeoObject() != null &&
                        geocoderResponse.getResponse().getGeoObjectCollection().getFeatureMember().get(0).getGeoObject().getPoint() != null
                        ) {

                    String pos = geocoderResponse.getResponse().getGeoObjectCollection().getFeatureMember().get(0).getGeoObject().getPoint().getPos();
                    logger.info("Position " + pos);
                    return pos;
                }
                logger.error("Position is null");
                return null;

            } else {
                logger.error("Error status code {}", response.getStatus());
                return null;
            }
        } catch (Exception e) {
            logger.error("Reading position error", e);
            return null;
        }
    }

}
