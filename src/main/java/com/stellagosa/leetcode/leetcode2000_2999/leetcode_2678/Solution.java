package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2678;

/**
 * @author Stellagosa
 * @description 老人的数目
 * @date 2023/10/23 22:13 星期一
 */
public class Solution {

    public int countSeniors(String[] details) {
        int result = 0;
        for (String detail : details) {
            if ((detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0') > 60) {
                result++;
            }
        }
        return result;
    }

}
