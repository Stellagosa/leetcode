package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1405;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/7 10:08
 * @Description: 最长快乐字符串
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestDiverseString(3, 1, 1));
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder builder = new StringBuilder();
        Node[] nodes = new Node[]{new Node(a, 'a'), new Node(b, 'b'), new Node(c, 'c')};
        while (true) {
            Arrays.sort(nodes, (o1, o2) -> o2.count - o1.count);
            if (builder.length() < 2) {
                if (nodes[0].count <= 0) break;
                builder.append(nodes[0].ch);
                nodes[0].count--;
            } else {
                int length = builder.length();
                char first = builder.charAt(length - 2);
                char second = builder.charAt(length - 1);
                if (first == second && first == nodes[0].ch) {
                    if (nodes[1].count <= 0) break;
                    builder.append(nodes[1].ch);
                    nodes[1].count--;
                } else {
                    if (nodes[0].count <= 0) break;
                    builder.append(nodes[0].ch);
                    nodes[0].count--;
                }
            }
        }
        return builder.toString();
    }
}

class Node {
    int count;
    char ch;

    public Node(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
}
