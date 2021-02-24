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

    public static void sort(int[] array, int lIndex, int hIndex) {
        if(lIndex < hIndex) {
            int mid = (lIndex + hIndex) / 2;
            // 低位排序
            sort(array, lIndex, mid);
            // 高位排序
            sort(array, mid + 1, hIndex);
            // 合并双方
            merge(array, lIndex, mid, hIndex);
        }
    }

    /**
     * @param array 需要合并到数据
     * @param lIndex 低位指针
     * @param mid 中间分界线
     * @param hIndex 高位指针
     * @return void
     * @description 合并双数组
     * @author Yuanzhi Hu
     * @version v1.0
     * @since  2021/2/24 23:04
     **/
    public static void merge(int[] array, int lIndex, int mid, int hIndex) {
        int []temp = new int[hIndex - lIndex + 1];
        int i = 0;
        int lIndexScan = lIndex;
        int hIndexScan = mid + 1;

        while(lIndexScan <= mid && hIndexScan <= hIndex) {
            temp[i++] = array[lIndexScan] < array[hIndexScan] ? array[lIndexScan++] : array[hIndexScan++];
        }
        while (lIndexScan <= mid) {
            temp[i++] = array[lIndexScan++];
        }
        while (hIndexScan <= hIndex) {
            temp[i++] = array[hIndexScan++];
        }
        for(i = 0; i < temp.length; i++) {
            array[lIndex + i] = temp[i];
        }
    }
}
