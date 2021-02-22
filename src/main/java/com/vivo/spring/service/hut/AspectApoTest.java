package com.vivo.spring.service.hut;

import cn.hutool.aop.aspects.SimpleAspect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/10 10:05
 **/
@Slf4j
public class AspectApoTest extends SimpleAspect {

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                "Start"));
        return true;
    }
}
