package com.stellagosa.leetcode.leetcode100_999.leetcode_901;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Stellagosa
 * @description 股票价格跨度
 * @date 2023/10/7 20:34 星期六
 */
public class StockSpanner {

    private final Deque<int[]> deque;
    private int id;

    public StockSpanner() {
        deque = new LinkedList<>();
        deque.push(new int[]{-1, Integer.MAX_VALUE});
        id = -1;
    }

    public int next(int price) {
        id++;
        while (price >= deque.peek()[1]) {
            deque.pop();
        }
        int result = id - deque.peek()[0];
        deque.push(new int[]{id, price});
        return result;
    }

}
