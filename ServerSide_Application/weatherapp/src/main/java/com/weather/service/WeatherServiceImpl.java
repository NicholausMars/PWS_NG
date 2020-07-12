package com.weather.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.data.WeatherRepository;
import com.weather.entity.Weather;




@Service
public class WeatherServiceImpl  implements WeatherService{
	WeatherRepository weatherRepository;
	private ArrayList<Weather> collectedData;
	private ModelMapper modelMapper ;
	@Autowired
	WeatherServiceImpl(WeatherRepository weatherRepository){
		
		this.weatherRepository = weatherRepository;
		this.modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Override
	public Weather eraseAllWeatherData() {
		return null;
	}

	@Override
	public Weather newWeatherData(Weather weather) {
		// TODO Auto-generated method stub
		weatherRepository.save(weather);
		return null;
	}

	@Override
	public ArrayList<Weather> getWeatherData(Date date, float latitude, float longitude) {
		collectedData = new ArrayList<Weather>();
		// TODO Auto-generated method stub
		System.out.println("by date");
		System.out.println(weatherRepository.getAllWithDate(date) );
		System.out.println(weatherRepository.getAllWithLocation(longitude));
		return collectedData;
	}


}
