package com.weather.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.weather.entity.Weather;
import com.weather.models.WeatherRequest;
import com.weather.models.WeatherResponse;

public interface WeatherService {
	void eraseAllWeatherData();
	void eraseConditionWeather(Date start, Date end, Double lon, Double lat);
	Weather newWeatherData(WeatherRequest weather);
	List<WeatherResponse> getWeatherData(Date date, Double latitude, Double longitude);
}
