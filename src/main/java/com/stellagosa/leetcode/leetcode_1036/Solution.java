package com.stellagosa.leetcode.leetcode_1036;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/11 10:19
 * @Description: 逃离大迷宫
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] blocked = {{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        System.out.println(solution.isEscapePossible(blocked, source, target));
    }

    // 只要包不住，就可以到达  12ms
    int[][] temp = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n = 1000000;
    Set<Long> blockedSet = new HashSet<>();

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] loc : blocked) {
            blockedSet.add((long) loc[0] * n + loc[1]);
        }
        // 原点目标点都没有被包围
        return dfs(source[0], source[1], source, target, new HashSet<>()) && dfs(target[0], target[1], target, source, new HashSet<>());
    }

    private boolean dfs(int curX, int curY, int[] source, int[] target, Set<Long> visited) {
        // 寻到目标点
        if (curX == target[0] && curY == target[1]) return true;
        // 包不住了
        if (Math.abs(curX - source[0]) + Math.abs(curY - source[1]) > blockedSet.size()) return true;

        visited.add((long) curX * n + curY);

        for (int[] t : temp) {
            int x = curX + t[0];
            int y = curY + t[1];
            if (x < 0 || x >= n || y < 0 || y >= n) {
                continue;
            }
            if (!blockedSet.contains((long) x * n + y) && !visited.contains((long) x * n + y)) {
                if (dfs(x, y, source, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    // 减小数据规模 17/18ms
    // public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    //     // 确定那些行列是必须被保留的
    //     TreeSet<Integer> rows = new TreeSet<>(); // 行
    //     TreeSet<Integer> columns = new TreeSet<>(); // 列
    //     for (int[] loc : blocked) {
    //         rows.add(loc[0]);
    //         columns.add(loc[1]);
    //     }
    //     rows.add(source[0]);
    //     rows.add(target[0]);
    //     columns.add(source[1]);
    //     columns.add(target[1]);
    //
    //     // 确定老的行列和新的行列的映射关系
    //     Map<Integer, Integer> rowMapping = new HashMap<>();
    //     Map<Integer, Integer> columnMapping = new HashMap<>();
    //     int m = 0; // 用来记录行下标
    //     int n = 0; // 用来记录列下标
    //     m = generateMapping(rows, rowMapping, m);
    //     n = generateMapping(columns, columnMapping, n);
    //
    //     // 根据对应关系，描绘最后压缩的结果图
    //     int[][] grid = new int[m + 1][n + 1];
    //
    //     // 遍历所有障碍物点，根据映射关系，将障碍物点映射到新的图中
    //     for (int[] loc : blocked) {
    //         grid[rowMapping.get(loc[0])][columnMapping.get(loc[1])] = -1; // -1表示不可达
    //     }
    //     // 映射后的原点
    //     int x1 = rowMapping.get(source[0]);
    //     int y1 = columnMapping.get(source[1]);
    //     // 映射后的目标点
    //     int x2 = rowMapping.get(target[0]);
    //     int y2 = columnMapping.get(target[1]);
    //
    //     // 将起始点设为1，方便辨识
    //     grid[x1][y1] = 1;
    //
    //     // 寻找目标点
    //     Queue<int[]> queue = new ArrayDeque<>();
    //     queue.offer(new int[]{x1, y1});
    //     int[][] temp = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         while (size > 0) {
    //             int[] loc = queue.poll();
    //             // 更新loc邻接点的距离
    //             for (int[] t : temp) {
    //                 int x = loc[0] + t[0];
    //                 int y = loc[1] + t[1];
    //                 if (x == x2 && y == y2) {
    //                     // 找到目标点
    //                     return true;
    //                 }
    //                 if (x >= 0 && x <= m && y >= 0 && y <= n && grid[x][y] == 0) {
    //                     // 没有越界，并且当前点没有遍历到
    //                     // 更新当前点的距离
    //                     grid[x][y] = grid[loc[0]][loc[1]] + 1;
    //                     // 将当前点加入队列中
    //                     queue.offer(new int[]{x, y});
    //                 }
    //             }
    //             size--;
    //         }
    //     }
    //     // 没有找到目标点
    //     return false;
    // }

    // private int generateMapping(TreeSet<Integer> set, Map<Integer, Integer> map, int index) {
    //     // 处理新行旧行对应关系
    //     int first = set.first();
    //     int pre = first; // 记录上一行原始行下标
    //     if (first != 0) {
    //         // 旧表中该行不是第0行，则该行应该映射为第1行，即新表中第0行为空行
    //         map.put(first, 1);
    //         // 则现在新表总共应有两行，下标为1
    //         index++;
    //     }
    //     map.put(0, 0);
    //     for (int original : set) {
    //         if (original == first) {
    //             continue;
    //         }
    //         index += original - pre == 1 ? 1 : 2; // 若两行相邻，压缩后还是相邻，否则中间有空行
    //         map.put(original, index);
    //         pre = original;
    //     }
    //     // 判断最后一行
    //     int last = set.last();
    //     // 若last是整个表的最后一行，则下面不会再有空行
    //     // 原表为 1000 000 X 1000 000
    //     if (last != 1000000 - 1) {
    //         index++;
    //     }
    //     return index;
    // }
}
