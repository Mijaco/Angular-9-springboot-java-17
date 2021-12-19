package com.manoelh.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class personNotFoundException extends Exception {
    public personNotFoundException(Long id) {
        super("No one person have found with ID "+id);
    }
}
