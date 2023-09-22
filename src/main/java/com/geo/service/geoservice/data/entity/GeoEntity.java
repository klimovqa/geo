package com.geo.service.geoservice.data.entity;

import com.geo.service.geoservice.domain.CountryJson;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "geo")
public class GeoEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "country_name", unique = true, nullable = false)
    private String countryName;

    @Column(name = "country_code", unique = true, nullable = false, length = 4)
    private String countryCode;
    @Column(name = "coordinates", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<List<List<List<Double>>>> coordinates;


    public static GeoEntity fromJson(CountryJson json){
        GeoEntity entity = new GeoEntity();
        entity.setCountryName(json.name());
        entity.setCountryCode(json.code());
        entity.setCoordinates(json.coordinates());
        return entity;
    }
    public GeoEntity updateEntity(CountryJson json){
        this.setCountryName(json.name());
        this.setCountryCode(json.code());
        this.setCoordinates(json.coordinates());
        return this;
    }

    public List<List<List<List<Double>>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<List<Double>>>> coordinates) {
        this.coordinates = coordinates;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoEntity that = (GeoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName);
    }
}
