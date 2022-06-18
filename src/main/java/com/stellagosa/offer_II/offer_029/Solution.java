package com.stellagosa.offer_II.offer_029;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/18 6:23
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Node head = solution.insert(node1, 2);

        Node node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next == head ? null : node.next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node cur = head;
        Node next = head.next;
        while (next != head) {
            if (cur.val <= insertVal && next.val >= insertVal) {
                // 找到合适位置
                break;
            }
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        }
        cur.next = node;
        node.next = next;
        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}