package com.learn.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employ {

    private String name;

    private Integer age;

    private Double salary;

    public Employ(Integer age) {
        this.age = age;
    }

    public Employ(Integer age, String name) {
        this.age=age;
        this.name=name;
    }
}
