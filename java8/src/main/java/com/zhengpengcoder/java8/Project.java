package com.zhengpengcoder.java8;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by zhengpeng on 2018/5/17.
 */

@Builder
@ToString
public class Project {

    @Getter@Setter
    private String name;
    @Getter@Setter
    private Integer star;
    @Getter@Setter
    private String language;


}
