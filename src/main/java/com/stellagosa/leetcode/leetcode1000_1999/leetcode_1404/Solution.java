package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1404;

/**
 * @author Stellagosa
 * @description 将二进制表示减到 1 的步骤数
 * @date 2026/2/26 9:24 星期四
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numSteps("1101");
    }
    public int numSteps(String s) {
        int n = s.length();
        char[] nums = s.toCharArray();
        int step = 0;
        for (int i = n - 1; i > 0;) {
            if (nums[i] == '0') {
                step++;
                i--;
            } else {
                // 查找从i开始，前面的第一个0的位置
                int index = 0;
                for (int j = i; ; j--) {
                    if (j == -1) {
                        // 查找到头了都是1，没有0
                        // 可以假设 -1位就是0
                        index= j;
                        break;
                    }
                    if (nums[j] == '0') {
                        index = j;
                        break;
                    }
                }
                if (index >= 0) {
                    nums[index] = '1';
                }
                step+=i - index + 1;
                i = index;
            }
        }
        return step;
    }
}
