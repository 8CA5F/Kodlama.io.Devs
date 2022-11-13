package com.eminerarslan.kodlama_io_dev.business.abstracts;

import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.business.responses.programminglanguage.GetProgrammingLanguageByIdResponse;
import com.eminerarslan.kodlama_io_dev.core.utils.results.DataResult;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;

public interface ProgrammingLanguageService {
    Result getAll();

    DataResult<GetProgrammingLanguageByIdResponse> getById(int id);

    Result create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

    Result deleteById(int id);

    Result updateById(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
}
