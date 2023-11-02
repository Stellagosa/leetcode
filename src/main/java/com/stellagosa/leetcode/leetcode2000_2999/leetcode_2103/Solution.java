package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2103;

/**
 * @author Stellagosa
 * @description 环和杆
 * @date 2023/11/2 10:34 星期四
 */
public class Solution {

    public int countPoints(String rings) {
        int[] states = new int[10];
        char[] array = rings.toCharArray();
        for (int i = 0; i < array.length; i += 2) {
            char color = array[i];
            int index = array[i + 1] - '0';
            if (color == 'R') {
                states[index] |= 1;
            } else if (color == 'G') {
                states[index] |= 2;
            } else if (color == 'B') {
                states[index] |= 4;
            }
        }

        int count = 0;
        for (int state : states) {
            count += state == 7 ? 1 : 0;
        }
        return count;
    }

    // public int countPoints(String rings) {
    //     boolean[][] flags = new boolean[10][3];
    //     char[] array = rings.toCharArray();
    //     for (int i = 0; i < array.length; i += 2) {
    //         char color = array[i];
    //         int index = array[i + 1] - '0';
    //         if (color == 'R') {
    //             flags[index][0] = true;
    //         } else if (color == 'G') {
    //             flags[index][1] = true;
    //         } else if (color == 'B') {
    //             flags[index][2] = true;
    //         }
    //     }
    //     int count = 0;
    //     for (boolean[] flag : flags) {
    //         count += (flag[0] && flag[1] && flag[2]) ? 1 : 0;
    //     }
    //     return count;
    // }

}
