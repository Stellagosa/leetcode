package com.stellagosa.leetcode.leetcode101_1000.leetcode_179;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:46
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10, 2, 3};
        String number = solution.largestNumber(nums);
        System.out.println(number);
    }

    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }

    //10 2 3
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int left = start, right = end, temp = arr[start];
            while (left < right) {
                while (left < right && !compareStr(arr[right], temp))
                    right--;
                if (left < right)
                    arr[left++] = arr[right];
                while (left < right && !compareStr(temp, arr[left]))
                    left++;
                if (left < right)
                    arr[right--] = arr[left];
            }
            arr[left] = temp;
            quickSort(arr, start, left - 1);
            quickSort(arr, left + 1, end);
        }
    }

    public boolean compareStr(int x, int y) {
        String strx = String.valueOf(x);
        String stry = String.valueOf(y);
        int res = (strx + stry).compareTo(stry + strx);
        return res > 0;
    }

    public boolean compare(int x, int y) {
        StringBuilder builderx = new StringBuilder();
        StringBuilder buildery = new StringBuilder();
        builderx.append(x).append(y);
        buildery.append(y).append(x);

        boolean b = false;

        for (int i = 0; i < builderx.length(); i++) {
            char chx = builderx.charAt(i);
            char chy = buildery.charAt(i);
            if (chx > chy) {
                b = true;
                break;
            }
            if (chx < chy) {
                break;
            }
        }
        return b;
    }
}

