package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1356;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Stellagosa
 * @description 根据数字二进制下 1 的数目排序
 * @date 2026/2/25 11:01 星期三
 */
public class Solution {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.comparing(Integer::bitCount).thenComparing(o->o))
                .mapToInt(Integer::intValue).toArray();
    }

//    public int[] sortByBits(int[] arr) {
//        return Arrays.stream(arr).boxed().sorted((o1, o2) -> {
//            if (Integer.bitCount(o1) == Integer.bitCount(o2)) return o1-o2;
//            return Integer.bitCount(o1) - Integer.bitCount(o2);
//        }).mapToInt(Integer::intValue).toArray();
//    }

//    public int[] sortByBits(int[] arr) {
//        return Arrays.stream(arr).boxed().sorted(((o1, o2) -> {
//            if (countOfBits(o1) == countOfBits(o2)) return o1 - o2;
//            return countOfBits(o1) - countOfBits(o2);
//        })).mapToInt(Integer::intValue).toArray();
//    }
//
//    private int countOfBits(int num) {
//        int count = 0;
//        while (num > 0) {
//            if ((num & 1) == 1) count++;
//            num >>= 1;
//        }
//        return count;
//    }

}
