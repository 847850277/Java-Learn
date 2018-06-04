package com.zhengpengcoder.java8.optional;

/**
 * Created by zhengpeng on 2018/5/31.
 */
public class BeforeJ8 {



    //java8 之前判断
    public void saveUser(User user){

       if(null != null){
           if(null != user.getAddress()){

               //save
           }
       }

    }



    public void newSaveUser(User user){
        if(user == null){
            return;
        }

        if(user.getAddress() == null){
            return;
        }

        //save

    }





}
