package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1575;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/6 下午 09:06
 * @Description: 统计所有可行路径
 */
public class Solution {

    private int mod = 1000000007;
    // cache[i][j]表示从i出发剩余油量j时，到达目的地的路径数量
    private int[][] cache;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        cache = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    /**
     * @param locations locations
     * @param cur       当前位置
     * @param end       结束位置
     * @param fuel      剩余油量
     * @return 路径数量
     */
    private int dfs(int[] locations, int cur, int end, int fuel) {
        // 已得出结果
        if (cache[cur][fuel] != -1) {
            return cache[cur][fuel];
        }

        // 油量为 0，且不在目标位置
        if (fuel == 0 && cur != end) {
            cache[cur][fuel] = 0;
            return 0;
        }

        // 不能从 cur 到达 end，则永远不能到达
        int need = Math.abs(locations[cur] - locations[end]);
        if (need > fuel) {
            cache[cur][fuel] = 0;
            return cache[cur][fuel];
        }

        int count = cur == end ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            if (i != cur) {
                need = Math.abs(locations[cur] - locations[i]);
                if (need <= fuel) {
                    count += dfs(locations, i, end, fuel - need);
                    count %= mod;
                }
            }
        }
        cache[cur][fuel] = count;
        return cache[cur][fuel];
    }

    // /**
    //  * @param locations locations
    //  * @param cur       当前位置
    //  * @param end       结束位置
    //  * @param fuel      剩余油量
    //  * @return 路径数量
    //  */
    // private int dfs(int[] locations, int cur, int end, int fuel) {
    //     // 已得出结果
    //     if (cache[cur][fuel] != -1) {
    //         return cache[cur][fuel];
    //     }
    //
    //     // 油量为 0，且不在目标位置
    //     if (fuel == 0 && cur != end) {
    //         cache[cur][fuel] = 0;
    //         return 0;
    //     }
    //
    //     // 油量不为 0，但不能到达任何位置
    //     boolean flag = false;
    //     for (int i = 0; i < locations.length; i++) {
    //         if (i != cur) {
    //             if (Math.abs(locations[i] - locations[cur]) <= fuel) {
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //     }
    //     if (fuel != 0 && !flag) {
    //         cache[cur][fuel] = cur == end ? 1 : 0;
    //         return cache[cur][fuel];
    //     }
    //
    //     int count = cur == end ? 1 : 0;
    //     for (int i = 0; i < locations.length; i++) {
    //         if (i != cur) {
    //             int need = Math.abs(locations[cur] - locations[i]);
    //             if (need <= fuel) {
    //                 count += dfs(locations, i, end, fuel - need);
    //                 count %= mod;
    //             }
    //         }
    //     }
    //     cache[cur][fuel] = count;
    //     return cache[cur][fuel];
    // }

}
