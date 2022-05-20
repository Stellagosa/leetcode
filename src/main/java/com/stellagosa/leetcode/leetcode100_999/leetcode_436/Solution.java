package com.stellagosa.leetcode.leetcode100_999.leetcode_436;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/20 7:35
 * @Description: 寻找右区间
 */
public class Solution {

    Random random = new Random();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 2}};
        Arrays.stream(solution.findRightInterval(intervals)).forEach(System.out::println);
    }

    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        quickSort(intervals, 0, intervals.length - 1);

        int[] res = new int[intervals.length];
        for (int[] interval : intervals) {
            res[map.get(interval[0])] = search(intervals, interval[1], map);
        }
        return res;
    }


    private int search(int[][] arr, int target, Map<Integer, Integer> map) {
        if (target > arr[arr.length - 1][0]) return -1;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid][0] == target) {
                return map.get(arr[mid][0]);
            } else if (arr[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return map.get(arr[left][0]);
    }

    private void quickSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = partitify(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    private int partitify(int[][] arr, int left, int right) {
        int index = random.nextInt(right - left + 1) + left;
        swap(arr, index, right);
        int cur = left, pre = left;
        while (pre < right) {
            if (arr[pre][0] < arr[right][0]) {
                swap(arr, pre, cur);
                cur++;
            }
            pre++;
        }
        swap(arr, cur, right);
        return cur;
    }

    private void swap(int[][] arr, int a1, int a2) {
        int[] temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }
}
