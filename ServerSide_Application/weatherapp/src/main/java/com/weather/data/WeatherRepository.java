package com.weather.data;
import java.util.Date;
import java.util.List;

import javax.persistence.Converter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.weather.entity.Weather;

/*
 * 
 * 
 * write custom queries or use JPA stuff
 * */
public interface WeatherRepository extends JpaRepository< Weather, Long> {

		@Query("SELECT w FROM Weather w WHERE w.date = :date")
		List<Weather> getAllWithDate(@Param("date") Date date);
		
		@Query("SELECT w FROM Weather w WHERE w.location.lon <= :findlon")
		List<Weather> getAllWithLocationLong(@Param("findlon") Double lon);
		
		@Query("SELECT w FROM Weather w WHERE w.location.city = :city")
		List<Weather> getAllWithLocationCity(@Param("city") String city);
		
		@Query("SELECT w FROM Weather w WHERE w.id = :idfind")
		List<Weather> getAllWithId(@Param("idfind") long id);

		@Query("DELETE FROM Weather w  WHERE w.date BETWEEN :start AND :end"
//				+ "join Location l  on w.id = l.id"
				)
//				+ " WHERE w.date BETWEEN :start  AND  :end AND l.lat = :lat AND l.lon = :lon")
		void deleteConditionalFields(
				@Param("start") Date start,
				@Param("end") Date end//,
//				@Param("lon") Double lon,
//				@Param("lat") Double lat
				
				);
//		@Query("DELETE FROM Weather")
//		void deleteAll();
}
