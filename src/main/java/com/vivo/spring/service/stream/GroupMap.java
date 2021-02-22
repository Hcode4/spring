package com.vivo.spring.service.stream;


import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import com.vivo.spring.common.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  * @description
 *  * @author Yuanzhi Hu
 *  * @version v1.0
 *  * @since 2021/1/9 10:39
 *  
 **/
@Slf4j
public class GroupMap {


    public void groupMapMethod(int number) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            User user = new User();
            user.setUserId(((int) (Math.random() * 10)));
            user.setUserName(String.format("%s", (int) (Math.random() * 10)));
            users.add(user);
        }

        Object result = users.stream().collect(Collectors.toMap(User::getUserId, value -> {
            List<String> temp = new ArrayList<>();
            temp.add(value.getUserName() + "-" + value.getUserId());
            return temp;
        }, (newValue, oldValue) -> {
            List<String> temp = new ArrayList<>();
            temp.addAll(newValue);
            temp.addAll(oldValue);
            return temp;
        }, LinkedHashMap::new));
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                result));
    }

    public static void main(String[] args) throws InterruptedException {

        GroupMap groupMap = ProxyUtil.proxy(new GroupMap(), TimeIntervalAspect.class);
        groupMap.groupMapMethod(10);
    }


}












