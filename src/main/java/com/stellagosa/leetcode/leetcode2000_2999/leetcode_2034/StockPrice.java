package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2034;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/23 12:30
 * @Description: 股票价格波动
 */
public class StockPrice {
    // 价格和时间戳映射
    TreeMap<Integer, Set<Integer>> map1 = new TreeMap<>();
    // 时间戳和价格映射
    Map<Integer, Integer> map2 = new HashMap<>();
    int currentPrice = 0;
    int currentTime = 0;

    public StockPrice() {
    }

    public void update(int timestamp, int price) {
        if (timestamp >= currentTime) {
            currentTime = timestamp;
            currentPrice = price;
        }

        if (map2.containsKey(timestamp)) {
            int prePrice = map2.get(timestamp);
            Set<Integer> set = map1.get(prePrice);
            if (set.size() == 1) {
                map1.remove(prePrice);
            } else {
                set.remove(timestamp);
            }
        }
        map2.put(timestamp, price);
        if (map1.containsKey(price)) {
            map1.get(price).add(timestamp);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(timestamp);
            map1.put(price, set);
        }
    }

    public int current() {
        return currentPrice;
    }

    public int maximum() {
        return map1.lastEntry().getKey();
    }

    public int minimum() {
        return map1.firstEntry().getKey();
    }
}

// 超时
// public class StockPrice {
//     private final List<int[]> store;
//     private final Map<Integer, Integer> mapping;
//     private int index;
//     private int currentPrice;
//     private int currentTime;
//     private int maximum;
//     private int maximumTime;
//     private int minimum;
//     private int minimumTime;
//
//     public StockPrice() {
//         store = new ArrayList<>();
//         mapping = new HashMap<>();
//         index = 0;
//         currentTime = Integer.MIN_VALUE;
//         currentPrice = Integer.MIN_VALUE;
//         maximum = Integer.MIN_VALUE;
//         maximumTime = 0;
//         minimum = Integer.MAX_VALUE;
//         minimumTime = 0;
//     }
//
//     public void update(int timestamp, int price) {
//         if (timestamp >= currentTime) {
//             currentTime = timestamp;
//             currentPrice = price;
//         }
//         if (!mapping.containsKey(timestamp)) {
//             store.add(new int[]{timestamp, price});
//             mapping.put(timestamp, index);
//             index++;
//             if (price > maximum) {
//                 maximum = price;
//                 maximumTime = timestamp;
//             }
//             if (price < minimum) {
//                 minimum = price;
//                 minimumTime = timestamp;
//             }
//         } else {
//             int loc = mapping.get(timestamp);
//             store.set(loc, new int[]{timestamp, price});
//             // 最高/最低价格如果有多个就很难判定改的那个，必须遍历
//             maximum = Integer.MIN_VALUE;
//             maximumTime = 0;
//             minimum = Integer.MAX_VALUE;
//             minimumTime = 0;
//             for (int[] item : store) {
//                 if (item[1] > maximum) {
//                     maximum = item[1];
//                     maximumTime = item[0];
//                 }
//                 if (item[1] < minimum) {
//                     minimum = item[1];
//                     minimumTime = item[0];
//                 }
//             }
//         }
//     }
//
//     public int current() {
//         return currentPrice;
//     }
//
//     public int maximum() {
//         return maximum;
//     }
//
//     public int minimum() {
//         return minimum;
//     }
// }
