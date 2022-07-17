package com.stellagosa.leetcode.leetcode100_999.leetcode_565;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/17 8:00
 * @Description: 数组嵌套
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(solution.arrayNesting(nums));
    }

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        // 可以使用原地标记，不用 visited
        boolean[] visited = new boolean[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            // i 转一圈后还是 i
            while (!visited[i]) {
                visited[i] = true;
                count++;
                i = nums[i];
            }
            max = Math.max(max, count);
            if (max * 2 > n) {
                break;
            }
        }
        return max;
    }

    // public int arrayNesting(int[] nums) {
    //     int n = nums.length;
    //     int max = 0;
    //     boolean[] visited = new boolean[n];
    //     for (int i = 0; i < n; i++) {
    //         if (!visited[i]) {
    //             int len = check(nums, visited, i);
    //             max = Math.max(max, len);
    //             if (max * 2 > n) {
    //                 break;
    //             }
    //         }
    //     }
    //     return max;
    // }
    //
    // private int check(int[] nums, boolean[] visited, int index) {
    //     int count = 0;
    //     int next = nums[index];
    //     count++;
    //     visited[index] = true;
    //     while (!visited[next] && next != index) {
    //         count++;
    //         visited[next] = true;
    //         next = nums[next];
    //     }
    //     return count;
    // }
}
