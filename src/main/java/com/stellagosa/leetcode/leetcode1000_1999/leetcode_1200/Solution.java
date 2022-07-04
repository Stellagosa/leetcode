package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/4 13:10
 * @Description: 最小绝对差
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,2,1,3};
        List<List<Integer>> lists = solution.minimumAbsDifference(arr);
        for (List<Integer> list : lists) {
            System.out.print(list.get(0));
            System.out.println(list.get(1));
        }
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i] - arr[i - 1];
            if (temp < min) {
                res.clear();
                min = temp;
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            } else if (temp == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;
    }
}
