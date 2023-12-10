package com.example.account_service.entities;

import com.example.account_service.enums.AccountType;
import com.example.account_service.model.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
