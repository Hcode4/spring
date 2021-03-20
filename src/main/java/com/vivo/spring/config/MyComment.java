package com.vivo.spring.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/3/13 8:23
 **/
public class MyComment {

    public static void main(String[] args) {
        MyComment comment = new MyComment();
        int[] a = new int[]{1, 11, 9, 12, 19, 4};

        List<Integer> result = comment.GetLeastNumbers_Solution(a, 4);
        System.out.println(result.toString());
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        pileSort(input, k, result);
        return result;
    }

    public void pileSort(int []input, int k,  ArrayList<Integer>result) {
        for(int i = input.length / 2 - 1; i >= 0; i--) {
            adjust(input, i, input.length);
        }
        for(int i = 0; i < k; i++) {
            result.add(input[0]);
            swap(input, 0, input.length - i - 1);
            adjust(input, 0, input.length - i - 1);
        }
    }

    public void adjust(int []input, int startIndex, int endIndex) {
        int value = input[startIndex];
        for(int i = startIndex * 2 + 1; i < endIndex; i = i * 2 + 1) {
            if(i < endIndex && input[i] > input[i + 1]) {
                i++;
            }
            if(value > input[i]) {
                input[startIndex] = input[i];
                startIndex = i;
            } else {
                break;
            }
        }
        input[startIndex] = value;
    }

    public void swap(int []input, int replaceIndex, int replacedIndex) {
        int valueTemplate = input[replacedIndex];
        input[replacedIndex] = input[replaceIndex];
        input[replaceIndex] = valueTemplate;
    }
}
