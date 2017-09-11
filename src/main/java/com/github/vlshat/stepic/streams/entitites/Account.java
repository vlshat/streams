package com.github.vlshat.stepic.streams.entitites;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Account {

    private String number;
    private Long balance;
    private List<Transaction> transactions;
}
