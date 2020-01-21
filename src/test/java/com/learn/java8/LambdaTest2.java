package com.learn.java8;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式基础语法
 * 箭头操作符
 * 左侧：lambda表达式参数列表
 * 右侧：lambda中所需要执行的功能，即lambda体
 */
public class LambdaTest2 {
    @Test
    public void test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        runnable.run();
        System.out.println("-------------------------");
        Runnable runnable1 = () -> {
            System.out.println("hello world1");
        };

        runnable1.run();
    }

    @Test
    public void test1(){
        Consumer<String> consumer=(x)->{
            System.out.println(x+"---------------");
        };
        consumer.accept("啊啊啊啊");
    }

    @Test
    public void test2(){
        Comparator<Integer> comparator=(x,y)->{
            return x.compareTo(y);
        };
        System.out.println(comparator.compare(1,2));

    }

}
