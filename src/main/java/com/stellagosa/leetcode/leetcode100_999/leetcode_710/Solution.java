package com.stellagosa.leetcode.leetcode100_999.leetcode_710;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/26 5:07
 * @Description: 黑名单中的随机数
 */
public class Solution {

    public static void main(String[] args) {
        int[] blacklist = {0, 1};
        Solution solution = new Solution(4, blacklist);
    }

    private final Random random = new Random();
    private final Map<Integer, Integer> map = new HashMap<>();
    private final int bound;

    public Solution(int n, int[] blacklist) {
        this.bound = n - blacklist.length;
        HashSet<Integer> set = Arrays.stream(blacklist).boxed().collect(Collectors.toCollection(HashSet::new));
        int temp = bound;
        for (int num : blacklist) {
            if (num < bound) {
                while (set.contains(temp)) {
                    temp++;
                }
                map.put(num, temp);
                temp++;
            }
        }
    }

    public int pick() {
        int nextInt = random.nextInt(bound);
        return map.getOrDefault(nextInt, nextInt);
    }
}


// [0,bound) 随机数，黑名单在这个范围的找出对应关系
// x属于[0,bound) 并且 x属于blacklist，找出x对应[bound,n)的对应关系