package com.vivo.spring.service.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/23 17:46
 **/
@Slf4j
public class Deal_0123 {

    /**
     * @param array 需要寻找最大和的数组
     * @return void
     * @description 寻找数组中最大值
     * @author Yuanzhi Hu
     * @version v1.0
     * @since  2021/1/23 18:06
     **/
    public static void maxValue(int[] array) {

        if (array.length != 0) {
            int totalValue = array[0];
            int maxValue = totalValue;
            for (int i = 1; i < array.length; i++) {
                if (totalValue < 0) {
                    totalValue = array[i];
                } else {
                    totalValue += array[i];
                }
                if(totalValue > maxValue) {
                    maxValue = totalValue;
                }
            }
            log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                    maxValue));
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, -5, 9, 8, 3, -6};
        maxValue(array);
    }

}
