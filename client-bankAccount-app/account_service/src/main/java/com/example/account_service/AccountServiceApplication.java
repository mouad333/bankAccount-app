package com.example.account_service;

import com.example.account_service.entities.BankAccount;
import com.example.account_service.enums.AccountType;
import com.example.account_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner (BankAccountRepository bankAccountRepository) {
        return args -> {
            List<BankAccount> accountList = List.of(
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("MAD")
                            .balance(40000)
                            .createdAt(LocalDate.now())
                            .type(AccountType.SAVING_ACCOUNT)
                            .customerId(Long.valueOf(1))
                            .build(),
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("EUR")
                            .balance(30000)
                            .createdAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(Long.valueOf(2))
                            .build()
            );
            bankAccountRepository.saveAll(accountList);
        };
    }
}
