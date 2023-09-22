package com.geo.service.geoservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.service.geoservice.domain.CountryJson;
import com.geo.service.geoservice.domain.GeoJson;
import com.geo.service.geoservice.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final GeoService service;

    @Autowired
    public DatabaseInitializer(GeoService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        service.clear();
        ObjectMapper mapper = new ObjectMapper();
        GeoJson geoJson = mapper.readValue(new File("src/main/resources/country.json"), GeoJson.class);
        System.out.println();
        for (CountryJson country : geoJson.features()) {
            service.addCountry(country);
        }
    }
}
