package com.learn.java8.entity;

import org.springframework.stereotype.Component;

public class FilterEmployByAge implements MyPredicate<Employ> {
    @Override
    public boolean test(Employ employ) {
        return employ.getAge()>=22;
    }
}
