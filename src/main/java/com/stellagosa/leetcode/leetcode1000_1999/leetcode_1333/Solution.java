package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1333;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Stellagosa
 * @description 餐厅过滤器
 * @date 2023/9/27 7:20 星期三
 */
public class Solution {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(item -> {
                    if (veganFriendly == 1) {
                        return item[2] == 1;
                    }
                    return true;
                })
                .filter(item -> item[3] <= maxPrice)
                .filter(item -> item[4] <= maxDistance)
                .sorted((o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o2[0] - o1[0];
                    }
                    return o2[1] - o1[1];
                })
                .map(item -> item[0])
                .collect(Collectors.toList());
    }

}
