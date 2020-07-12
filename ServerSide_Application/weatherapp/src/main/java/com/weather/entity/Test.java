package com.weather.entity;

public class Test {
	private long id;
	private String date;
	private String location;
	private String temperature;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", date=" + date + ", location=" + location + ", temperature=" + temperature + "]";
	}
	
	
	

}
