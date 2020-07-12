package com.weather.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.models.LocationRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


//@Getter
//@Setter
@Entity
@Table(name = "location")
public class Location implements Serializable {
	
	
    /**
	 * 
	 */
//	@Getter(value = AccessLevel.NONE)
//	@Setter(value = AccessLevel.NONE)
	private static final long serialVersionUID = 5809819445416835907L;
	Location(){}
	Location(LocationRequest location){
		this.city = location.getCity();
		this.state = location.getState();
		this.lat = location.getLat();
		this.lon = location.getLon();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
    private Long id;
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, optional = true)
    private Weather weather;
	@Column(name= "city")
	private String city;
	@Column(name= "state")
	private String state;
	@Column(name= "lat", precision = 4)
	private Double lat;
	@Column(name= "lon", precision = 4)
	private Double lon;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
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
