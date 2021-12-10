package com.stellagosa.leetcode.leetcode101_1000.leetcode_451;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:51
 */
public class Solution {
    public String frequencySort(String s) {
        Node node = new Node();
        for (int i = 0; i < s.length(); i++) {
            addNum(node, s.charAt(i));
        }
        return toString(node);
    }

    public void addNum(Node node, char ch) {
        Node p = node;
        Node q = node;
        while (q != null) {
            if (q.getCh() == ch) {
                q.setNum(q.getNum() + 1);
                sort(p, q);
                break;
            } else {
                p = q;
                q = q.getNext();
            }
        }
        if (q == null) {
            Node r = new Node();
            r.setCh(ch);
            r.setNum(1);
            r.setPre(p);
            r.setNext(null);
            p.setNext(r);
        }
    }

    public void sort(Node p, Node q) {
        Node pre = q.getPre();
        while (pre != null && q.getNum() > pre.getNum()) {
            char ch = pre.getCh();
            int num = pre.getNum();
            pre.setCh(q.getCh());
            pre.setNum(q.getNum());
            q.setCh(ch);
            q.setNum(num);
            q = pre;
            pre = q.getPre();
        }
    }

    public String toString(Node node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(String.valueOf(node.getCh()).repeat(Math.max(0, node.getNum())));
            node = node.getNext();
        }
        return builder.toString();
    }
}
