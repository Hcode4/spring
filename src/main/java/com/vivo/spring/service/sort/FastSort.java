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

    public static void sort(int[] arrays) {
        paratition(arrays, 0, arrays.length - 1);
    }

    public static void paratition(int[] a, int lIndex, int hIndex) {
        if (lIndex < hIndex) {
            int i = lIndex;
            int j = hIndex;
            int value = a[lIndex];
            while (i < j) {
                // 找到比自己小元素
                while (i < j && value < a[j]) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                // 找到比自己大元素
                while (i < j && value > a[i]) {
                    i++;
                }
                // 找到比自己大元素置换
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            // 将元素放在最终位置
            a[i] = value;
            paratition(a, lIndex, i - 1);
            paratition(a, i + 1, hIndex);
        }
    }
}
