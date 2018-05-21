package com.zhengpengcoder.java8.lession3;

import java.util.function.Function;

/**
 * Created by zhengpeng on 2018/5/21.
 * 数组引用
 */
public class OtherReference {


    public static void main(String[] args) {

        //转换 入参Intger  返回 String[]
        Function<Integer,String[]> fun = x -> new String[x];

        String[] strs = fun.apply(10);
        System.out.println(strs.length);


        Function<Integer,String[]> funNew =  String[]::new;


        strs = funNew.apply(20);

        System.out.println(strs.length);





    }
}
