package com.geo.service.geoservice.controller;

import com.geo.service.geoservice.domain.CountryJson;
import com.geo.service.geoservice.domain.Response;
import com.geo.service.geoservice.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("/geo")
public class GeoController {

    private final GeoService service;

    @Autowired
    public GeoController(GeoService service) {
        this.service = service;
    }

    @GetMapping()
    List<CountryJson> getAllCountry(){
        return service.getAllGeo();
    }

    @PostMapping()
    ResponseEntity<CountryJson> addCountry(@RequestBody CountryJson country){
        CountryJson addedCountry = service.addCountry(country);
        return new ResponseEntity<>(addedCountry, HttpStatus.CREATED);
    }

    @PatchMapping("/{countryCode}")
    ResponseEntity<CountryJson> changeCountry(@PathVariable String countryCode,
                                              @RequestBody CountryJson country){
        CountryJson changeCountry = service.changeCountry(countryCode, country);
        return new ResponseEntity<>(changeCountry, HttpStatus.OK);
    }

    @DeleteMapping("/{countryCode}")
    ResponseEntity<Response> deleteCountry(@PathVariable String countryCode){
        service.deleteCountry(countryCode.toUpperCase());
        return new ResponseEntity<>(new Response(
                format("The country with the code {%s} has been successfully deleted", countryCode)),
                HttpStatus.OK);
    }
}
