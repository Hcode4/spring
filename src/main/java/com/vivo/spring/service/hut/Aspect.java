package com.vivo.spring.service.hut;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import com.vivo.spring.common.Animal;
import com.vivo.spring.common.Cat;
import com.vivo.spring.service.stream.GroupMap;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/10 9:50
 **/
public class Aspect {

    public static void main(String []args) {
        Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
        cat.eat();

        GroupMap groupMap = ProxyUtil.proxy(new GroupMap(), TimeIntervalAspect.class);
        groupMap.groupMapMethod(100);

        Animal cat2 = ProxyUtil.proxy(new Cat(), AspectApoTest.class);
        cat2.eat();

    }
}
