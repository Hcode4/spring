package com.vivo.spring.common;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/10 9:49
 **/
@Slf4j
public class Cat implements Animal, Cloneable<Cat> {
    @Override
    public void eat() {
        log.info(String.format("方法：%s 第：%s, 其他信息：%s", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(),
                "Cat eat"));
    }

    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            log.info(String.format("方法：%s 第：%s, 错误信息：", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber()), e);
            throw new CloneRuntimeException(e);
        }
    }
}
