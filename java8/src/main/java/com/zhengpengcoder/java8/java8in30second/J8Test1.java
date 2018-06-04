package com.zhengpengcoder.java8.java8in30second;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by zhengpeng on 2018/5/21.
 */
public class J8Test1 {


    /**
     * 计算数组中某个数字出现的次数
     */

    public static long countOcurrences(int[] arrys,int num){
        //old

//        long count = 0l;
//        for(int i =  0;i<arrys.length;i++){
//            if(arrys[i] == num){
//                count ++;
//            }
//        }
//        return count;


        //java8
        return Arrays.stream(arrys).filter(number -> number == num).count();


    }


    /**
     * 求平均数
     * @param arrays
     * @return
     */
    public static  double avgNum(int[] arrays){
        //old
//        int sum = 0;
//        for(int i = 0;i<arrays.length;i++){
//            sum = sum + arrays[i];
//        }
//        return sum/arrays.length;

        //java8
        return  IntStream.of(arrays).average().orElseThrow(() -> new IllegalArgumentException("Array is empty"));

    }


    public static void main(String[] args) {

        int[] arrars = {1,2,3,4,5,6,7,3,4,5,2222,34,54,65,3,76,2342};
        //System.out.println(countOcurrences(arrars,3));
        System.out.println(avgNum(arrars));
    }
}
