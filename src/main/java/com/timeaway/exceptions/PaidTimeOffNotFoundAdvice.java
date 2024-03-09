package com.timeaway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaidTimeOffNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PaidTimeOffNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String paidTimeOffNotFoundHandler(PaidTimeOffNotFoundException ex) {
        return ex.getMessage();
    }
}
