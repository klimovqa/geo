package com.geo.service.geoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geo.service.geoservice.data.entity.GeoEntity;

import java.util.List;


public record CountryJson(

	@JsonProperty("I")
	String code,
	@JsonProperty("N")
	String name,
	@JsonProperty("C")
	List<List<List<List<Double>>>> coordinates
) {


	public static CountryJson fromEntity(GeoEntity entity){
		return new CountryJson(entity.getCountryCode(), entity.getCountryName(), entity.getCoordinates());
	}
}