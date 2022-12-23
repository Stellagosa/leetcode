package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2011;

/**
 * @Author: Stellagosa
 * @Date: 2022/12/23 13:14
 * @Description: 执行操作后的变量值
 */
public class Solution {

    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        Solution solution = new Solution();
        System.out.println(solution.finalValueAfterOperations(operations));
    }

    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }
}
