package com.stellagosa.leetcode.leetcode1_99.leetcode_45;

/**
 * @author Stellagosa
 * @description 跳跃游戏Ⅱ
 * @date 2026/2/25 14:17 星期三
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution solution = new Solution();
        solution.jump(nums);
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int step = 0;
        int maxPos = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }

//    public int jump(int[] nums) {
//        // 贪心
//        int n = nums.length;
//        if (n <= 1) return 0;
//        int step = 0;
//        for (int i = 0; i < n;) {
//            int maxPos = i + nums[i];
//            int index = i;
//            if (i + nums[i] >= n - 1) return step + 1;
//            for (int j = i; j <= i + nums[i]; j++) {
//                if (j + nums[j] > maxPos) {
//                    maxPos = j + nums[j];
//                    index = j;
//                }
//            }
//
//            step++;
//            if (index == i) {
//                i = i + nums[i];
//            } else {
//                i = index;
//            }
//        }
//        return step;
//    }


//    public int jump(int[] nums) {
//        int n = nums.length;
//        // f(n) 表示0到n的最小步数
//        // f(n + 1) = Min{f(n)+1|nums[n]>0, f(n-1)+1|nums[n-1]>1,f(n-2)+1|nums[n-2]>2,...};
//        // f(0)=0
//        // [2,3,1,1,4]
//        int[] temp = new int[n];
//        for (int i = 1; i < n; i++) {
//            int min = i;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] >= i - j) {
//                    min = Math.min(temp[j] + 1, min);
//                }
//            }
//            temp[i] = min;
//        }
//        return temp[n - 1];
//    }

}
