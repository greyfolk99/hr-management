package com.hrmanagement.objectmapper;

import com.hrmanagement.domain.department.Department;
import com.hrmanagement.domain.department.DepartmentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentObjectMapper {
    DepartmentObjectMapper INSTANCE = Mappers.getMapper(DepartmentObjectMapper.class);
    DepartmentResponseDto toResponse(Department department);
}
