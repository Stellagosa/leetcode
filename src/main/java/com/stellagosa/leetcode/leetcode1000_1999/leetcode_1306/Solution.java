package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1306;

/**
 * @author Stellagosa
 * @description 跳跃游戏Ⅲ
 * @date 5/17/2026 2:26 PM Sunday
 */
public class Solution {

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        int n = arr.length;
        boolean[] flags = new boolean[n];
        return dfs(arr, flags, start, n);
    }

    private boolean dfs(int[] arr, boolean[] flags, int cur, int n) {
        if (cur < 0 || cur >= n) return false;
        if (flags[cur]) return false;
        if (arr[cur] == 0) return true;
        flags[cur] = true;
        return dfs(arr,flags,cur+arr[cur],n) || dfs(arr,flags,cur-arr[cur],n);
    }


//    public boolean canReach(int[] arr, int start) {
//        if (arr[start] == 0) return true;
//        int n = arr.length;
//        Deque<Integer> deque = new ArrayDeque<>();
//        boolean[] flags = new boolean[n];
//        flags[start] = true;
//        deque.offer(start);
//        while (!deque.isEmpty()) {
//            int len = deque.size();
//            for (int i = 0; i < len; i++) {
//                int index = deque.pop();
//                if (index + arr[index] >=0 && index + arr[index] < n && !flags[index + arr[index]]) {
//                    if (arr[index + arr[index]] == 0) return true;
//                    deque.offer(index + arr[index]);
//                    flags[index + arr[index]] = true;
//                }
//                if (index - arr[index] >=0 && index - arr[index] < n && !flags[index - arr[index]]) {
//                    if (arr[index - arr[index]] == 0) return true;
//                    deque.offer(index - arr[index]);
//                    flags[index - arr[index]] = true;
//                }
//            }
//        }
//        return false;
//    }

}
