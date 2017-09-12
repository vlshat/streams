package com.github.vlshat.stepic.streams.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountCollector {
    private String number;
    private Long balance;
}
