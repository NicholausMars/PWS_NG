package com.weather.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.entity.Location;
import com.weather.models.WeatherRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


//@Getter
//@Setter
@Entity
@Table(name = "weather")
public class Weather implements Serializable {
	
	/**
	 * 
	 */
//	@Getter(value = AccessLevel.NONE)
//	@Setter(value = AccessLevel.NONE)
	private static final long serialVersionUID = 6390313435997806661L;
	@Id
	@Column(unique=true, name="id")
	private long id;
	public Weather(){}
	public Weather(WeatherRequest weatherRequest){
		this.id = weatherRequest.getId();
//		this.date = new Date();//weatherRequest.getDate();
		this.location = new Location(weatherRequest.getLocation());
		this.temperature = weatherRequest.getTemperature();
		
	}

	
	// had problems with comparing the date 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Column(name= "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	// connecting the location object to this
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "location")
	private Location location;
    
	@CollectionTable(name ="temperature")
	@ElementCollection
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
	public List<Float> getTemperature() {
		return temperature;
	}
	public void setTemperature(List<Float> temperature) {
		this.temperature = temperature;
	}
	
}
