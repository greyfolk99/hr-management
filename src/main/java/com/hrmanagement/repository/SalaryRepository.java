package com.hrmanagement.repository;

import com.hrmanagement.domain.salary.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}
