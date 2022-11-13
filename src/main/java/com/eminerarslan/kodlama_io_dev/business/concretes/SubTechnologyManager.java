package com.eminerarslan.kodlama_io_dev.business.concretes;

import com.eminerarslan.kodlama_io_dev.business.abstracts.SubTechnologyService;
import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.CreateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.UpdateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.business.responses.subtechnology.GetSubTechnologyByIdResponse;
import com.eminerarslan.kodlama_io_dev.core.utils.results.DataResult;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;
import com.eminerarslan.kodlama_io_dev.core.utils.results.SuccessDataResult;
import com.eminerarslan.kodlama_io_dev.entities.concretes.SubTechnology;
import com.eminerarslan.kodlama_io_dev.exception.subtechnologies.SubTechnologyNotFoundException;
import com.eminerarslan.kodlama_io_dev.mappers.SubTechnologyMapper;
import com.eminerarslan.kodlama_io_dev.repository.abstracts.SubTechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTechnologyManager implements SubTechnologyService {
    SubTechnologyRepository subTechnologyRepository;
    SubTechnologyMapper subTechnologyMapper;

    @Autowired
    public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, SubTechnologyMapper subTechnologyMapper) {
        this.subTechnologyRepository = subTechnologyRepository;
        this.subTechnologyMapper = subTechnologyMapper;
    }

    //Get programming language by id for service methods
    private SubTechnology getSubTechnologyById(int id) {
        return subTechnologyRepository.findById(id)
                .orElseThrow(() -> new SubTechnologyNotFoundException(
                        "Sub technology not found"
                ));
    }
    //Get programming language by id for service methods end

    @Override
    public Result getAll() {
        return new SuccessDataResult<>(subTechnologyMapper.toGetAllSubTechnologiesResponse(
                subTechnologyRepository.findAll()
        ));
    }

    @Override
    public DataResult<GetSubTechnologyByIdResponse> getById(int id) {
        return new SuccessDataResult<>(subTechnologyMapper.toGetSubTechnologyByIdResponse(
                getSubTechnologyById(id)
        ));
    }

    @Override
    public Result create(CreateSubTechnologyRequest createSubTechnologyRequest) {
        return new SuccessDataResult<>(subTechnologyMapper.toCreateSubTechnologyResponse(
                subTechnologyRepository.save(
                        subTechnologyMapper.toCreateSubTechnologyRequest(createSubTechnologyRequest)
                )
        ));
    }

    @Override
    public Result deleteById(int id) {
        SubTechnology toDelete = getSubTechnologyById(id);
        subTechnologyRepository.deleteById(id);
        return new SuccessDataResult<>(subTechnologyMapper.toDeleteSubTechnologyResponse(
                toDelete
        ));
    }

    @Override
    public Result updateById(int id, UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        SubTechnology toUpdate = getSubTechnologyById(id);
        String oldName = toUpdate.getName();
        SubTechnology mappedSubTechnology = subTechnologyMapper.updateSubTechnology(
                toUpdate, updateSubTechnologyRequest
        );
        SubTechnology savedSubTechnology = subTechnologyRepository.save(mappedSubTechnology);
        return new SuccessDataResult<>(
                subTechnologyMapper.toUpdateSubTechnologyRequest(savedSubTechnology),
                oldName + " updated to " + savedSubTechnology.getName()
        );
    }
}
