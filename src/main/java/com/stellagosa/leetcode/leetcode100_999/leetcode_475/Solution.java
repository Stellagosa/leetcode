package com.stellagosa.leetcode.leetcode100_999.leetcode_475;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/20 10:18
 * @Description: 供暖器
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] houses = new int[]{1, 2, 3, 4};
        int[] heaters = new int[]{2};
        System.out.println(solution.findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int index = 0;
        int radius = 0;
        for (int house : houses) {
            while (index < heaters.length && heaters[index] < house) {
                index++;
            }
            int latest;
            // 最后一个供暖器
            if (index == heaters.length) {
                latest = house - heaters[index - 1];
            } else {
                // 第一个供暖器
                if (index == 0) {
                    latest = heaters[0] - house;
                } else {
                    // 中间供暖器，查找离的最近的供暖器
                    latest = Math.min(heaters[index] - house, house - heaters[index - 1]);
                }
            }
            radius = Math.max(radius, latest);
        }

        return radius;
    }

    // public int findRadius(int[] houses, int[] heaters) {
    //     Arrays.sort(heaters);
    //     int max = 0;
    //     for (int house : houses) {
    //         int latest = findLatest(heaters, house);
    //         max = Math.max(latest, max);
    //     }
    //     return max;
    // }
    //
    // private int findLatest(int[] heaters, int target) {
    //     if (target <= heaters[0]) {
    //         return heaters[0] - target;
    //     }
    //     if (target >= heaters[heaters.length - 1]) {
    //         return target - heaters[heaters.length - 1];
    //     }
    //     int left = 0, right = heaters.length - 1;
    //     while (left < right) {
    //         int mid = left + (right - left + 1) / 2;
    //         if (heaters[mid] <= target) {
    //             left = mid;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }
    //     return Math.min(target - heaters[left], heaters[left + 1] - target);
    // }

    // public int findRadius(int[] houses, int[] heaters) {
    //     Arrays.sort(heaters);
    //     Set<Integer> set = new HashSet<>();
    //     for (int heater : heaters) {
    //         set.add(heater);
    //     }
    //     int max = 0;
    //     for (int house : houses) {
    //         int latest = findLatest(set, house);
    //         max = Math.max(latest, max);
    //     }
    //     return max;
    // }
    //
    // 有毒，如果供暖期位置偏远，查找慢的多，超时。。。。
    // private int findLatest(Set<Integer> set, int target) {
    //     int left = target, right = target;
    //     while (!set.contains(left) && !set.contains(right)) {
    //         left--;
    //         right++;
    //     }
    //     return set.contains(left) ? target - left : right - target;
    // }
}



























