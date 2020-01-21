package com.learn.java8.entity;

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
