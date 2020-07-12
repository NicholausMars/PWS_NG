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

@Entity
@Table(name = "location")
public class Location implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5809819445416835907L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
    private Long id;
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, optional = false)
    private Weather weather;
	@Column(name= "city")
	private String city;
	@Column(name= "state")
	private String state;
	@Column(name= "lat")
	private float lat;
	@Column(name= "lon")
	private float lon;
	
	
	
	
	
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
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
	

	
	
}
