package com.stellagosa.leetcode.leetcode100_999.leetcode_460;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description LFU 缓存
 * @date 2023/9/25 9:47 星期一
 */
public class LFUCache {


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);

        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));

    }

    Map<Integer, Node> cache;
    Map<Integer, ListNode> listCache;
    ListNode first;
    ListNode last;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        listCache = new HashMap<>();
        first = null;
        last = null;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        updateCount(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            // 已存在，更新value、count
            node.value = value;
            updateCount(node);
            cache.put(key, node);
        } else {
            // 不存在
            Node newNode = new Node(key, value, 1);
            if (size >= capacity) {
                // 已满，移除使用次数最少且最久未使用的
                removeRecentlyLeastUsed();
            }
            addNewNode(newNode);
        }
    }

    private void updateCount(Node node) {
        nodeRemove(node);
        ListNode listNode = listCache.get(node.count);
        if (listNode.next == null || listNode.next.count != node.count + 1) {
            ListNode newListNode = new ListNode(node.count + 1);
            newListNode.prev = listNode;
            newListNode.next = listNode.next;
            if (listNode.next != null) {
                listNode.next.prev = newListNode;
            }
            listNode.next = newListNode;
        }
        // 调用次数加1
        node.count++;

        // 添加到新的链表
        ListNode next = listNode.next;
        if (next.first == null) {
            next.first = node;
        } else {
            next.last.next = node;
            node.prev = next.last;
        }
        next.last = node;
        listCache.put(next.count, next);
        ifListNodeEmptyRemove(listNode);
    }

    private void addNewNode(Node newNode) {
        if (first == null) {
            ListNode listNode = new ListNode(1);
            first = listNode;
            last = listNode;
            first.first = newNode;
            first.last = newNode;
            listCache.put(listNode.count, listNode);
        } else {
            if (first.count > 1) {
                ListNode listNode = new ListNode(1);
                listNode.next = first;
                first.prev = listNode;
                first = listNode;
                first.first = newNode;
                first.last = newNode;
                listCache.put(listNode.count, listNode);
            } else {
                newNode.prev = first.last;
                first.last.next = newNode;
                first.last = newNode;
            }
        }
        cache.put(newNode.key, newNode);
        size++;
    }

    // 移除使用次数最少且最近未使用的
    private void removeRecentlyLeastUsed() {
        Node node = first.first;
        first.first = node.next;
        if (node.next != null) {
            node.next.prev = null;
        }
        size--;
        cache.remove(node.key);
        ifListNodeEmptyRemove(first);
    }


    // 如果该节点下的链表为空，移除该节点
    private void ifListNodeEmptyRemove(ListNode listNode) {
        if (listNode.first != null) return;
        ListNode prev = listNode.prev;
        ListNode next = listNode.next;
        if (prev == null) {
            this.first = next;
        } else {
            prev.next = next;
            listNode.prev = null;
        }

        if (next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            listNode.next = null;
        }
        listCache.remove(listNode.count);
    }

    private void nodeRemove(Node node) {
        int count = node.count;
        ListNode listNode = listCache.get(count);
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            listNode.first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            listNode.last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
    }


    private static class ListNode {
        int count;
        ListNode prev;
        ListNode next;
        Node first;
        Node last;

        ListNode() {
        }

        ListNode(int count) {
            this.count = count;
        }

    }

    private static class Node {
        int key;
        int value;
        int count;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

}
