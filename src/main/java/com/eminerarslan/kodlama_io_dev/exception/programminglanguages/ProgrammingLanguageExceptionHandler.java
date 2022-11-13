package com.eminerarslan.kodlama_io_dev.exception.programminglanguages;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ProgrammingLanguageExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProgrammingLanguageNotFoundException.class)
    public ResponseEntity<?> handleProgrammingLanguageNotFound(ProgrammingLanguageNotFoundException exception) {
        ProgrammingLanguageException programmingLanguageException = new ProgrammingLanguageException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(programmingLanguageException, programmingLanguageException.getHttpStatus());
    }
}
