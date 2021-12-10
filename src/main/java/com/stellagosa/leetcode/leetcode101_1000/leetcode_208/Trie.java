package com.stellagosa.leetcode.leetcode101_1000.leetcode_208;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:49
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chs = word.toCharArray();
        int index;
        TrieNode cur = root;
        for (char ch : chs) {
            index = ch - 'a';
            if (cur.nexts[index] == null) {
                cur.nexts[index] = new TrieNode();
            }
            cur = cur.nexts[index];
            cur.pass++;
        }
        cur.end++;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        int index;
        TrieNode cur = root;
        for (char ch : chs) {
            index = ch - 'a';
            if (cur.nexts[index] == null) {
                return false;
            }
            cur = cur.nexts[index];
        }
        return cur.end != 0;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] chs = prefix.toCharArray();
        int index;
        TrieNode cur = root;
        for (char ch : chs) {
            index = ch - 'a';
            if (cur.nexts[index] == null) {
                return false;
            }
            cur = cur.nexts[index];
        }
        return cur.pass != 0;
    }
}

class TrieNode {
    int pass;
    int end;
    TrieNode[] nexts;

    TrieNode() {
        pass = 0;
        end = 0;
        nexts = new TrieNode[26];
    }
}
