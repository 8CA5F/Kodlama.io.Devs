package com.eminerarslan.kodlama_io_dev.business.requests.subtechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubTechnologyRequest {
    @Size(min = 2, max = 15, message = "Sub technology size must be between 2-15")
    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Sub technologies must have a programming language")
    private int programmingLanguageId;
}
