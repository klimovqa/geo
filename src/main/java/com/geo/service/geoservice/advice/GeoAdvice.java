package com.geo.service.geoservice.advice;

import com.geo.service.geoservice.domain.Response;
import com.geo.service.geoservice.exception.CountryCodeNotFoundException;
import com.geo.service.geoservice.exception.DuplicateCountryCodeException;
import com.geo.service.geoservice.exception.DuplicateCountryNameException;
import com.geo.service.geoservice.exception.LongCountryCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GeoAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DuplicateCountryCodeException.class)
    public ResponseEntity<Response> handleException(DuplicateCountryCodeException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CountryCodeNotFoundException.class)
    public ResponseEntity<Response> handleException(CountryCodeNotFoundException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LongCountryCodeException.class)
    public ResponseEntity<Response> handleException(LongCountryCodeException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateCountryNameException.class)
    public ResponseEntity<Response> handleException(DuplicateCountryNameException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
