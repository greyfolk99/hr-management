package com.hrmanagement.service;

import com.hrmanagement.domain.department.Department;
import com.hrmanagement.domain.department.DepartmentInfoForm;
import com.hrmanagement.exception.DataNotFoundException;
import com.hrmanagement.exception.ExceptionClass;
import com.hrmanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private Department findById(Integer id, HttpStatus httpStatus, String message){
        Department department = departmentRepository.findById(id).orElseThrow(()-> new DataNotFoundException(
                ExceptionClass.DEPARTMENT, httpStatus, message
        ));
        if (department.getDeletedDate()!=null) throw new DataNotFoundException(
                ExceptionClass.DEPARTMENT, HttpStatus.NOT_FOUND, "deleted"
        );
        return department;
    }
    public Department create(DepartmentInfoForm form){
        return departmentRepository.save(Department.of(form));
    }

    public Department select(Integer id){
        return findById(id, HttpStatus.NOT_FOUND, "department not found");
    }

    public Department update(Integer id, DepartmentInfoForm form){
        Department department = findById(id, HttpStatus.BAD_REQUEST, "wrong department id");
        department.update(form);
        return department;
    }
    public Department delete(Integer id){
        Department department = findById(id, HttpStatus.BAD_REQUEST, "wrong department id");
        department.delete();
        return department;
    }

    public boolean deepDelete(Integer id){
        departmentRepository.deleteById(id);
        return departmentRepository.findById(id).isEmpty();
    }
}
