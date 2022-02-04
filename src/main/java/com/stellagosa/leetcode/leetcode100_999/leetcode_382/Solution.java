package com.stellagosa.leetcode.leetcode100_999.leetcode_382;

import java.util.Random;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/16 15:18
 * @Description: 链表随机节点
 */
public class Solution {

    private ListNode node;

    public Solution(ListNode head) {
        this.node = head;
    }
    // 水塘抽样
    public int getRandom() {
        int res = 0;
        int i = 1;
        Random random = new Random();
        ListNode temp = node;
        while (temp != null) {
            if (random.nextInt(i) == 0) {
                res = temp.val;
            }
            temp = temp.next;
            i++;
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

