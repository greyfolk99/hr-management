package com.hrmanagement.repository;


import com.hrmanagement.domain.bankaccount.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
}
