package com.stellagosa.leetcode.leetcode1_99.leetcode_89;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/8 10:07
 * @Description: 格雷编码
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.grayCode(3);
        list.stream().map(Integer::toBinaryString).forEach(System.out::println);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        for (int i = 0; i < 1 << n; i++) {
            res.add((i >> 1) ^ i);
        }
        return res;
    }


// 0,1
// 00,01,11,10
// 000,001,011,010,110,111,101,100
// 观察发现，当为n时，首位前半部分为0，后半部分为1，去除首位后，前半部分为n-1的格雷码，后半部分为n-1格雷码的逆序

    // public List<Integer> grayCode(int n) {
    //     List<Integer> res = new ArrayList<>();
    //     int[] gener = generator(n);
    //     Arrays.stream(gener).forEach(res::add);
    //     return res;
    // }
    //
    // private int[] generator(int n) {
    //     if (n == 1) return new int[]{0, 1};
    //     else {
    //         int length = 1 << n;
    //         int[] res = new int[length];
    //         int[] temp = generator(n - 1);
    //         for (int i = 0; i < temp.length; i++) {
    //             res[i] = temp[i];
    //             res[length - i - 1] = temp[i] | 1 << (n - 1);
    //         }
    //         return res;
    //     }
    // }

    // public List<Integer> grayCode(int n) {
    //     List<Integer> res = new ArrayList<>();
    //     boolean[] visited = new boolean[1 << n];
    //     res.add(0);
    //     visited[0] = true;
    //     dfs(n, 0, res, visited);
    //     return res;
    // }

    // private boolean dfs(int n, int index, List<Integer> list, boolean[] visited) {
    //     if (index == 1<<n) {
    //         // 结束
    //         return true;
    //     }
    //     int cur = list.get(index); // 当前位置的数
    //     if (index + 1 == 1 << n) {
    //         // 最后一位，和第一位恰好有一位不同
    //         // 第一位肯定是 0，说明最后一位只能有一个1
    //         return (cur & (cur-1)) == 0;
    //     }
    //     for (int i = 0; i < n; i++) {
    //         int next = cur ^ (1 << i); // 异或改变其中一位
    //         if (visited[next]) continue; // 这个数用过了，下一个
    //         list.add(next);
    //         visited[next] = true;
    //         boolean check = dfs(n, index + 1, list, visited);
    //         if (!check) {
    //             list.remove(index);
    //             visited[next] = false;
    //         }
    //     }
    //     return true;
    // }
}

