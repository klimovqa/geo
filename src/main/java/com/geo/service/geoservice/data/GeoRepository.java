package com.geo.service.geoservice.data;

import com.geo.service.geoservice.data.entity.GeoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface GeoRepository extends CrudRepository<GeoEntity, UUID> {

    Optional<GeoEntity> findByCountryCode(String countryCode);
    Optional<GeoEntity> findByCountryName(String countryName);
}
