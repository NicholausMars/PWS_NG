package com.weather.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.entity.Location;


import lombok.Getter;
import lombok.Setter;



public class WeatherRequest {

	@JsonProperty(value = "id")
	private long id;
	// had problems with comparing the date 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "date")
	private LocalDate date;
	// connecting the location object to this
	@JsonProperty(value = "location")
	private LocationRequest location;
	@JsonProperty(value = "temperature")
	private List<Float> temperature;
	
	@Override
	public String toString() {
		return "Weather [id=" + id + ", date=" + date + ", location=" + location + ", temperature="
				+ temperature + "]";
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
	public LocationRequest getLocation() {
		return location;
	}
	public void setLocation(LocationRequest location) {
		this.location = location;
	}

	public List<Float> getTemperature() {
		return temperature;
	}

	public void setTemperature(List<Float> temperature) {
		this.temperature = temperature;
	}

	
}
