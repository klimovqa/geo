package com.geo.service.geoservice.exception;

public class CountryCodeNotFoundException extends RuntimeException{
    public CountryCodeNotFoundException() {
    }

    public CountryCodeNotFoundException(String message) {
        super(message);
    }

    public CountryCodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryCodeNotFoundException(Throwable cause) {
        super(cause);
    }
}
