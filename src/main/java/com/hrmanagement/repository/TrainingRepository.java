package com.hrmanagement.repository;

import com.hrmanagement.domain.training.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
}
