package com.eminerarslan.kodlama_io_dev.business.abstracts;

import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.CreateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.UpdateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.business.responses.subtechnology.GetSubTechnologyByIdResponse;
import com.eminerarslan.kodlama_io_dev.core.utils.results.DataResult;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;

public interface SubTechnologyService {
    Result getAll();

    DataResult<GetSubTechnologyByIdResponse> getById(int id);

    Result create(CreateSubTechnologyRequest createSubTechnologyRequest);

    Result deleteById(int id);

    Result updateById(int id, UpdateSubTechnologyRequest updateSubTechnologyRequest);
}
