package com.zhengpengcoder.java8.lession3;

import com.zhengpengcoder.java8.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhengpeng on 2018/5/21.
 *
 *
 */
public class Lambdas {


    public static List<Project> buildData() {
        List<Project> data = new ArrayList<>();

        data.add(Project.builder().name("Blade").language("java")
                .star(3500).build());

        data.add(Project.builder().name("Tale").language("java")
                .star(2600).build());

        data.add(Project.builder().name("Vue.js").language("js")
                .star(83000).build());

        data.add(Project.builder().name("Flask").language("python")
                .star(10500).build());

        data.add(Project.builder().name("Elves").language("java")
                .star(200).build());

        return data;
    }


    public static List<String> getName(List<Project> lists){
        List<String> result = new ArrayList<>();
        for (Project list : lists) {
            result.add(list.getName());
        }
        return result;
    }

    public static List<String> getNames(List<Project> lists, Predicate<Project> predicate){
        List<String> result = new ArrayList<>();
        for (Project list : lists) {
            if(predicate.test(list)){
                result.add(list.getName());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = getName(buildData());
        //consume 消费
        names.forEach(name -> System.out.println(name));

        List<String> names1 = getNames(buildData(),project -> project.getLanguage().equals("java"));
        System.out.println(names1);



    }



}
