package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2034;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/23 13:24
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        String[] command = {"update", "update", "current", "maximum", "update", "maximum", "update", "minimum"};
        int[][] arr = {{1, 10}, {2, 5}, {}, {}, {1, 3}, {}, {4, 2}, {}};
        StockPrice stockPrice = new StockPrice();
        for (int i = 0; i < command.length; i++) {
            String str = command[i];
            switch (str) {
                case "update":
                    stockPrice.update(arr[i][0], arr[i][1]);
                    break;
                case "current":
                    System.out.println("current: " + stockPrice.current());
                    break;
                case "maximum":
                    System.out.println("max: " + stockPrice.maximum());
                    break;
                case "minimum":
                    System.out.println("min: " + stockPrice.minimum());
                    break;
            }
        }
    }
}
