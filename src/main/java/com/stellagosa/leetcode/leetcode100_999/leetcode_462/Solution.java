package com.stellagosa.leetcode.leetcode100_999.leetcode_462;

import java.util.Random;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/19 12:17
 * @Description:
 */
public class Solution {

    Random random = new Random();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1};
        System.out.println(solution.minMoves2(nums));
    }

    public int minMoves2(int[] nums) {
        int mid = quickSort(nums, 0, nums.length - 1, nums.length / 2);
        int count = 0;
        for (int num : nums) {
            count += Math.abs(num - mid);
        }
        return count;
    }

    public int quickSort(int[] arr, int left, int right, int target) {
        if (left < right) {
            int mid = partition(arr, left, right);
            if (mid == target) return arr[mid];
            if (mid > target) return quickSort(arr, left, mid - 1, target);
            else return quickSort(arr, mid + 1, right, target);
        }
        return arr[left];
    }

    public int partition(int[] arr, int left, int right) {
        int index = random.nextInt(right - left + 1) + left;
        swap(arr, index, right);
        int target = arr[right];
        int pre = left;
        int cur = left;
        while (pre < right) {
            if (arr[pre] < target) {
                swap(arr, cur, pre);
                cur++;
            }
            pre++;
        }
        swap(arr, right, cur);
        return cur;
    }

    public void swap(int[] arr, int a1, int a2) {
        int temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }
}
