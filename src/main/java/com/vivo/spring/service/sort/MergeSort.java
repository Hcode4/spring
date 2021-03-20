package com.vivo.spring.service.sort;

import lombok.extern.slf4j.Slf4j;

import javax.management.StandardEmitterMBean;
import java.util.Arrays;

/**
 * @Author HYZ
 * @Describe 归并排序
 * @Version 1.0
 * @since 2021/2/24 22:39
 **/
@Slf4j
public class MergeSort {

    public static void main(String[] args) {
        int [] array = new int[]{1, 19, 10, 7, 12, 20};
        sort(array, 0, array.length - 1);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Arrays.toString(array)));
    }

    public static void sort(int[] input, int lIndex, int hIndex) {

        if(lIndex < hIndex) {
            int mid = ( lIndex + hIndex ) / 2;
            sort(input, lIndex, mid);
            sort(input, mid + 1, hIndex);
            merge(input, lIndex, mid, hIndex);
        }
    }

    public static void merge(int[] input, int lIndex, int mid, int hIndex) {
        int[]valueMerge = new int[hIndex - lIndex + 1];
        int index = 0;
        int iIndex = lIndex;
        int jIndex = mid + 1;
        while(iIndex <= mid && jIndex <= hIndex) {
            valueMerge[index++] = input[iIndex] < input[jIndex] ? input[iIndex++] : input[jIndex++];
        }
        while(iIndex <= mid) {
            valueMerge[index++] = input[iIndex++];
        }
        while(jIndex <= hIndex) {
            valueMerge[index++] = input[jIndex++];
        }
        for(int i = 0; i < valueMerge.length; i++) {
            input[i + lIndex] = valueMerge[i];
        }

    }



}
