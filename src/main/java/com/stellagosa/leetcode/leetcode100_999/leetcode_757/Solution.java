package com.stellagosa.leetcode.leetcode100_999.leetcode_757;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/22 9:50
 * @Description: 设置交集大小至少为2
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        System.out.println(solution.intersectionSizeTwo(intervals));
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        Set<Integer> set = new HashSet<>();

        for (int i = intervals.length - 1; i >= 0; i--) {
            int begin = intervals[i][0];
            int end = intervals[i][1];

            if (i != intervals.length - 1) {
                if (begin == intervals[i + 1][0]) {
                    continue;
                }
            }

            int count = 0;
            boolean flag = false;
            for (Integer num : set) {
                if (num >= begin && num <= end) {
                    count++;
                }
                if (count == 2) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                for (int j = begin; j <= end; j++) {
                    if (!set.contains(j)) {
                        set.add(j);
                        count++;
                    }
                    if (count == 2) {
                        break;
                    }
                }
            }
        }
        return set.size();
    }


    // public int intersectionSizeTwo(int[][] intervals) {
    //     Arrays.sort(intervals, (o1, o2) -> {
    //         if (o1[0] == o2[0]) {
    //             return o1[1] - o2[1];
    //         }
    //         return o1[0] - o2[0];
    //     });
    //     Set<Integer> set = new HashSet<>();
    //
    //     for (int i = intervals.length - 1; i >= 0; i--) {
    //         int begin = intervals[i][0];
    //         int end = intervals[i][1];
    //         int count = 0;
    //         boolean flag = false;
    //         for (Integer num : set) {
    //             if (num >= begin && num <= end) {
    //                 count++;
    //             }
    //             if (count == 2) {
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //
    //         if (!flag) {
    //             for (int j = begin; j <= end; j++) {
    //                 if (!set.contains(j)) {
    //                     set.add(j);
    //                     count++;
    //                 }
    //                 if (count == 2) {
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return set.size();
    // }

}
