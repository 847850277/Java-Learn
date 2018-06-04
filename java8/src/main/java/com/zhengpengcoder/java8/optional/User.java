package com.zhengpengcoder.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Created by zhengpeng on 2018/5/31.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {


    private String username;
    private String password;
    private Address address;
    private Integer age;


    private Optional<Address> optAddress;


}
