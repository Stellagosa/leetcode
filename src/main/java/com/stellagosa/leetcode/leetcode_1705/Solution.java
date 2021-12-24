package com.stellagosa.leetcode.leetcode_1705;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/24 10:23
 * @Description:
 *
 * PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]); // 效率更高
 * PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
 */
public class Solution {

    public static void main(String[] args) {
        List<int[]> appleList = new ArrayList<>();
        List<int[]> dayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int n = random.nextInt(20000);
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) {
                arr1[j] = random.nextInt(20000);
                arr2[j] = random.nextInt(20000);
            }
            appleList.add(arr1);
            dayList.add(arr2);
        }
        Solution solution = new Solution();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            solution.eatenApples1(appleList.get(i), dayList.get(i));
        }
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            solution.eatenApples2(appleList.get(i), dayList.get(i));
        }
        long t3 = System.currentTimeMillis();

        System.out.println(t2 - t1);
        System.out.println(t3 - t2);

    }

    // public int eatenApples(int[] apples, int[] days) {
    //     PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    //     // PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    //     int n = apples.length;
    //     int count = 0;
    //     for (int day = 0; day < n || !queue.isEmpty(); day++) {
    //         while (!queue.isEmpty()) {
    //             int[] peek = queue.peek();
    //             if (peek[0] <= day) {
    //                 queue.poll();
    //             } else {
    //                 break;
    //             }
    //         }
    //         if (day < n && apples[day] > 0) {
    //             queue.add(new int[]{day + days[day], apples[day]});
    //         }
    //         if (!queue.isEmpty()) {
    //             int[] peek = queue.peek();
    //             count++;
    //             peek[1]--;
    //             if (peek[1] == 0) {
    //                 queue.poll();
    //             }
    //         }
    //     }
    //     return count;
    // }

    public int eatenApples1(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        int n = apples.length;
        int day = 0;
        int count = 0;
        do {
            if (day < n && apples[day] > 0) {
                queue.add(new int[]{day + days[day], apples[day]});
            }
            while (queue.size() > 0) {
                int[] peek = queue.peek();
                if (peek[0] > day && peek[1] > 0) {
                    count++;
                    peek[1]--;
                    break;
                } else {
                    queue.poll();
                }
            }
            day++;
        } while (day < n || queue.size() > 0);
        return count;
    }

    public int eatenApples2(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[0]));
        int n = apples.length;
        int day = 0;
        int count = 0;
        do {
            if (day < n && apples[day] > 0) {
                queue.add(new int[]{day + days[day], apples[day]});
            }
            while (queue.size() > 0) {
                int[] peek = queue.peek();
                if (peek[0] > day && peek[1] > 0) {
                    count++;
                    peek[1]--;
                    break;
                } else {
                    queue.poll();
                }
            }
            day++;
        } while (day < n || queue.size() > 0);
        return count;
    }
}
