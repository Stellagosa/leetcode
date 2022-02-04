package com.stellagosa.leetcode.leetcode100_999.leetcode_630;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/14 11:44
 * @Description: 课程表Ⅲ
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] courses = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        System.out.println(solution.scheduleCourse(courses));
    }


    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(courses, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int count = 0;

        for (int[] cours : courses) {
            if (count + cours[0] <= cours[1]) {
                queue.add(cours);
                count += cours[0];
            } else {
                int[] peek = queue.peek();
                if (peek != null) {
                    if (cours[0] < peek[0]) {
                        queue.poll();
                        queue.add(cours);
                        count -= peek[0];
                        count += cours[0];
                    }
                }
            }
        }
        return queue.size();
    }

}
