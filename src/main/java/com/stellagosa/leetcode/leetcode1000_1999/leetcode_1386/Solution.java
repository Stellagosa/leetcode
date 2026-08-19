package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1386;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 1386.安排电影院座位
 * @date 8/19/2026 8:10 AM Wednesday
 */
public class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            if (seat[1] > 1 && seat[1] < 10) {
                int cur = map.getOrDefault(seat[0], 0);
                map.put(seat[0], cur | (1 << (seat[1] - 2)));
            }
        }

        int res = 2 * (n - map.size());
        for (Integer value : map.values()) {
            if (((value | 0b00001111) == 0b00001111) || ((value | 0b11000011) == 0b11000011) || ((value | 0b11110000) == 0b11110000)) {
                res++;
            }
        }

        return res;
    }


//    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//        Arrays.sort(reservedSeats, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
//        int curRow = 1;
//        int index = 0;
//        int res = 0;
//        while (curRow <= n) {
//            if (index >= reservedSeats.length) {
//                res += 2 * (n - curRow + 1);
//                break;
//            }
//            if (reservedSeats[index][0] > curRow) {
//                res += 2 * (reservedSeats[index][0] - curRow);
//                curRow = reservedSeats[index][0];
//            }
//            boolean[] flag = new boolean[10];
//            while (index < reservedSeats.length && reservedSeats[index][0] == curRow) {
//                flag[reservedSeats[index][1] - 1] = true;
//                index++;
//            }
//
//            if (!flag[1] && !flag[2] && !flag[3] && !flag[4] && !flag[5] && !flag[6] && !flag[7] && !flag[8]) {
//                res += 2;
//            } else if ((!flag[1] && !flag[2] && !flag[3] && !flag[4]) || (!flag[5] && !flag[6] && !flag[7] && !flag[8]) || (!flag[3] && !flag[4] && !flag[5] && !flag[6])) {
//                res++;
//            }
//            curRow++;
//        }
//        return res;
//    }


}
