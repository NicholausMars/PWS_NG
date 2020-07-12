package com.weather.controller;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.Weather;
import com.weather.models.WeatherRequest;
import com.weather.models.WeatherResponse;
import com.weather.service.WeatherService;


@RestController
public class WeatherController {
	
	
	@Autowired
	WeatherService weatherService;

	@DeleteMapping(path="/erase")
	public ResponseEntity<?> eraseAllWeatherData(
			@RequestParam(name = "start", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
			@RequestParam(name = "end", required=false)   @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
			@RequestParam(name = "lat", defaultValue = "0") float latitude,
			@RequestParam(name = "lon", defaultValue = "0") float longitude){
		// remove all the weather === send 200 status
		// remove all weather data in the range with location coordinates
		
		System.out.println(
				"start :"+ startDate + 
				" || end :" + endDate +
				" || lat :"+ latitude +
				" || lon :"+ longitude );
		
		return ResponseEntity.ok().build();
	}
	
	

	@PostMapping(path="/weather")
	public ResponseEntity<?> newWeatherData(
			@RequestBody() WeatherRequest weather){
		ZoneId defaultZoneId = ZoneId.systemDefault();	
		System.out.println(weather);
//		 weatherService.newWeatherData(weather);
		return ResponseEntity.ok().build();
	}

	@GetMapping(path="/weather")
	public ResponseEntity<List<WeatherResponse>> getWeatherData(
			@RequestParam(name = "date", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			@RequestParam(name = "lat", defaultValue = "0") Double latitude,
			@RequestParam(name = "lon",defaultValue = "0") Double longitude
			) {
//		System.out.println("date : " + date);
		// if date is null (get all the weather data) array sorted ascending order
		// if we have date == return all dates with the weather date. if it doesn't exist http response 404
		// if we have lat and lon == return weather data filter by coordinates.  if request location does not exit return 404 
//		ArrayList<Weather> allweather = new ArrayList<Weather>();
		List<WeatherResponse> data = weatherService.getWeatherData(date, latitude , longitude);
		
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	
	
	
	
}
