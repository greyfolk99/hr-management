package com.hrmanagement.controller.api;

import com.hrmanagement.domain.training.Training;
import com.hrmanagement.domain.training.TrainingInfoForm;
import com.hrmanagement.repository.CustomRepository;
import com.hrmanagement.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingApiController {

    private final TrainingService trainingService;
    private final CustomRepository customRepository;

    @PostMapping("/")
    public ResponseEntity<?> postOne(@RequestParam Integer departmentId, @RequestBody TrainingInfoForm trainingInfoForm){
        return ResponseEntity.ok(trainingService.create(departmentId, trainingInfoForm));
    }
    @GetMapping("/")
    public ResponseEntity<?> getOne(@RequestParam Integer id){
        return ResponseEntity.ok(trainingService.select(id));
    }
    @PatchMapping("/")
    public ResponseEntity<?> patchOne(@RequestParam Integer id,
                                      @RequestBody TrainingInfoForm trainingInfoForm){
        return ResponseEntity.ok(trainingService.update(id, trainingInfoForm));
    }
    @DeleteMapping("/")
    public ResponseEntity<?> deleteOne(@RequestParam Integer id){
        return ResponseEntity.ok(trainingService.deepDelete(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getALl(@RequestParam String keyword){
        return ResponseEntity.ok(customRepository.searchAll(keyword));
    }
}


