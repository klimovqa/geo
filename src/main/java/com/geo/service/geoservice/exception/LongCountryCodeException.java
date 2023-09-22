package com.geo.service.geoservice.exception;

public class LongCountryCodeException extends RuntimeException{
    public LongCountryCodeException() {
    }

    public LongCountryCodeException(String message) {
        super(message);
    }

    public LongCountryCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LongCountryCodeException(Throwable cause) {
        super(cause);
    }
}
