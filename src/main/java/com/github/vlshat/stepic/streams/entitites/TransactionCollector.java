package com.github.vlshat.stepic.streams.entitites;

import lombok.Data;

import java.util.UUID;

@Data
public class TransactionCollector {
    private String uuid;
    private Long sum;
    private AccountCollector account;

    public TransactionCollector(Long sum, AccountCollector account) {
        this.uuid = UUID.randomUUID().toString();
        this.sum = sum;
        this.account = account;
    }
}
