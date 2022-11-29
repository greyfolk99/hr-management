package com.hrmanagement.service;

import com.hrmanagement.domain.training.Training;
import com.hrmanagement.domain.training.TrainingInfoForm;
import com.hrmanagement.exception.DataNotFoundException;
import com.hrmanagement.exception.ExceptionClass;
import com.hrmanagement.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private Training findById(Integer id, HttpStatus httpStatus, String message){
        Training training = trainingRepository.findById(id).orElseThrow(()-> new DataNotFoundException(
                ExceptionClass.TRAINING, httpStatus, message
        ));
        return training;
    }
    public Training create(Integer departmentId, TrainingInfoForm form){
        return trainingRepository.save(Training.of(departmentId, form));
    }

    public Training select(Integer id){
        return findById(id, HttpStatus.NOT_FOUND, "training not found");
    }

    public Training update(Integer id, TrainingInfoForm form){
        Training training = findById(id, HttpStatus.BAD_REQUEST, "wrong training id");
        training.update(form);
        return training;
    }

    public boolean deepDelete(Integer id){
        trainingRepository.deleteById(id);
        return trainingRepository.findById(id).isEmpty();
    }
}
