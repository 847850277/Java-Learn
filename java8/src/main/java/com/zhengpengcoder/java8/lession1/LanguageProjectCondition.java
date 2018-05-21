package com.zhengpengcoder.java8.lession1;


import com.zhengpengcoder.java8.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 语言过滤
 * Created by zhengpeng on 2018/5/17.
 */
public class LanguageProjectCondition implements ProjectConditionInterface {

    @Getter
    @Setter
    private String language;

    public LanguageProjectCondition(String language) {
        this.language = language;
    }

    @Override
    public boolean test(Project project) {
        if(this.getLanguage().equals(project.getLanguage())){
            return true;
        }
        return false;
    }
}
