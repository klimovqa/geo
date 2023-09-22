package com.geo.service.geoservice.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record GeoJson(

	@JsonProperty("features")
	List<CountryJson> features
) {
}