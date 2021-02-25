package com.vivo.spring.service.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/2/25 22:35
 **/
@Slf4j
public class ChooseSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 11, 9, 12, 19, 4};
        sort(a);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Arrays.toString(a)));
    }

    public static void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int indexMin = i;
            for(int j = i; j < array.length; j++) {
                if(array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            swap(array, i, indexMin);
        }
    }

    public static void swap(int[]array, int swapIndex, int replaceIndex) {
        int temp = array[swapIndex];
        array[swapIndex] = array[replaceIndex];
        array[replaceIndex] = temp;
    }

}
