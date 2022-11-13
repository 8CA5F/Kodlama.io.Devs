package com.eminerarslan.kodlama_io_dev.mappers;

import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.CreateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.UpdateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.business.responses.subtechnology.*;
import com.eminerarslan.kodlama_io_dev.entities.concretes.SubTechnology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper(componentModel = "spring")
@Repository
public interface SubTechnologyMapper {
    List<GetAllSubTechnologyResponse> toGetAllSubTechnologiesResponse(List<SubTechnology> subTechnologies);

    @Mapping(source = "programmingLanguage.id", target = "programmingLanguageId")
    @Mapping(source = "programmingLanguage.name", target = "programmingLanguageName")
    GetSubTechnologyByIdResponse toGetSubTechnologyByIdResponse(SubTechnology subTechnology);

    @Mapping(source = "programmingLanguageId", target = "programmingLanguage.id")
    SubTechnology toCreateSubTechnologyRequest(CreateSubTechnologyRequest createSubTechnologyRequest);

    @Mapping(source = "programmingLanguage.id", target = "programmingLanguageId")
    CreateSubTechnologyResponse toCreateSubTechnologyResponse(SubTechnology subTechnology);

    DeleteSubTechnologyByIdResponse toDeleteSubTechnologyResponse(SubTechnology subTechnology);

    @Mapping(source = "programmingLanguage.id", target = "programmingLanguageId")
    @Mapping(source = "programmingLanguage.name", target = "programmingLanguageName")
    UpdateSubTechnologyResponse toUpdateSubTechnologyRequest(SubTechnology subTechnology);

    SubTechnology updateSubTechnology(
            @MappingTarget SubTechnology subTechnology, UpdateSubTechnologyRequest updateSubTechnologyRequest
    );
}
