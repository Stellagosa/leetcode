package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1189;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/14 21:08
 * @Description: “气球“的最大数量
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon"));
    }

    // balloon
    public int maxNumberOfBalloons(String text) {
        int bCount = 0;
        int aCount = 0;
        int lCount = 0;
        int oCount = 0;
        int nCount = 0;

        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'a':
                    aCount++;
                    break;
                case 'b':
                    bCount++;
                    break;
                case 'l':
                    lCount++;
                    break;
                case 'o':
                    oCount++;
                    break;
                case 'n':
                    nCount++;
                    break;
            }
        }
        return Math.min(aCount, Math.min(bCount, Math.min(lCount / 2, Math.min(oCount / 2, nCount))));
    }
}
