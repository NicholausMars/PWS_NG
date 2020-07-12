package com.weather;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApplication.class, args);
	}

//	@Bean()
//	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
//		return dateToConvert.toInstant()
//			      .atZone(ZoneId.systemDefault())
//			      .toLocalDate();
//	}
}
