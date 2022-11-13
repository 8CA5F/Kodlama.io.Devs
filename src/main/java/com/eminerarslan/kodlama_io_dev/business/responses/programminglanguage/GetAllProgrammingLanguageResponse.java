package com.eminerarslan.kodlama_io_dev.business.responses.programminglanguage;

import com.eminerarslan.kodlama_io_dev.business.responses.subtechnology.GetAllSubTechnologyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguageResponse {
    private int id;
    private String name;
    private List<GetAllSubTechnologyResponse> subTechnologies;
}
