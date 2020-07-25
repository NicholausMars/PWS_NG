package com.weather.service;

import java.text.DecimalFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.Mapper;
import com.weather.data.WeatherRepository;
import com.weather.entity.Weather;
import com.weather.models.WeatherRequest;
import com.weather.models.WeatherResponse;




@Service
public class WeatherServiceImpl  implements WeatherService{
	WeatherRepository weatherRepository;
	private ModelMapper modelMapper ;
	@Autowired
	Mapper mapper;
//	@Autowired
//	LocalDate convertToLocalDateViaMilisecond;
	
	@Autowired
	WeatherServiceImpl(WeatherRepository weatherRepository){
		
		this.weatherRepository = weatherRepository;
		this.modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Override
	public void eraseAllWeatherData() {
		weatherRepository.deleteAll();
	}
	@Override
	public void eraseConditionWeather(Date start, Date end, Double lon, Double lat) {
		// TODO Auto-generated method stub
//	    weatherRepository.deleteConditionalFields(start, end);
	}

	

	@Override
	public Weather newWeatherData(WeatherRequest weatherdto) {
		// TODO Auto-generated method stub

		// The date always seems to come out wrong so this is to help with that
		// basically we are transfering the localDate to the Date feild and then save it
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from( weatherdto.getDate().atStartOfDay(defaultZoneId).toInstant());
		
		Weather weather = new Weather(weatherdto);
		weather.setDate(date);
		weatherRepository.save(weather);
		weatherRepository.flush();
		return null;
	}

	@Override
	public List<WeatherResponse> getWeatherData(Date date, Double latitude, Double longitude) {
		List<WeatherResponse> collectedData = new ArrayList<WeatherResponse>();
//		DecimalFormat decimal = new DecimalFormat("#.0000");	
		// TODO search by date, one-to-one, 
//		System.out.println("by date");
//		System.out.println(date);
		 if(date == null || latitude <= -91 || longitude <= -180) {
			 weatherRepository.findAll().forEach(
					 	weather ->{
					 		collectedData.add(new WeatherResponse(weather));
					 	}
			);
		 }else {
				weatherRepository.getAllWithDate(date).forEach(
						weather -> {
							collectedData.add(new WeatherResponse(weather));
						}); 
		 }
		return collectedData;
	}

	

}
