package ru.sovcombank.yandextest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.sovcombank.yandextest.yandexapi.YandexGeocoderClient;

import java.math.BigDecimal;
import java.util.concurrent.Semaphore;

@Component
public class YandexTask {


    private static Logger log = LoggerFactory.getLogger(YandexTask.class);
    private Semaphore geoLock;
    private final YandexGeocoderClient geocoderClient;

    @Autowired
    public YandexTask(YandexGeocoderClient geocoderClient) {
        this.geocoderClient = geocoderClient;
        geoLock = new Semaphore(1);
    }

    @Scheduled(cron = "${yandexgeo.cron}")
    public void getCoordinates() {
        log.info("getCoordinates begin");
        try {
            if (geoLock.tryAcquire()) {
                try {
                    log.info("geoLock success");
                        String pos = geocoderClient.RequestGeo("%D0%B3%20%D0%A2%D0%BE%D0%BC%D1%81%D0%BA,%20%D1%83%D0%BB%20%D0%9A%D1%80%D1%8B%D0%BB%D0%BE%D0%B2%D0%B0,%20%D0%B4%D0%BE%D0%BC14,%20%D0%BA%D0%B2.1");
                        BigDecimal lat = null;
                        BigDecimal lon = null;
                        if (pos != null) {
                            String[] arrPos = pos.split(" ");
                            lat = new BigDecimal(arrPos[0]);
                            lon = new BigDecimal(arrPos[1]);
                        }
                } finally {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ignored) {

                    }
                    geoLock.release();
                    log.info("geoLock release");
                }
            } else {
                log.info("geoLock not success");
            }
            log.info("getCoordinates end");
        } catch (Exception e) {
            log.info("Error:",e);
        }
    }
}
