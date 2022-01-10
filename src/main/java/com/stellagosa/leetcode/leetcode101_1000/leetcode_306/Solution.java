package com.stellagosa.leetcode.leetcode101_1000.leetcode_306;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/10 14:04
 * @Description: 累加数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("123"));
    }

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        // 前两个数[0,i),[i,j)
        if (num.charAt(0) == '0') {
            // 则可以肯定第一个数就是0，再确定第二个数就可以了
            for (int i = 2; i < num.length(); i++) {
                long second = Long.parseLong(num, 1, i, 10);
                if (num.charAt(1) == '0') {
                    // 以0开头的数肯定是0
                    if (second != 0) continue;
                }
                if (check(num, 0, second, i)) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 1; i <= num.length()/2; i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    long first = Long.parseLong(num, 0, i, 10);
                    long second = Long.parseLong(num, i, j, 10);
                    if (num.charAt(i) == '0') {
                        // 以0开头的数肯定是0
                        if (second != 0) continue;
                    }
                    if (check(num, first, second, j)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private boolean check(String num, long first, long second, int index) {
        if (index == num.length()) return true;
        long temp = first + second;
        String target = String.valueOf(temp);
        if (num.startsWith(target, index)) {
            return check(num, second, temp, index + target.length());
        } else {
            return false;
        }
    }
}
