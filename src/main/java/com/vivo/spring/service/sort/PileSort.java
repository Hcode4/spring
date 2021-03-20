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

    public static void sort(int []input) {
        for(int index = input.length / 2 - 1; index >= 0; index--) {
            adjust(input, index, input.length);
        }

        for(int i = 0 ; i < input.length; i++) {
            swap(input, 0, input.length - i - 1);
            adjust(input, 0 , input.length - i - 1);
        }
    }

    public static void adjust(int []input, int startIndex, int endIndex) {
        int value = input[startIndex];
        for(int index = startIndex * 2 + 1; index < endIndex; index = index * 2 + 1) {
            if(index + 1 < endIndex && input[index] < input[index + 1]) {
                index++;
            }
            if(value < input[index]) {
                input[startIndex] = input[index];
                startIndex = index;
            } else {
                break;
            }
        }
        input[startIndex] = value;
    }

    public static void swap(int []input, int replaceIndex, int replacedIndex) {
        int valueTemplate = input[replacedIndex];
        input[replacedIndex] = input[replaceIndex];
        input[replaceIndex] = valueTemplate;
    }



}
