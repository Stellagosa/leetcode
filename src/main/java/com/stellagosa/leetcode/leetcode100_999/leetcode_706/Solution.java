package com.stellagosa.leetcode.leetcode100_999.leetcode_706;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:56
 */
public class Solution {
    class Node {
        private int key;
        private int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    private Node[] elementData;
    private int length; //数组长度
    private int nums; //存放元素个数

    public Solution() {
        this.length = 800;
        this.nums = 0;
        this.elementData = new Node[this.length];
        for (int i = 0; i < this.length; i++) {
            this.elementData[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value) {
        int index = this.getIndex(key);
        if (index != -1) {
            this.elementData[index].setValue(value);
            return;
        }
        // 没找到，判断是否需要扩容
        if (nums == length) {
            this.elementData = kuorong();
        }
        // 添加元素
        this.elementData[nums].setKey(key);
        this.elementData[nums].setValue(value);
        this.nums++;
    }

    public int get(int key) {
        int index = this.getIndex(key);
        if (index != -1) return this.elementData[index].getValue();
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (index == -1) return;
        for (int i = index; i < this.nums - 1; i++) {
            this.elementData[i].setKey(this.elementData[i + 1].getKey());
            this.elementData[i].setValue(this.elementData[i + 1].getValue());
        }
        this.elementData[this.nums - 1].setKey(-1);
        this.elementData[this.nums - 1].setValue(-1);
        this.nums--;
    }

    //根据key查找位置
    private int getIndex(int key) {
        if (this.nums == 0) return -1;
        for (int i = 0; i < this.nums; i++) {
            if (key == this.elementData[i].getKey()) {
                return i;
            }
        }
        return -1;
    }

    private Node[] kuorong() {
        Node[] list = new Node[2 * length];
        if (this.length >= 0) System.arraycopy(elementData, 0, list, 0, this.length);
        for (int i = this.length; i < 2 * this.length; i++) {
            list[i] = new Node(-1, -1);
        }
        this.length = 2 * this.length;
        return list;
    }

    public void show() {
        for (int i = 0; i < this.nums; i++) {
            System.out.println(this.elementData[i]);
        }
    }
}
