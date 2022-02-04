package com.stellagosa.leetcode.leetcode100_999.leetcode_451;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:51
 */
public class Node {
    private int num;
    private char ch;
    private Node next;
    private Node pre;

    public void setNum(int num) {
        this.num = num;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public int getNum() {
        return num;
    }

    public char getCh() {
        return ch;
    }

    public Node getNext() {
        return next;
    }

    public Node getPre() {
        return pre;
    }
}
