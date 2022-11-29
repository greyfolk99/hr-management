package com.hrmanagement.objectmapper;

import com.hrmanagement.domain.department.Department;
import com.hrmanagement.domain.department.DepartmentResponseDto;
import com.hrmanagement.domain.training.Training;
import com.hrmanagement.domain.training.TrainingResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TrainingObjectMapper {
    TrainingObjectMapper INSTANCE = Mappers.getMapper(TrainingObjectMapper.class);
    TrainingResponseDto toResponse(Training training);
}
