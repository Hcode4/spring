package com.vivo.spring.common;

import cn.hutool.core.clone.CloneSupport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/10 18:57
 **/
@Setter
@Getter
@ToString
public class Dog extends CloneSupport<Dog> {

    private String dogName;
    private String dogId;

    public Dog(String name, String id) {
        this.dogId = id;
        this.dogName = name;
    }

    public Dog(){};
}
