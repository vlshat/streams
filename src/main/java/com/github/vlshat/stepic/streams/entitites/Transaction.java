package com.github.vlshat.stepic.streams.entitites;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class Transaction {

    private String uuid;
    private State state;
    private Long sum;
    private Date created;
}
