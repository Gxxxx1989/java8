package com.learn.java8;

import com.learn.java8.entity.Employ;
import com.learn.java8.entity.FilterEmployByAge;
import com.learn.java8.entity.MyPredicate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    List<Employ> employs = Arrays.asList(
            new Employ("111", 11, 1111.11),
            new Employ("222", 22, 2222.22),
            new Employ("333", 33, 3333.33),
            new Employ("444", 44, 4444.44),
            new Employ("555", 55, 5555.55)
    );

    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = Integer::compareTo;
    }

    @Test
    public void test4() {
        List<Employ> employs1 = filterEmploy(employs);
        for (Employ employ : employs1) {
            System.out.println(employ);
        }
    }

    public List<Employ> filterEmploy(List<Employ> list) {
        List<Employ> employs = new ArrayList<>();
        for (Employ employ : list) {
            if (employ.getAge() >= 22) {
                employs.add(employ);
            }

        }
        return employs;
    }
    //策略模式
    @Test
    public void test5() {
        List<Employ> employs1 = filterEmploy(employs, new FilterEmployByAge());
        for (Employ employ : employs1) {
            System.out.println(employ);
        }
    }

    public List<Employ> filterEmploy(List<Employ> list, MyPredicate<Employ> mp) {
        List<Employ> employs = new ArrayList<>();
        for (Employ employ : list) {
            if (mp.test(employ)) {
                employs.add(employ);
            }
        }
        return employs;
    }

    //匿名内部类
    @Test
    public void test6() {

        List<Employ> employs1 = filterEmploy(employs, new MyPredicate<Employ>() {
            @Override
            public boolean test(Employ employ) {
                return employ.getAge() >= 20;
            }
        });

        for (Employ employ : employs1) {
            System.out.println(employ);
        }
    }

    //lambda表达式
    public void test7(){
        List<Employ> employs1 = filterEmploy(employs, e-> e.getAge()>=20);
        employs1.forEach(System.out::println);
    }

    //stream API
    @Test
    public void test8(){
        employs.stream().filter(employ -> employ.getAge()>30).limit(1).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        employs.stream().map(Employ::getName).forEach(System.out::println);
    }
}

