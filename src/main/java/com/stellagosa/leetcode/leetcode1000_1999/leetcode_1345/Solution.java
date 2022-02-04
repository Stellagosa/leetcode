package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1345;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/21 11:48
 * @Description: 跳跃游戏Ⅳ
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,13};
        System.out.println(solution.minJumps(arr));
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>(); // 通过值找位置
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == null) {
                List<Integer> list = new LinkedList<>();
                map.put(arr[i], list);
            }
            map.get(arr[i]).add(i);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == n - 1) return step;
                // 相邻
                if (poll + 1 < n && !visited.contains(poll + 1)) {
                    visited.add(poll + 1);
                    queue.offer(poll + 1);
                }
                if (poll - 1 >= 0 && !visited.contains(poll - 1)) {
                    visited.add(poll - 1);
                    queue.offer(poll - 1);
                }
                // 值相同
                List<Integer> list = map.get(arr[poll]);
                if (list != null) {
                    for (Integer index : list) {
                        if (!visited.contains(index)) {
                            visited.add(index);
                            queue.offer(index);
                        }
                    }
                    map.remove(arr[poll]);
                }
            }
            step++;
        }
        return n - 1;
    }
}
