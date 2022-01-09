package com.stellagosa.leetcode.leetcode_1629;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/9 11:18
 * @Description: 按键持续时间最长的键
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] releaseTimes = {9, 29, 49, 50};
        System.out.println(solution.slowestKey(releaseTimes, "cbcd"));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int pre = 0;
        char ch = '\0';
        int max = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - pre;
            char temp = keysPressed.charAt(i);
            if (time > max || (time == max && temp > ch)) {
                max = time;
                ch = temp;
            }
            pre = releaseTimes[i];
        }
        return ch;
    }

    // public char slowestKey(int[] releaseTimes, String keysPressed) {
    //     int pre = 0;
    //     char ch = '\0';
    //     int max = 0;
    //     for (int i = 0; i < releaseTimes.length; i++) {
    //         if (releaseTimes[i] - pre == max) {
    //             if (keysPressed.charAt(i) > ch) {
    //                 ch = keysPressed.charAt(i);
    //             }
    //         }
    //         if (releaseTimes[i] - pre > max) {
    //             max = releaseTimes[i] - pre;
    //             ch = keysPressed.charAt(i);
    //         }
    //         pre = releaseTimes[i];
    //     }
    //     return ch;
    // }
}
