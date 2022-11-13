package com.eminerarslan.kodlama_io_dev.mappers;

import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.business.responses.programminglanguage.*;
import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper(componentModel = "spring")
@Repository
public interface ProgrammingLanguageMapper {
    List<GetAllProgrammingLanguageResponse> toGetAllProgrammingLanguagesResponse(List<ProgrammingLanguage> programmingLanguageList);

    GetProgrammingLanguageByIdResponse toGetProgrammingLanguageByIdResponse(ProgrammingLanguage programmingLanguage);

    DeleteProgrammingLanguageByIdResponse toDeleteProgrammingLanguageByIdResponse(ProgrammingLanguage programmingLanguage);

    ProgrammingLanguage toCreateProgrammingLanguageRequest(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

    CreateProgrammingLanguageResponse toCreateProgrammingLanguageResponse(ProgrammingLanguage programmingLanguage);

    UpdateProgrammingLanguageResponse toUpdateProgrammingLanguageRequest(ProgrammingLanguage programmingLanguage);

    ProgrammingLanguage updateProgrammingLanguage(
            @MappingTarget ProgrammingLanguage programmingLanguage,
            UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest
    );
}
