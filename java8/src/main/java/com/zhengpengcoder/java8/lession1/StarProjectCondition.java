package com.zhengpengcoder.java8.lession1;

import com.zhengpengcoder.java8.Project;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhengpeng on 2018/5/17.
 */
public class StarProjectCondition implements ProjectConditionInterface {

    @Setter
    @Getter
    private Integer star;

    public StarProjectCondition(Integer star) {
        this.star = star;
    }

    @Override
    public boolean test(Project project) {
        if(project.getStar() > this.getStar()){
            return true;
        }
        return false;
    }

}
