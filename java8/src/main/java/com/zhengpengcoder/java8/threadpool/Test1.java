package com.zhengpengcoder.java8.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by zhengpeng on 2019/1/3.
 */
public class Test1 {

    /**
     * 线程池测试工具类
     */

    //线程池
    public static void main(String[] args) throws Exception{
        //old_newThread();

        poolTest1();
    }

    /**
     * 不实用线程次创建线程
     */
    private static void old_newThread() {

        long startTime = System.currentTimeMillis();

        IntStream.range(0,1000000).forEach(i -> {
            final int index = i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+", index="+index);
            }).start();
        });

        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间 非线程池：" + (endTime - startTime) + "ms");
    }

    /**
     * 线程池
     */
    private static void poolTest1() throws Exception{

        long startTime = System.currentTimeMillis();

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //Stream.ra
        IntStream.range(0,1000000).forEach(i -> {

            final int index = i;
            cachedThreadPool.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+", index="+index);
            }));

        });

        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间：线程池" + (endTime - startTime) + "ms");
    }



}
