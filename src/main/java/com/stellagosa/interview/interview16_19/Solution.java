package com.stellagosa.interview.interview16_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/22 7:34
 * @Description: 水域大小
 */
public class Solution {

    // 8个可移动的方向
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j, m, n));
                }
            }
        }

//        int[] result = list.stream().mapToInt(Integer::intValue).toArray(); 速度慢的多

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);

        return result;
    }

    private int dfs(int[][] land, int curX, int curY, int m, int n) {
        int result = 0;
        if (curX >= 0 && curX < m && curY >= 0 && curY < n) {
            if (land[curX][curY] == 0) {
                land[curX][curY] = -1;
                result++;
                for (int[] dir : dirs) {
                    result += dfs(land, curX + dir[0], curY + dir[1], m, n);
                }
            }
        }
        return result;
    }

}
