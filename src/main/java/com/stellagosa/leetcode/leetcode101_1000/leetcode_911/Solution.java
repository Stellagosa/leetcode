package com.stellagosa.leetcode.leetcode101_1000.leetcode_911;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/11 10:09
 * @Description: 在线选举
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 62, 100, 88, 70, 73, 22, 75, 29, 10};
        int[] persons = new int[]{0, 0, 1, 1, 2};
        int[] times = new int[]{0, 67, 69, 74, 87};
        TopVotedCandidate target = new TopVotedCandidate(persons, times);

        for (int j : arr) {
            System.out.println(target.q(j));
        }
    }
}

class TopVotedCandidate {

    Map<Integer, Integer> map = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        // 当前时间最多票数
        int max = 1;
        // 当前时间得票最多的人
        int maxPer = persons[0];
        // 记录票数
        int[] count = new int[persons.length];
        count[persons[0]] = 1;
        map.put(times[0], maxPer);

        for (int i = 1; i < persons.length; i++) {
            count[persons[i]]++;//当前人票数+1
            if (count[persons[i]] >= max) {
                max = count[persons[i]];
                maxPer = persons[i];
                map.put(times[i], maxPer);
            }
        }
    }

    public int q(int t) {
        int res = map.getOrDefault(t, -1);
        while (res == -1) {
            t--;
            res = map.getOrDefault(t, -1);
        }
        return res;
    }
}
