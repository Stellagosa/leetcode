package com.stellagosa.leetcode.leetcode100_999.leetcode_556;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/3 6:18
 * @Description: 下一个更大元素III
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(5454));
    }

    public int nextGreaterElement(int n) {
        if (n >= 1 && n <= 9) return -1;

        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        int index = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) return -1;

        for (int i = len - 1; i > index; i--) {
            if (chars[i] > chars[index]) {
                char temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
                break;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(chars, 0, index + 1);
        for (int i = len - 1; i > index; i--) {
            builder.append(chars[i]);
        }
        long value = Long.parseLong(builder.toString());
        return ((int) value) != value ? -1 : (int) value;
    }
}

// 983765 反向遍历，765是递增的，已经是最大，从右到左查找第一个大于3的数，3和5交换，然后反转763，得985367
