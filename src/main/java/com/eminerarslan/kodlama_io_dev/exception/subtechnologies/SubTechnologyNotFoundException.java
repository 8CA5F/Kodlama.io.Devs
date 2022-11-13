package com.eminerarslan.kodlama_io_dev.exception.subtechnologies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubTechnologyNotFoundException extends RuntimeException {
    public SubTechnologyNotFoundException(String message) {
        super(message);
    }
}
