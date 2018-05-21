package com.zhengpengcoder.java8.lession3;

import com.zhengpengcoder.java8.Project;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by zhengpeng on 2018/5/21.
 * 方法引用
 */
public class MethodReference {

    public static List<Integer> findNumbers(List<Integer> numbers, Predicate<Integer> filter){
        List<Integer> numbersFound = numbers.
                stream().
                filter(filter).
                collect(Collectors.toList());
        return numbersFound;
    }


    public static boolean multitpleOf3(Integer number){
        return (number%3 ==0);
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 6, 8, 9, 12, 14, 15);

        //old
        List<Integer> multitpleOf3 = findNumbers(numbers,num -> num%3 == 0);

        //new
        List<Integer> multitpleOf3new = findNumbers(numbers,MethodReference::multitpleOf3);

        System.out.println(multitpleOf3);

        System.out.println(multitpleOf3new);


        Project project = Project.builder().name("j8").build();


        Arrays.asList(project).stream().map(Project::getName).count();




    }

}
