package com.eminerarslan.kodlama_io_dev.exception.subtechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class SubTechnologyException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("Z"));
}
