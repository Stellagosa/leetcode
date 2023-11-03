package com.stellagosa.leetcode.leetcode100_999.leetcode_117;

/**
 * @author Stellagosa
 * @description 填充每个节点的下一个右侧节点指针Ⅱ
 * @date 2023/11/3 9:41 星期五
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) return null;
        Node start = root;
        while (start != null) {
            Node prev = null;
            Node nextStart = null;
            for (Node node = start; node != null; node = node.next) {
                if (node.left != null) {
                    if (prev == null) {
                        prev = node.left;
                        nextStart = prev;
                    } else {
                        prev.next = node.left;
                        prev = prev.next;
                    }
                }

                if (node.right != null) {
                    if (prev == null) {
                        prev = node.right;
                        nextStart = prev;
                    } else {
                        prev.next = node.right;
                        prev = prev.next;
                    }
                }
            }
            start = nextStart;
        }
        return root;
    }


    // public Node connect(Node root) {
    //     Queue<Node> queue = new LinkedList<>();
    //     if (root != null) {
    //         queue.offer(root);
    //     }
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         for (int i = 0; i < size; ++i) {
    //             Node poll = queue.poll();
    //             if (i != size - 1) {
    //                 poll.next = queue.peek();
    //             }
    //             if (poll.left != null) {
    //                 queue.offer(poll.left);
    //             }
    //             if (poll.right != null) {
    //                 queue.offer(poll.right);
    //             }
    //         }
    //     }
    //     return root;
    // }

    // public Node connect(Node root) {
    //     Queue<Node> queue = new LinkedList<>();
    //     if (root != null) {
    //         queue.offer(root);
    //     } else {
    //         return null;
    //     }
    //
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         Queue<Node> temp = new LinkedList<>();
    //         for (int i = 0; i < size; ++i) {
    //             Node poll = queue.poll();
    //             poll.next = queue.peek();
    //             if (poll.left != null) {
    //                 temp.offer(poll.left);
    //             }
    //             if (poll.right != null) {
    //                 temp.offer(poll.right);
    //             }
    //         }
    //         queue = temp;
    //     }
    //     return root;
    // }

}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

