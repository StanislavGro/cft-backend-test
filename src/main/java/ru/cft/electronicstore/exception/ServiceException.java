package ru.cft.electronicstore.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends Exception{

    private final HttpStatus httpStatus;

    public ServiceException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
