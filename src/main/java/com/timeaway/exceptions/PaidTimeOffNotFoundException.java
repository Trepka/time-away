package com.timeaway.exceptions;

public class PaidTimeOffNotFoundException extends RuntimeException{

    public PaidTimeOffNotFoundException(Long id) {
        super("Could not find vacation dates " + id);
    }
}
