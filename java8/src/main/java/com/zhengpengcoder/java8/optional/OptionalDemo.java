package com.zhengpengcoder.java8.optional;

import java.util.Optional;
import java.util.Properties;

/**
 * Created by zhengpeng on 2018/5/31.
 */
public class OptionalDemo {


    //创建optional
    public static void createOptional(){
        //声明一个空的optional
        Optional<Address> optionalAddress = Optional.empty();
        System.out.println(optionalAddress);

        // 根据一个非空值创建optional
        Optional<Address> optionalAddres2 = Optional.of(new Address());
        System.out.println(optionalAddres2);

        //可接受null的optional
        Optional<Address> optionalAddres3 = Optional.ofNullable(new Address());
        System.out.println(optionalAddres3);


    }


    //使用 map 从 Optional 对象中提取和转换值
    public static void map(){
       Optional<Address> optionalAddress = Optional.ofNullable(new Address("达尔文路","88号"));

        Optional<String> street = optionalAddress.map(Address -> Address.getStreet());

        Optional<String> street1 = optionalAddress.map(Address::getStreet);


        System.out.println(street);
        System.out.println(street1);

    }

    //使用 floatMap 链接Optional对象
    public static void floatMap(){

        User user = new User();
        user.setOptAddress(Optional.of(new Address("11","22")));
        Optional<User> userOptional = Optional.of(user);

        Optional<String> stringOptional = userOptional.flatMap(User -> user.getOptAddress()).map(address -> address.getStreet());

        System.out.println(stringOptional);
    }


    //默认行为及解引用 Optional对象
    public static void defaultValue(){
        Optional<Address> addressOptional = Optional.ofNullable(null);
        String street = addressOptional.map(Address -> Address.getStreet()).orElse("lalla");
        System.out.println(street);
    }


    public static String getStreet(Optional<User> user,int minAge){

        return user.filter(user1 -> user1.getAge() > minAge)
                .flatMap(User -> User.getOptAddress())
                .map(address -> address.getStreet())
                .orElse("没有");

    }


    public static Optional<Integer> parseInt(String value){

        try {
            return Optional.ofNullable(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 从配置文件中读取分数
     * @param properties
     * @param name
     * @return
     */
    public static int oldReadPoint(Properties properties,String name){
        String value = properties.getProperty(name);
        if(null != value){

            try {
                int i = Integer.parseInt(value);
                if(i > 0){
                    return i;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
        return 0;

    }

    public int readPoint(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalDemo::parseInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static void main(String[] args) {
//        createOptional();
//        map();
//        floatMap();
//        defaultValue();
        Address address = new Address();
        System.out.println(getStreet(Optional.of(new User("1","2",new Address(),4,Optional.empty())),3));
    }



}
