package com.stellagosa.leetcode.leetcode100_999.leetcode_786;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/6 15:10
 */
public class Solution {
    public static void main(String[] args) {
        int[] res = kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }

    // 二分法查找
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        return new int[] {};
    }


    // 利用优先队列
//    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
//        // 长度为2的数组，分别记录分子分母的下标值
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]]);
//        for (int i = 0; i < arr.length; i++) {
//            queue.add(new int[]{0, i});
//        }
//
//        while (k > 1) {
//            int[] min = queue.poll();
//            if (min[1] - min[0] > 1) {
//                queue.add(new int[]{min[0] + 1, min[1]});
//            }
//            k--;
//        }
//        int[] res = queue.poll();
//        return new int[]{arr[res[0]], arr[res[1]]};
//    }


//    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
//        int n = arr.length;
//        // 记录 n 个数组的头部分数的分子的下标值
//        int[] temp = new int[n];
//        int minX = 1;
//        int minY = 1;
//        while (k > 0) {
//            minX = 1;
//            minY = 1;
//            int p = 0; // 记录第几个数组是最小值
//            for (int i = 1; i < n; i++) {
//                // i 表示第 i 个数组
//                // i=0时，也就是第一个数组都是大于等于1的值，不考虑
//                int curX = arr[temp[i]];
//                int curY = arr[i];
//                if (minX * curY > minY * curX) {
//                    minX = curX;
//                    minY = curY;
//                    p = i;
//                }
//            }
//            temp[p]++;
//            k--;
//        }
//        return new int[]{minX, minY};
//    }
}

//    a0   a1    a2    a3    a4    a5    a6    a7    a8
//a0  1  a0/a1 a0/a2 a0/a3 a0/a4 a0/a5 a0/a6 a0/a7 a0/a8
//a1       1   a1/a2 a1/a3 a1/a4 a1/a5 a1/a6 a1/a7 a1/a8
//a2             1   a2/a3 a2/a4 a2/a5 a2/a6 a2/a7 a2/a8
//a3                   1   a3/a4 a3/a5 a3/a6 a3/a7 a3/a8
//a4                         1   a4/a5 a4/a6 a4/a7 a4/a8
//a5                               1   a5/a6 a5/a7 a5/a8
//a6                                     1   a6/a7 a6/a8
//a7                                           1   a7/a8
//a8                                                 1

// 将每一竖列看成一个数组，则这9个数组从上到下都是递增的
// 选取最小的，每次只要比较这些竖列的数组头部的值
