package com.eminerarslan.kodlama_io_dev.exception.subtechnologies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class SubTechnologyExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SubTechnologyNotFoundException.class)
    public ResponseEntity<?> handleSubTechnologyNotFound(SubTechnologyNotFoundException exception) {
        SubTechnologyException subTechnologyException = new SubTechnologyException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(subTechnologyException, subTechnologyException.getHttpStatus());
    }
}
