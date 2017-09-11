package com.github.vlshat.stepic.streams.entitites;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Department {
    private String name;
    private String code;
    private List<Employee> employees;
}
