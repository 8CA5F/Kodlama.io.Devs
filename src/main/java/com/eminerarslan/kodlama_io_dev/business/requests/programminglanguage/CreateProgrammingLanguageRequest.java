package com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingLanguageRequest {
    @Size(min = 1, max = 15, message = "Programming language size must be between 1-15")
    @NotNull(message = "Name is required")
    private String name;
}
