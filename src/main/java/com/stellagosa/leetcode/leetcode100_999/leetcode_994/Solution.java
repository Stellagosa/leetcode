package com.stellagosa.leetcode.leetcode100_999.leetcode_994;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 腐烂的橘子
 * @date 2024/5/13 5:42 星期一
 */
public class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        int goodCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    list.add(i * n + j);
                } else if (grid[i][j] == 1) {
                    goodCount++;
                }
            }
        }

        int time = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (true) {
            List<Integer> temp = new ArrayList<>();
            for (Integer loc : list) {
                int x = loc / n;
                int y = loc % n;
                for (int i = 0; i < dirs.length; i++) {
                    int xx = x + dirs[i][0];
                    int yy = y + dirs[i][1];
                    if (xx < 0 || xx >= m) continue;
                    if (yy < 0 || yy >= n) continue;
                    if (grid[xx][yy] == 1) {
                        temp.add(xx * n + yy);
                        grid[xx][yy] = 2;
                        goodCount--;
                    }
                }
            }
            if (temp.isEmpty()) break;
            list = temp;
            time++;
        }
        if (goodCount > 0) return -1;
        return time;
    }

}
