package com.xq.pojo;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SexEnum {

    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue
    private Integer sex;

    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
