package com.eminerarslan.kodlama_io_dev.exception.programminglanguages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProgrammingLanguageNotFoundException extends RuntimeException {
    public ProgrammingLanguageNotFoundException(String message) {
        super(message);
    }
}
