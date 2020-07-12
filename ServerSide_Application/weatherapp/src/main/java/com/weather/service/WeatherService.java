package com.weather.service;

import java.util.ArrayList;
import java.util.Date;

import com.weather.entity.Weather;

public interface WeatherService {
	Weather eraseAllWeatherData();
	Weather newWeatherData(Weather weather);
	ArrayList<Weather> getWeatherData(Date date, float latitude, float longitude);
}
