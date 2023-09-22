package com.geo.service.geoservice.service;

import com.geo.service.geoservice.data.GeoRepository;
import com.geo.service.geoservice.data.entity.GeoEntity;
import com.geo.service.geoservice.domain.CountryJson;
import com.geo.service.geoservice.exception.CountryCodeNotFoundException;
import com.geo.service.geoservice.exception.DuplicateCountryNameException;
import com.geo.service.geoservice.exception.LongCountryCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
public class GeoService {

    private final GeoRepository repository;

    @Autowired
    public GeoService(GeoRepository repository) {
        this.repository = repository;
    }


    public List<CountryJson> getAllGeo() {
        List<CountryJson> res = new ArrayList<>();
        Iterable<GeoEntity> all = repository.findAll();
        all.iterator().forEachRemaining(entity -> res.add(CountryJson.fromEntity(entity)));
        return res;
    }

    public CountryJson addCountry(CountryJson country) {
        GeoEntity entity = GeoEntity.fromJson(country);
        validateCountryCode(country);
        Optional<GeoEntity> countryName = repository.findByCountryName(country.name());
        if (countryName.isPresent()) {
            throw new DuplicateCountryNameException("A country with this name already exists");
        }
        GeoEntity save = repository.save(entity);
        return CountryJson.fromEntity(save);
    }

    public CountryJson changeCountry(String countryCode, CountryJson countryJson) {
        GeoEntity newCountry;
        validateCountryCode(countryJson);
        Optional<GeoEntity> country = repository.findByCountryCode(countryCode);
        existCountryCode(countryCode, country);
        newCountry = repository.save(country.get().updateEntity(countryJson));
        return CountryJson.fromEntity(newCountry);
    }

    public void deleteCountry(String countryCode) {
        Optional<GeoEntity> country = repository.findByCountryCode(countryCode);
        existCountryCode(countryCode, country);
        repository.delete(country.get());
    }

    public void clear() {
        repository.deleteAll();
    }

    private void validateCountryCode(CountryJson countryJson) {
        if (countryJson.code().length() > 4) {
            throw new LongCountryCodeException("The country code must be no more than 4 characters");
        }
    }


    private void existCountryCode(String countryCode, Optional<GeoEntity> country) {
        if (country.isEmpty()) {
            throw new CountryCodeNotFoundException(format("Country code {%s} not found",
                    countryCode));
        }
    }

}
