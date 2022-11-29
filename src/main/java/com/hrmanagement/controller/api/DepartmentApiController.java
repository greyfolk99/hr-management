package com.hrmanagement.controller.api;

import com.hrmanagement.domain.department.DepartmentInfoForm;
import com.hrmanagement.repository.CustomRepository;
import com.hrmanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentApiController {

    private final DepartmentService departmentService;
    private final CustomRepository customRepository;

    @PostMapping("/")
    public ResponseEntity<?> postOne(@RequestBody DepartmentInfoForm departmentInfoForm){
        return ResponseEntity.ok(departmentService.create(departmentInfoForm));
    }
    @GetMapping("/")
    public ResponseEntity<?> getOne(@RequestParam Integer id){
        return ResponseEntity.ok(departmentService.select(id));
    }
    @PatchMapping("/")
    public ResponseEntity<?> patchOne(@RequestParam Integer id,
                                      @RequestBody DepartmentInfoForm departmentInfoForm){
        return ResponseEntity.ok(departmentService.update(id, departmentInfoForm));
    }
    @DeleteMapping("/")
    public ResponseEntity<?> deleteOne(@RequestParam Integer id){
        return ResponseEntity.ok(departmentService.delete(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getALl(@RequestParam String keyword){
        return ResponseEntity.ok(customRepository.searchAll(keyword));
    }
}


