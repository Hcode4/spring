package com.vivo.spring.service.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author HYZ
 * @Describe 堆排序
 * @Version 1.0
 * @since 2021/2/25 22:05
 **/
@Slf4j
public class PileSort {

    public static void main(String[] args) {
        int[] a = new int[]{4,5,1,6,2,7,3,8};
        sort(a);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Arrays.toString(a)));
    }

    public static void sort(int []array) {

        for(int i = array.length / 2 - 1; i >= 0; i--) {
            adjust(array, i, array.length);
        }

        for(int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjust(array, 0, i);
        }

    }

    public static void adjust(int [] array, int startIndex, int length) {

        int valueDeal = array[startIndex];
        for(int i = startIndex * 2 + 1; i < length; i = i * 2 + 1) {
            if(i + 1 < length && array[i] < array[i + 1]) {
                i++;
            }
            if(valueDeal < array[i]) {
                array[startIndex] = array[i];
                startIndex = i;
            } else {
                break;
            }
        }
        array[startIndex] = valueDeal;
    }

    public static void swap(int[]array, int swapIndex, int replaceIndex) {
        int temp = array[swapIndex];
        array[swapIndex] = array[replaceIndex];
        array[replaceIndex] = temp;
    }
}
