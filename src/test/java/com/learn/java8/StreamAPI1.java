package com.learn.java8;

import com.learn.java8.entity.Employ;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1创建流
 * 2中间操作
 * 3终止操作
 */
public class StreamAPI1 {
    @Test
    public void test() {
        //1.通过collection系列集合提供的stream()获取串行流, 或parallelStream()获取并行流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //2.通过Arrays中的静态方法stream()获取数组流
        Employ[] employs = new Employ[10];
        Stream<Employ> stream1 = Arrays.stream(employs);
        //3.通过Stream类中静态方法of()方法创建流
        Stream<Employ> employStream = Stream.of(new Employ());
        //4.创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(5).forEach(System.out::println);
        //生产
        Stream.generate(()->Math.random()).limit(6).forEach(System.out::println);


    }

}
