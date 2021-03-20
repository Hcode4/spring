package com.vivo.spring.service.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author HYZ
 * @Describe 快速排序
 * @Version 1.0
 * @since 2021/2/23 21:11
 **/
@Slf4j
public class FastSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 11, 9, 12, 19, 4};
        sort(a);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Arrays.toString(a)));
    }

    public static void sort(int []input) {
        sort(input, 0, input.length - 1);
    }

    public static void sort(int[] input, int lIndex, int  hIndex) {
        if(lIndex < hIndex) {
            int lIndexTemplate = lIndex;
            int hIndexTemplate = hIndex;
            int valueReplace = input[lIndexTemplate];
            while(lIndexTemplate < hIndexTemplate) {
                while(lIndexTemplate < hIndexTemplate && valueReplace < input[hIndexTemplate]) {
                    hIndexTemplate--;
                }
                if(lIndexTemplate < hIndexTemplate) {
                    input[lIndexTemplate++] = input[hIndexTemplate];
                }
                while(lIndexTemplate < hIndexTemplate && valueReplace > input[lIndexTemplate]) {
                    lIndexTemplate++;
                }
                if(lIndexTemplate < hIndexTemplate) {
                    input[hIndexTemplate--] = input[lIndexTemplate];
                }
            }
            input[lIndexTemplate] = valueReplace;
            sort(input, lIndex, lIndexTemplate - 1);
            sort(input, lIndexTemplate + 1, hIndex);
        }
    }

}
