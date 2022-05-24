package com.stellagosa.leetcode.leetcode100_999.leetcode_675;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/23 10:03
 * @Description: 为高尔夫比赛砍树
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = {{4, 2, 3}, {0, 0, 1}, {7, 6, 5}};
        List<List<Integer>> forest = new ArrayList<>();

        for (int[] ints : arr) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr[0].length; j++) {
                list.add(ints[j]);
            }
            forest.add(list);
        }
        System.out.println(solution.cutOffTree(forest));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        quickSort(list, (o1, o2) -> forest.get(o1[0]).get(o1[1]) - forest.get(o2[0]).get(o2[1]), 0, list.size() - 1);

        int res = 0;
        int preX = 0;
        int preY = 0;
        for (int[] ints : list) {
            int len = bfs(forest, preX, preY, ints[0], ints[1]);
            if (len < 0) return -1;
            res += len;
            preX = ints[0];
            preY = ints[1];
        }
        return res;
    }


    // TAG 广度优先搜索
    // 广度优先搜索，两点间的最短路径 -1表示两点间不能连通
    private int bfs(List<List<Integer>> forest, int beginX, int beginY, int endX, int endY) {
        if (beginX == endX && beginY == endY) return 0;
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visit = new boolean[m][n];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{beginX, beginY});
        visit[beginX][beginY] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size > 0) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextPointX = point[0] + dir[j][0];
                    int nextPointY = point[1] + dir[j][1];
                    if (nextPointX >= 0 && nextPointX < m && nextPointY >= 0 && nextPointY < n) {
                        if (!visit[nextPointX][nextPointY] && forest.get(nextPointX).get(nextPointY) > 0) {
                            if (nextPointX == endX && nextPointY == endY) {
                                return step;
                            }
                            queue.offer(new int[]{nextPointX, nextPointY});
                            visit[nextPointX][nextPointY] = true;
                        }
                    }
                }
                size--;
            }
        }
        return -1;
    }


    // TAG list 快排
    private <T> void quickSort(List<T> list, Comparator<? super T> comparator, int left, int right) {
        if (left < right) {
            int mid = partitify(list, comparator, left, right);
            quickSort(list, comparator, left, mid - 1);
            quickSort(list, comparator, mid + 1, right);
        }
    }

    private final Random random = new Random();

    private <T> int partitify(List<T> list, Comparator<? super T> comparator, int left, int right) {
        int index = random.nextInt(right - left + 1) + left;
        swap(list, index, right);

        T rightEle = list.get(right);
        int pre = left, cur = left;

        while (pre < right) {
            if (comparator.compare(list.get(pre), rightEle) < 0) {
                swap(list, cur, pre);
                cur++;
            }
            pre++;
        }
        swap(list, cur, right);
        return cur;
    }

    private <T> void swap(List<T> list, int a1, int a2) {
        T temp = list.get(a1);
        list.set(a1, list.get(a2));
        list.set(a2, temp);
    }
}
