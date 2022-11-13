package com.eminerarslan.kodlama_io_dev.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class GlobalException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("Z"));
}
