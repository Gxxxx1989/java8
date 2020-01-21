package com.learn.java8;

import com.learn.java8.entity.Employ;
import org.junit.jupiter.api.Test;

import java.io.PipedInputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * 方法引用：若lambda体中有方法已经实现了，我们可以使用方法引用
 * （方法引用是lambda表达式的另外一种表现形式）
 * 三种语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 */
public class MethodTest {

    //对象::实例方法名
    @Test
    public void test() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        PrintStream out = System.out;
        Consumer<String> consumer1 = out::println;
    }

    @Test
    public void test1() {
        Employ employ = new Employ();
        Supplier<String> supplier = () -> employ.getName();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> comparator1 = Integer::compareTo;

    }

    //方法引用
    @Test
    public void test3() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate1 = String::equals;
    }
    //构造器引用

    @Test
    public void test4() {
        Supplier<Employ> supplier = () -> new Employ();
        Employ employ = supplier.get();
        System.out.println(employ);
        Supplier<Employ> supplier1 = Employ::new;
        Employ employ1 = supplier1.get();
        System.out.println(employ1);

    }

    @Test
    public void test5() {
        Function<Integer, Employ> function = (x) -> new Employ(x);

        Function<Integer, Employ> function1 = Employ::new;

        Employ apply = function1.apply(101);
        System.out.println(apply);

    }

    @Test
    public void test6() {
        BiFunction<Integer, String, Employ> biFunction = (x, y) -> new Employ(x, y);

        Employ employ = biFunction.apply(10, "小王");
        System.out.println(employ);

        BiFunction<Integer, String, Employ> biFunction1 = Employ::new;
        Employ employ1 = biFunction1.apply(12, "小李");
        System.out.println(employ1);

    }
}
