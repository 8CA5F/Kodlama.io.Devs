package com.eminerarslan.kodlama_io_dev.business.responses.programminglanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProgrammingLanguageByIdResponse {
    private int id;
    private int name;
}
