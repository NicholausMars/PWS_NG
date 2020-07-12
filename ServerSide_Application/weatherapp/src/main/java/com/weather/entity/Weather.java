package com.weather.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "weather")
public class Weather implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6390313435997806661L;
	@Id
	@Column(unique=true, name="id")
	private long id;
	
	// had problems with comparing the date 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name= "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	// connecting the location object to this
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "location")
	private Location location;
    
	@CollectionTable(name ="temperature")
	private float [] temperature;
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public float[] getTemperature() {
		return temperature;
	}
	public void setTemperature(float[] temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Weather [id=" + id + ", date=" + date + ", location=" + location + ", temperature="
				+ Arrays.toString(temperature) + "]";
	}

	
	
}
