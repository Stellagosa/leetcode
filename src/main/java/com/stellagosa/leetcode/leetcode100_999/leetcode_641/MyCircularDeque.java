package com.stellagosa.leetcode.leetcode100_999.leetcode_641;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/15 8:13
 * @Description: 设计循环双端队列
 */
public class MyCircularDeque {

    int header;

    int tail;

    int length;

    int maxLen;

    int[] arr;

    public MyCircularDeque(int k) {
        arr = new int[k];
        maxLen = k;
        header = k - 1;
        tail = 0;
        length = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        arr[header] = value;
        length++;
        header = (header + maxLen - 1) % maxLen;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        arr[tail] = value;
        length++;
        tail = (tail + 1) % maxLen;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        header = (header + 1) % maxLen;
        length--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + maxLen) % maxLen;
        length--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : arr[(header + 1) % maxLen];
    }

    public int getRear() {
        return isEmpty() ? -1 : arr[(tail - 1 + maxLen) % maxLen];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == maxLen;
    }

}
