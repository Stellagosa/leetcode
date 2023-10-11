package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2512;

import java.util.*;

/**
 * @author Stellagosa
 * @description 奖励最顶尖的k名学生
 * @date 2023/10/11 14:44 星期三
 */
public class Solution {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
                                     String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>(List.of(positive_feedback));
        Set<String> negative = new HashSet<>(List.of(negative_feedback));
        // int[0] point, int[1] id
        Queue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        for (int i = 0; i < report.length; ++i) {
            String[] split = report[i].split(" ");
            int point = 0;
            for (String str : split) {
                if (positive.contains(str)) {
                    point += 3;
                }
                if (negative.contains(str)) {
                    point--;
                }
            }
            if (queue.size() < k) {
                queue.offer(new int[]{point, student_id[i]});
            } else {
                int[] peek = queue.peek();
                if (point > peek[0] || (point == peek[0] && student_id[i] < peek[1])) {
                    queue.poll();
                    queue.offer(new int[]{point, student_id[i]});
                }
            }
        }

        List<Integer> result = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            // result.add(queue.poll()[1]);
            int[] poll = queue.poll();
            System.out.println(poll[0] + " : " + poll[1]);
            result.add(poll[1]);
        }
        Collections.reverse(result);
        return result;
    }

}
