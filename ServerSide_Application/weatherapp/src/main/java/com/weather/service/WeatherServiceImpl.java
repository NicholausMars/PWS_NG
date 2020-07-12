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
	public Weather eraseAllWeatherData() {
		return null;
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
		return null;
	}

	@Override
	public List<WeatherResponse> getWeatherData(Date date, Double latitude, Double longitude) {
		List<WeatherResponse> collectedData = new ArrayList<WeatherResponse>();
//		DecimalFormat decimal = new DecimalFormat("#.0000");	
		// TODO search by date, one-to-one, 
		System.out.println("by date");
		
		 
//		collectedData = 
//		collectedData.addAll(	weatherRepository.getAllWithDate(date) );
		weatherRepository.getAllWithDate(date).forEach(
		weather -> {
//			System.out.println(weather);
			collectedData.add(new WeatherResponse(weather));
	
		});
		
		
		
//		System.out.println(	weatherRepository.getAllWithDate(date));//.stream().map(weather ->weather).collect(Collectors.toList());
		// need to be able to search the one to one mapping 
//		System.out.println("longitude");
//		System.out.println(decimal.format(longitude));
//		System.out.println( weatherRepository.getAllWithLocationLong( longitude ) );
//		System.out.println("city");
//		List<Weather> weather = weatherRepository.getAllWithLocationCity("kingston");
//		System.out.println(weather.get(0).getLocation().getState());
		return collectedData;
	}


}
