package com.learn.java8;

import com.learn.java8.entity.MyPredicate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * java8四大核心接口
 * Consumer<T> 消费型接口
 * void accept(T t);
 * Supplier<T> 供给型接口
 * T get();
 * Function<T,R> 函数型接口
 * R apply(T t);
 * Predicate<T> 断言型接口
 * boolean test(T t);
 */
public class LambdaTest3 {
    @Test
    public void test() {
        happy(10000, (x) -> {
            System.out.println(x);
        });
    }

    //消费型接口
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<Integer> list = generateNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(list);
    }

    //供给型接口
    public List<Integer> generateNumList(int n, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void test3() {
        String s = doString("123", (x) -> x.concat("asdsda"));
        System.out.println(s);
    }

    //函数型接口
    public String doString(String srt, Function<String, String> function) {
        return function.apply(srt);
    }

    //断言型接口
    @Test
    public void test4() {
        List<String> list = Arrays.asList("aaa", "bbbb", "cccc", "dddd", "eee");
        List<String> list1 = strHandler(list, m -> m.length() > 3);
        System.out.println(list1);
    }

    public List<String> strHandler(List<String> str, MyPredicate<String> myPredicate) {
        List<String> list = new ArrayList<>();
        for (String s : str) {
            if (myPredicate.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

}
