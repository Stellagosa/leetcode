package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2451;

/**
 * @Author: Stellagosa
 * @Date: 2023/5/25 上午 08:25
 * @Description: 差值数组不同的字符串
 */
public class Solution {

    public String oddString(String[] words) {
        int n = words[0].length();
        for (int i = 0; i < n - 1; i++) {
            int numOfVote = 1; // 得票数
            int candidate = words[0].charAt(i + 1) - words[0].charAt(i); // 候选人
            for (int j = 1; j < words.length; j++) {
                int num = words[j].charAt(i + 1) - words[j].charAt(i);
                if (candidate == num) {
                    numOfVote++;
                }
                if (j >= 2) { // 总票数小于2不可能出结果
                    if (numOfVote == 1) { // 说明第一个就是不同的那个
                        return words[0];
                    } else if (numOfVote == j) {
                        // 当前candidate是得票最多，但不是得到所有的票，可以得出投票结果
                        // 不同票的是当前或者上一个
                        // 出现是上一个投票人是当j==2时，第二个投票人是不同的，但前两票得不出结果，推迟到当前第三票了
                        if (candidate == num) return words[j - 1];
                        return words[j];
                    }
                }
            }
        }
        return "";
    }

//    public String oddString(String[] words) {
//        int n = words[0].length();
//        for (int i = 0; i < n - 1; i++) {
//            int numOfVote = 0; // 得票数
//            int candidate = Integer.MAX_VALUE; // 候选人
//            for (int j = 0; j < words.length; j++) {
//                int num = words[j].charAt(i + 1) - words[j].charAt(i);
//                if (candidate == Integer.MAX_VALUE) {
//                    candidate = num;
//                    numOfVote++;
//                } else {
//                    if (candidate == num) {
//                        numOfVote++;
//                    }
//                }
//                if (j >= 2) { // 小于2不可能出结果
//                    if (numOfVote == 1) { // 说明第一个就是不同的那个
//                        return words[0];
//                    } else if (numOfVote == j){
//                        // 当前candidate是得票最多，但不是得到所有的票
//                        // 不同票的是当前或者上一个
//                        if (candidate == num) return words[j-1];
//                        return words[j];
//                    }
//                }
//            }
//        }
//        return "";
//    }
}
