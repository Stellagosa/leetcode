package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1358;

/**
 * @author Stellagosa
 * @description 包含所有三种字符的子字符串数目
 * @date 6/30/2026 8:18 AM Tuesday
 */
public class Solution {

    /*
     * 用index_a、index_b、index_c三个指针记录上一个a、b、c的位置
     * 此时遍历指针移动到i处，更新i位置字符的指针
     * 令 min={index_a,index_b,index_c}
     * 那么[min,i]的这个数组就是满足条件的以i结尾的最短子数组，而这个数目是min+1
     */
    public int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[3];
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt[chars[i] - 'a'] = i + 1;
            res += Math.min(cnt[0], Math.min(cnt[1], cnt[2]));
        }
        return res;
    }

    /*
     * l=r=0
     * 将r位置的字母加入统计中，判断cnt是否满足条件
     * 1. 满足条件，将此时l起始满足条件的子数组数目加入结果中，即 res+=n-r
     * 1.1 将l位置的移除统计，l向右移动一步，回到上一步
     * 2.不满足条件，继续向右移动r
     */
    // public int numberOfSubstrings(String s) {
    //     char[] chars = s.toCharArray();
    //     int n = chars.length;
    //     int res = 0;
    //     int[] cnt = new int[3];
    //     int l = 0, r = 0;
    //     while (l + 3 <= n && r < n) {
    //         cnt[chars[r] - 'a']++;
    //         while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
    //             res += n - r;
    //             cnt[chars[l] - 'a']--;
    //             l++;
    //         }
    //         r++;
    //     }
    //     return res;
    // }
}
