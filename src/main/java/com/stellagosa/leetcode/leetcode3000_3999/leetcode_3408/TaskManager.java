package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3408;

import java.util.*;

/**
 * @author Stellagosa
 * @description 设计任务管理器
 * @date 2025/9/18 10:00 星期四
 */
public class TaskManager {

    private Map<Integer, int[]> map ; // <taskId,[userId, priority]>
    private PriorityQueue<int[]> queue; // <[priority, taskId]>

    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            map.put(taskId, new int[]{userId, priority});
            queue.offer(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new int[]{userId, priority});
        queue.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        if (map.containsKey(taskId)) {
            map.get(taskId)[1] = newPriority;
            queue.offer(new int[]{newPriority, taskId});
        }
    }

    public void rmv(int taskId) {
        map.remove(taskId);
    }

    public int execTop() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (map.containsKey(poll[1])) {
                int[] tmp = map.get(poll[1]);
                if (poll[0] == tmp[1]) {
                    map.remove(poll[1]);
                    return tmp[0];
                }
            }
        }
        return -1;
    }
}



// 超时
// public class TaskManager {
//
//     public static void main(String[] args) {
//         List<List<Integer>> lists = List.of(List.of(1,101,10),List.of(2,102,20),List.of(3,103,15));
//         TaskManager manager = new TaskManager(lists);
//         manager.add(4,104,5);
//         manager.edit(102, 8);
//         int i = manager.execTop();
//         System.out.println(i);
//         manager.rmv(101);
//         manager.add(5,105,15);
//         i = manager.execTop();
//         System.out.println(i);
//     }
//
//
//     private Node root;
//     private Map<Integer, Node> map; //<taskId, Node>
//
//     public TaskManager(List<List<Integer>> tasks) {
//         map = new HashMap<>();
//         Node head = new Node();
//         Node node = head;
//         for (List<Integer> task : tasks) {
//             Node n = new Node(task.get(0), task.get(1), task.get(2));
//             node.next = n;
//             n.pre = node;
//             node = node.next;
//             map.put(task.get(1), n);
//         }
//         root = head.next;
//         if (root != null) {
//             root.pre = null;
//         }
//         sort();
//     }
//
//     public void add(int userId, int taskId, int priority) {
//         Node search = search(taskId, priority);
//         Node node = new Node(userId, taskId, priority);
//         if (search == null) {
//             node.next = root;
//             if (root != null) {
//                 root.pre = node;
//             }
//             root = node;
//         } else {
//             if (search.next != null) {
//                 node.next = search.next;
//                 search.next.pre = node;
//                 search.next = node;
//                 node.pre = search;
//             } else {
//                 search.next = node;
//                 node.pre = search;
//             }
//         }
//         map.put(taskId, node);
//     }
//
//     public void edit(int taskId, int priority) {
//         Node node = map.get(taskId);
//         rmv(taskId);
//         add(node.userId, node.taskId, priority);
//     }
//
//     public void rmv(int taskId) {
//         Node node = map.remove(taskId);
//         Node pre = node.pre;
//         Node next = node.next;
//
//         if (pre == null) {
//             root = next;
//             if (next != null) {
//                 next.pre = null;
//             }
//         } else {
//             pre.next = next;
//             if (next != null) {
//                 next.pre = pre;
//             }
//         }
//     }
//
//     public int execTop() {
//         if (root != null) {
//             Node res = root;
//             root = root.next;
//             if (root != null) {
//                 root.pre = null;
//             }
//             map.remove(res.taskId);
//             return res.userId;
//         }
//         return -1;
//     }
//
//
//     // 查询 taskId priority 的前一个 node
//     private Node search(int taskId, int priority) {
//         if (root == null) return null;
//         if (priority > root.priority) return null;
//         if (priority == root.priority && taskId > root.taskId) return null;
//
//         Node node = root;
//         while (node != null) {
//             if (node.next == null) return node;
//             if (node.next.priority < priority) return node;
//             if (node.next.priority == priority && node.next.taskId < taskId) return node;
//             node = node.next;
//         }
//         return null;
//     }
//
//     // 排序
//     private void sort() {
//         if (root == null || root.next == null) return;
//         root = sortList(root);
//     }
//
//     // 二路归并排序
//     private Node sortList(Node head) {
//         if (head == null || head.next == null) return head;
//
//         // 快慢指针查找中间节点
//         Node slow = head, fast = head;
//         while (fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         // 切断指针
//         Node mid = slow.next;
//         slow.next = null;
//         mid.pre = null;
//
//         Node left = sortList(head);
//         Node right = sortList(mid);
//         return merge(left, right);
//     }
//
//     // 合并两个有序链表
//     private Node merge(Node left, Node right) {
//         if (left == null) return right;
//         if (right == null) return left;
//
//         Node head = new Node();
//         Node node = head;
//         while (left != null && right != null) {
//             if (left.compare(right) > 0) {
//                 node.next = left;
//                 left.pre = node;
//                 left = left.next;
//             } else {
//                 node.next = right;
//                 right.pre = node;
//                 right = right.next;
//             }
//             node = node.next;
//         }
//
//         if (left == null) {
//             node.next = right;
//             right.pre = node;
//         } else {
//             node.next = left;
//             left.pre = node;
//         }
//         head.next.pre = null;
//         return head.next;
//     }
//
//
//     class Node {
//         int userId;
//         int taskId;
//         int priority;
//
//         Node pre;
//         Node next;
//
//         public Node() {}
//
//         public Node(int userId, int taskId, int priority) {
//             this.userId = userId;
//             this.taskId = taskId;
//             this.priority = priority;
//         }
//
//         public int compare(Node node) {
//             if (this.priority == node.priority) return this.taskId - node.taskId;
//             return this.priority - node.priority;
//         }
//     }
//
// }
