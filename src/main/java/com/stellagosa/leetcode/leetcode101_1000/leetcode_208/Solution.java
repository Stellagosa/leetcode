package com.stellagosa.leetcode.leetcode101_1000.leetcode_208;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:48
 */
public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] orders = new String[]{
                "insert", "search", "search", "startsWith", "insert", "search"
        };
        String[] str = new String[]{
                "apple", "apple", "app", "app", "app", "app"
        };

        for (int i = 0; i < orders.length; i++) {
            switch (orders[i]) {
                case "insert": {
                    trie.insert(str[i]);
                    System.out.println("insert");
                    break;
                }
                case "search": {
                    boolean search = trie.search(str[i]);
                    System.out.println("search:" + search);
                    break;
                }
                case "startsWith": {
                    boolean startsWith = trie.startsWith(str[i]);
                    System.out.println("startsWith:" + startsWith);
                    break;
                }
            }
        }
    }
}
