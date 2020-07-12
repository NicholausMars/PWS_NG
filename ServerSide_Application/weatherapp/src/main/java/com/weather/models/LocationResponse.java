package com.weather.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.entity.Location;

public class LocationResponse {

	@JsonProperty(value = "city")
	private String city;
	@JsonProperty(value = "state")
	private String state;
	@JsonProperty(value = "lat")
	private Double lat;
	@JsonProperty(value = "lon")
	private Double lon;
	
	LocationResponse(Location location){
		this.city = location.getCity();
		this.state = location.getState();
		this.lat = location.getLat();
		this.lon = location.getLon();
	}
	
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
