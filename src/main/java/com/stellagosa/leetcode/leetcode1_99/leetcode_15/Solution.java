package com.stellagosa.leetcode.leetcode1_99.leetcode_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/10 21:11
 * @Description: 三数之和
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // 要求不重复，相同的值判断一次就可以
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 当前i与最大的两个数之和仍小于0，则当前i肯定不属于结果集
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;
            // 当前i和最小的两个数之和大于0，则肯定不存在更多的组合属于结果集
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;

            // 为什么将k的定义放在这里？
            // j的值是在逐渐增大，k的值只会比上一轮循环中k的值更小
            int k = n - 1;
            for (int j = i + 1; j < n - 1; j++) {

                // 同样是去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 前两个和已经大于0，则三数之和比大于0
                if (nums[i] + nums[j] > 0) break;

                // i、j以确定，只需查找存在不存在 nums[k]==-(nums[i]+nums[j])
                while (k > j && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }

                // 当前j已经找不到三树之和为0，则更大的j更不可能存在三数之和为0
                if (k <= j) break;

                // 若存在添加到结果中
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }

            }
        }
        return result;
    }

    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> result = new LinkedList<>();
    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length - 2; i++) {
    //         if (i > 0 && nums[i] == nums[i - 1]) continue;
    //         // 三数之和为0，最小的数肯定小于等于0
    //         if (nums[i] > 0) break;
    //         int left = i + 1;
    //         int right = nums.length - 1;
    //         while (left < right) {
    //             if (left > i + 1 && nums[left] == nums[left - 1]) {
    //                 left++;
    //                 continue;
    //             }
    //             if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
    //                 right--;
    //                 continue;
    //             }
    //             int num = nums[i] + nums[left] + nums[right];
    //             if (num == 0) {
    //                 List<Integer> list = new ArrayList<>(3);
    //                 list.add(nums[i]);
    //                 list.add(nums[left]);
    //                 list.add(nums[right]);
    //                 result.add(list);
    //                 left++;
    //                 right--;
    //             } else if (num > 0) {
    //                 right--;
    //             } else {
    //                 left++;
    //             }
    //         }
    //     }
    //     return result;
    // }

}
