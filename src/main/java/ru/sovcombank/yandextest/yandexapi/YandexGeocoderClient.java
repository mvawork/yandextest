package ru.sovcombank.yandextest.yandexapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sovcombank.yandextest.yandexapi.domain.YandexGeocoderResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

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

            URI uri = client
                    .target("http://localhost:8090/get")
                    .getUriBuilder()
                    .queryParam("geocode", address)
                    .build();
            Response response = client
                    .target(uri)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            if (response.getStatus() == 200) {
                logger.info("Reading response");
                String pos = response.readEntity(String.class);
                logger.info("Position " + pos);
                return "OK";
                }
                logger.error("Position is null");
                return null;
        } catch (Exception e) {
            logger.error("Reading position error", e);
            return null;
        }
    }

}
