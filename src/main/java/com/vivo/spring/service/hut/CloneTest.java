package com.vivo.spring.service.hut;

import cn.hutool.core.util.ObjectUtil;
import com.vivo.spring.common.Dog;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/10 19:03
 **/
@Slf4j
public class CloneTest {

    public static void main(String []args) {
        Dog dog1 = new Dog("Mike", "0001");
        Dog dog2 = dog1.clone();
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                dog2));
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                dog2));

        Dog dog3= ObjectUtil.cloneByStream(dog1);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                dog3));
    }
}
