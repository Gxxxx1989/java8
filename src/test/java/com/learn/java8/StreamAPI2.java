package com.learn.java8;

import com.learn.java8.entity.Employ;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI2 {
    List<Employ> employs = Arrays.asList(
            new Employ("111", 11, 1111.11),
            new Employ("222", 22, 2222.22),
            new Employ("333", 33, 3333.33),
            new Employ("444", 44, 4444.44),
            new Employ("555", 55, 5555.55)
    );


    //中间操作
    //帅选与切片
    @Test
    public void test1() {
        employs.stream().limit(2).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");
        employs.stream().filter((x) -> x.getAge() > 20).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map((s -> s.toUpperCase())).forEach(System.out::println);
        System.out.println("-----------------------------------------------");
        employs.stream().map((employ -> employ.getAge())).forEach(System.out::println);
    }

    public Stream<Character> filterCharacter(String str){
        List<Character> list=new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
