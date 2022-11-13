package com.eminerarslan.kodlama_io_dev.business.concretes;

import com.eminerarslan.kodlama_io_dev.business.abstracts.ProgrammingLanguageService;
import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.business.responses.programminglanguage.GetProgrammingLanguageByIdResponse;
import com.eminerarslan.kodlama_io_dev.core.utils.results.DataResult;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;
import com.eminerarslan.kodlama_io_dev.core.utils.results.SuccessDataResult;
import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;
import com.eminerarslan.kodlama_io_dev.exception.programminglanguages.ProgrammingLanguageNotFoundException;
import com.eminerarslan.kodlama_io_dev.mappers.ProgrammingLanguageMapper;
import com.eminerarslan.kodlama_io_dev.repository.abstracts.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    ProgrammingLanguageRepository programmingLanguageRepository;
    ProgrammingLanguageMapper programmingLanguageMapper;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, ProgrammingLanguageMapper programmingLanguageMapper) {
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.programmingLanguageMapper = programmingLanguageMapper;
    }

    //Get programming language by id for service methods
    private ProgrammingLanguage getProgrammingLanguageById(int id) {
        return programmingLanguageRepository.findById(id)
                .orElseThrow(() -> new ProgrammingLanguageNotFoundException(
                        "Programming language not found"
                ));
    }
    //Get programming language by id for service methods end

    @Override
    public Result getAll() {
        return new SuccessDataResult<>(programmingLanguageMapper.toGetAllProgrammingLanguagesResponse(
                programmingLanguageRepository.findAll()
        ));
    }

    @Override
    public DataResult<GetProgrammingLanguageByIdResponse> getById(int id) {
        return new SuccessDataResult<>(programmingLanguageMapper.toGetProgrammingLanguageByIdResponse(
                getProgrammingLanguageById(id)
        ));
    }

    @Override
    public Result create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        return new SuccessDataResult<>(programmingLanguageMapper.toCreateProgrammingLanguageResponse(
                programmingLanguageRepository.save(
                        programmingLanguageMapper.toCreateProgrammingLanguageRequest(
                                createProgrammingLanguageRequest
                        )
                )
        ));
    }

    @Override
    public Result deleteById(int id) {
        ProgrammingLanguage toDelete = getProgrammingLanguageById(id);
        programmingLanguageRepository.deleteById(id);
        return new SuccessDataResult<>(programmingLanguageMapper
                .toDeleteProgrammingLanguageByIdResponse(toDelete), toDelete.getName() + " has been deleted");
    }

    @Override
    public Result updateById(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        ProgrammingLanguage toUpdate = getProgrammingLanguageById(id);
        String oldName = toUpdate.getName();
        ProgrammingLanguage programmingLanguage = programmingLanguageMapper.updateProgrammingLanguage(
                toUpdate, updateProgrammingLanguageRequest
        );
        programmingLanguageRepository.save(programmingLanguage);
        return new SuccessDataResult<>(
                programmingLanguageMapper.toUpdateProgrammingLanguageRequest(programmingLanguage),
                oldName + " updated to " + toUpdate.getName()
        );
    }
}