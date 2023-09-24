package com.stellagosa.leetcode.leetcode100_999.leetcode_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description LRU 缓存
 * @date 2023/9/24 7:51 星期日
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }


    // [0] key, [1] value
    Node<int[]> first;
    Node<int[]> last;
    Map<Integer, Node<int[]>> cache;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>();
    }

    public int get(int key) {
        Node<int[]> node = cache.get(key);
        if (node == null) return -1;
        unlink(node);
        linkLast(node);
        return node.item[1];
    }

    public void put(int key, int value) {
        Node<int[]> node = cache.get(key);
        if (node == null) {
            // 节点不存在
            Node<int[]> newNode = new Node<>(new int[]{key, value}, null, null);
            if (size >= capacity) {
                cache.remove(first.item[0]);
                unlinkFirst();
            }
            linkLast(newNode);
            cache.put(key, newNode);
        } else {
            // 存在该节点
            node.item = new int[]{key, value};
            unlink(node);
            linkLast(node);
            cache.put(key, node);
        }
    }

    private void unlink(Node<int[]> node) {
        Node<int[]> prev = node.prev;
        Node<int[]> next = node.next;
        if (prev == null) {
            unlinkFirst();
        } else if (next == null) {
            unlinkLast();
        } else {
            prev.next = next;
            next.prev = prev;
            size--;
        }
        node.prev = null;
        node.next = null;
    }

    private void unlinkFirst() {
        if (first == null) return;
        Node<int[]> f = first;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        f.next = null;
        size--;
    }

    private void unlinkLast() {
        if (last == null) return;
        Node<int[]> l = last;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        l.prev = null;
        size--;
    }

    private void linkLast(Node<int[]> node) {
        if (last == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }

}
