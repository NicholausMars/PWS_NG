package com.weather.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.entity.Weather;

public class WeatherResponse {
	@JsonProperty(value = "id")
	private long id;
	// had problems with comparing the date 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "date")
	private LocalDate date;
	// connecting the location object to this
	@JsonProperty(value = "location")
	private LocationResponse location;
	@JsonProperty(value = "temperature")
	private List<Float> temperature;
	
	@Override
	public String toString() {
		return "Weather [id=" + id + ", date=" + date + ", location=" + location + ", temperature="
				+ temperature + "]";
	}
	
	public WeatherResponse(Weather weather){
		this.id = weather.getId();
		this.date = weather.getDate().toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
		this.location = new LocationResponse( weather.getLocation() );
		this.temperature = weather.getTemperature();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocationResponse getLocation() {
		return location;
	}
	public void setLocation(LocationResponse location) {
		this.location = location;
	}

	public List<Float> getTemperature() {
		return temperature;
	}

	public void setTemperature(List<Float> temperature) {
		this.temperature = temperature;
	}
}
