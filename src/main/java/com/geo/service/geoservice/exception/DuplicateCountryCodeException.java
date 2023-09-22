package com.geo.service.geoservice.exception;

public class DuplicateCountryCodeException extends RuntimeException{
    public DuplicateCountryCodeException() {
    }

    public DuplicateCountryCodeException(String message) {
        super(message);
    }

    public DuplicateCountryCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateCountryCodeException(Throwable cause) {
        super(cause);
    }
}
