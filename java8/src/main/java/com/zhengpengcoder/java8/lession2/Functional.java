package com.zhengpengcoder.java8.lession2;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by zhengpeng on 2018/5/21.
 * 函数式接口测试累
 */
public class Functional {


    //Predicat 断言测试
    public static void predicate(){

        Predicate<String> nameStartWithS = name -> name.startsWith("s");
        boolean result = nameStartWithS.test("ssssss");
        boolean result1 = nameStartWithS.test("aaaa");
        System.out.println(result);
        System.out.println(result1);

    }

    /**
     * 消费数据
     */
    public static void consume(){
        Consumer<String> messageConsume = message -> System.out.println(message);
        messageConsume.accept("hello java 8");
    }


    /**
     * 类型转换
     */
    public static void function(){
        Function<String,String> toUpperCase = name -> name.toUpperCase();
        String name = "name";
        name = toUpperCase.apply(name);
        System.out.println(name);
    }


    public static void supplier(){
        Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
        System.out.println(uuidGenerator.get());

    }




    public static void main(String[] args) {
//        predicate();
//        consume();
//        function();
        supplier();
    }
}
