package ru.sovcombank.yandextest;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.logging.LoggingFeature;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Configuration
public class ApplicationConfig {
    @Bean
    public FilterRegistrationBean registration(HiddenHttpMethodFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public Client createClient() {
        return ClientBuilder.newClient()
                .property(ClientProperties.CONNECT_TIMEOUT, 60000)
                .property(ClientProperties.READ_TIMEOUT, 60000)
                .register(LoggingFeature.class);
    }
}
