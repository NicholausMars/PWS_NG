package com.weather.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//@Getter
//@Setter
public class LocationRequest {
	@JsonProperty(value = "city")
	private String city;
	@JsonProperty(value = "state")
	private String state;
	@JsonProperty(value = "lat")
	private Double lat;
	@JsonProperty(value = "lon")
	private Double lon;
	@Override
	public String toString() {
		return "LocationRequest [city=" + city + ", state=" + state + ", lat=" + lat + ", lon=" + lon + "]";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}

	
	
}
