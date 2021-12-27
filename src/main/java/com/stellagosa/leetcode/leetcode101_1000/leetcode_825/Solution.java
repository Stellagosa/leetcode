package com.stellagosa.leetcode.leetcode101_1000.leetcode_825;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/27 11:14
 * @Description: 适龄的朋友
 */
public class Solution {

    public static void main(String[] args) {
        int[] ages = {20, 30, 100, 110, 120};
        Solution solution = new Solution();
        System.out.println(solution.numFriendRequests(ages));
    }

    public int numFriendRequests(int[] ages) {
        int[] arr = new int[121];
        for (int age : ages) {
            arr[age]++;
        }
        int res = 0;
        int sum = 0; // 记录满足条件且小于当前年纪的人数，优化while循环
        int left = 15; // sum中的人最小的年纪
        for (int age = 15; age <= 120; age++) {
            while (left <= 7 + age / 2) {
                sum -= arr[left];
                left++;
            }
            if (arr[age] == 0) continue; //避免当前年龄人数为0时的减1操作
            res += arr[age] * sum + arr[age] * (arr[age] - 1);
            sum += arr[age];
        }
        return res;
    }

    /**
     * 例如：现在17岁的有100人，16岁的有50人，问17岁的人总共发送了多少请求
     * 首写是17岁会向16岁的发送请求，每一个17岁的都会发送50个请求，共 100*50 个请求
     * 同时17岁的会向同样17岁的发送请求，共 100*(100-1) 个请求
     * 所以17岁的共发送了 100*50+100*(100-1)个请求
     */
    // public int numFriendRequests(int[] ages) {
    //     int[] arr = new int[121];
    //     // 统计各个年龄的人数
    //     for (int age : ages) {
    //         arr[age]++;
    //     }
    //     int res = 0;
    //     // age[y] > 0.5 * age[x] + 7
    //     // age[y] <= age[x]
    //     // !(age[y] > 100 && age[x] < 100)
    //     //
    //     // age[y]>7+age[x]/2 && age[y]<age[x] => 可以发送请求的最小年龄为15
    //     // 条件三毫无意义
    //     for (int age = 15; age <= 120; age++) {
    //         int minAge = 8 + age / 2;
    //         // while (age < 100 && minAge <= 100 && minAge <= age) {
    //         while (minAge <= age) {
    //             if (minAge == age) {
    //                 res += arr[minAge] * (arr[minAge] - 1);
    //             } else {
    //                 res += arr[minAge] * arr[age];
    //             }
    //             minAge++;
    //         }
    //         // while (age >= 100 && minAge <= age) {
    //         //     if (minAge == age) {
    //         //         res += arr[minAge] * (arr[minAge] - 1);
    //         //     } else {
    //         //         res += arr[minAge] * arr[age];
    //         //     }
    //         //     minAge++;
    //         // }
    //     }
    //     return res;
    // }

}
