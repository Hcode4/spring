package com.vivo.spring.service.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/2/25 22:28
 **/
@Slf4j
public class HillSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 11, 9, 12, 19, 4, 5, 30, 43,10};
        sort(a);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Arrays.toString(a)));
    }

    public static void sort(int[] array) {
        int step = array.length / 2;

        while(step >= 1) {
            for(int i = step; i < array.length; i++) {
                for(int j = i; j >= step; j -= step) {
                    if(array[j] < array[j - step]) {
                        swap(array, j, j - step);
                    } else {
                        break;
                    }
                }
            }
            step /= 2;
        }
    }


    public static void swap(int[]array, int swapIndex, int replaceIndex) {
        int temp = array[swapIndex];
        array[swapIndex] = array[replaceIndex];
        array[replaceIndex] = temp;
    }
}
