package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3248;

import java.util.List;

/**
 * @author Stellagosa
 * @description 矩阵中的蛇
 * @date 2024/11/21 16:21 星期四
 */
public class Solution {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int res = 0;
        for (String command : commands) {
            char ch = command.charAt(0);
            if (ch == 'U') {
                res -= n;
            } else if (ch == 'D') {
                res += n;
            } else if (ch == 'L') {
                res--;
            } else {
                res++;
            }
        }
        return res;
    }

    // public int finalPositionOfSnake(int n, List<String> commands) {
    //     int down = 0, right = 0;
    //
    //     for (String command : commands) {
    //         switch (command) {
    //             case "UP": {
    //                 down--;
    //                 break;
    //             }
    //             case "DOWN": {
    //                 down++;
    //                 break;
    //             }
    //             case "RIGHT": {
    //                 right++;
    //                 break;
    //             }
    //             case "LEFT": {
    //                 right--;
    //                 break;
    //             }
    //             default: {
    //                 break;
    //             }
    //         }
    //     }
    //     return (down * n) + right;
    // }

}
