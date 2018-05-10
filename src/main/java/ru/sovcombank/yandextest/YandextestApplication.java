package ru.sovcombank.yandextest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YandextestApplication {

	public static void main(String[] args) {
		SpringApplication.run(YandextestApplication.class, args);
	}
}
