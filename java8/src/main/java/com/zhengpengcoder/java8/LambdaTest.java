package com.zhengpengcoder.java8;

import com.zhengpengcoder.java8.lession1.MyThread;
import com.zhengpengcoder.java8.lession1.ProjectConditionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhengpeng on 2018/5/17.
 */
public class LambdaTest {

    public static List<Project> buildData(){
        List<Project> dataList = new ArrayList<>();
        Project p1 = Project.builder().language("java").name("java p1").star(200).build();
        Project p2 = Project.builder().language("java").name("java p2").star(100).build();
        Project p3 = Project.builder().language("java").name("java p3").star(20).build();
        Project p4 = Project.builder().language("python").name("python p1").star(500).build();
        Project p5 = Project.builder().language("ruby").name("ruby p1").star(3000).build();
        Project p6 = Project.builder().language("ruby").name("ruby p1").star(0).build();
        dataList.add(p1);
        dataList.add(p2);
        dataList.add(p3);
        dataList.add(p4);
        dataList.add(p5);
        dataList.add(p6);
        return dataList;
    }

    //old method
    public static List<Project> findProjectByStarAndLanguage(List<Project> data,String language,Integer star){

        List<Project> result = new ArrayList<>();
        for (Project project : data) {
            if(language.equals(project.getLanguage()) && project.getStar() > star){
                result.add(project);
            }
        }
        return result;
    }

    //old method2 面向接口编程
    public static List<Project> findProjectByCondition(List<Project> data, ProjectConditionInterface projectConditionInterface){
        List<Project> result = new ArrayList<>();
        for (Project project : data) {
            if(projectConditionInterface.test(project)){
                result.add(project);
            }
        }
        return result;
    }

    //java8 lambda
    public  static <T> List<T> filter(List<T> data,Predicate<T> predicate){

        List<T> result = new ArrayList<T>();
        for (T o : data) {
            if(predicate.test(o)){
                result.add(o);
            }
        }
        return result;
    }
    

    public static void main(String[] args) {

        //test 查找出java语言大于200 star 的项目

//        List<Project> projects = findProjectByStarAndLanguage(buildData(),"java",100);
//        for (Project project : projects) {
//            System.out.println(project);
//        }

//        LanguageProjectCondition languageProjectCondition = new LanguageProjectCondition("python");
//        List<Project> languageProjectProjects = findProjectByCondition(buildData(),languageProjectCondition);
//        for (Project project : languageProjectProjects) {
//            System.out.println(project);
//        }

//        StarProjectCondition starProjectCondition = new StarProjectCondition(20);
//        List<Project> starProjectConditions = findProjectByCondition(buildData(),starProjectCondition);
//        for (Project project : starProjectConditions) {
//            System.out.println(project);
//        }

        List<Project> filters = filter(buildData(),conditon -> conditon.getStar() >10);
        for (Project project : filters) {
            System.out.println(project);
        }

        Runnable task = () -> System.out.println("hello world");
        Thread thread = new Thread(task);
        thread.run();


        MyThread myThread = new MyThread();
        myThread.run();;



    }
}
