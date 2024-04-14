package com.stellagosa.leetcode.leetcode100_999.leetcode_705;

/**
 * @author Stellagosa
 * @description 设计哈希集合
 * @date 2024/4/14 8:19 星期日
 */
public class MyHashSet {

    boolean[] flag = new boolean[1000001];

    public MyHashSet() {
    }

    public void add(int key) {
        flag[key] = true;
    }

    public void remove(int key) {
        flag[key] = false;
    }

    public boolean contains(int key) {
        return flag[key];
    }

}
