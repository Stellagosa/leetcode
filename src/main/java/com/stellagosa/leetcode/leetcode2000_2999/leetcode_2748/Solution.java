package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2748;

import java.util.*;

/**
 * @author Stellagosa
 * @description 美丽下标对的数目
 * @date 2024/6/21 8:53 星期五
 */
public class Solution {

    private static HashSet[] sets = {
            new HashSet<>(Arrays.asList(2, 4, 6, 8)),
            new HashSet<>(Arrays.asList(3, 6, 9)),
            new HashSet<>(Arrays.asList(4, 8)),
    };

    public int countBeautifulPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (twoNumAreCoprime(firstDigitOfANumber(nums[i]),lastDigitOfANumber(nums[j]))) {
                    result++;
                }
            }
        }
        return result;
    }

    private int firstDigitOfANumber(int num) {
        if (num < 10) return num;
        return firstDigitOfANumber(num / 10);
    }

    private int lastDigitOfANumber(int num) {
        return num % 10;
    }


    /**
     * @param num1 < 10
     * @param num2 < 10
     * @return ture/false
     */
    private boolean twoNumAreCoprime(int num1, int num2) {
        if (num1 > 1 && num1 == num2) return false;
        for (HashSet set : sets) {
            if (set.contains(num1) && set.contains(num2)) return false;
        }
        return true;
    }

}
