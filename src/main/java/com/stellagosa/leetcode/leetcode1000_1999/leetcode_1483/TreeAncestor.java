package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1483;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/29 15:57
 * @Description: 树节点的第k个祖先
 */
public class TreeAncestor {

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor treeAncestor = new TreeAncestor(7, parent);
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }

    private final int[][] ancestors;

    public TreeAncestor(int n, int[] parent) {
        ancestors = new int[n][16];
        for (int i = 0; i < n; i++) {
            ancestors[i][0] = parent[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 16; j++) {
                if (ancestors[i][j - 1] == -1) {
                    ancestors[i][j] = -1;
                } else {
                    ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];

                }
            }
        }

    }

    public int getKthAncestor(int node, int k) {
        int cnt = 0;
        while (k != 0 && node != -1) {
            int temp = k % 2;
            if (temp == 1) {
                node = ancestors[node][cnt];
            }
            cnt++;
            k >>= 1;
        }
        return node;
    }

}
