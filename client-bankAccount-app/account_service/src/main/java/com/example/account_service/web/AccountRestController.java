package com.example.account_service.web;

import com.example.account_service.entities.BankAccount;
import com.example.account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
        return bankAccountRepository.findById(id).get();
    }

}
