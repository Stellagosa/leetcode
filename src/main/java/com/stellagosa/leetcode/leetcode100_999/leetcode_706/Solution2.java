package com.stellagosa.leetcode.leetcode100_999.leetcode_706;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:57
 */
public class Solution2 {
    class Node {
        private int key;
        private int value;
        private Node child;
        private Node parent;

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

        public Node getChild() {
            return child;
        }

        public void setChild(Node child) {
            this.child = child;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    private Node[] elementData;
    private final int length = 800; //数组长度

    public Solution2() {
        this.elementData = new Node[length];
        for (int i = 0; i < length; i++) {
            this.elementData[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value) {
        Node node = getIndex(key);
        if (node == null) {
            Node parent = elementData[key % length];
            Node child = parent.getChild();
            if (parent.getKey() == -1) {
                parent.setKey(key);
                parent.setValue(value);
                return;
            }
            node = new Node(key, value);
            node.setParent(parent);
            node.setChild(parent.getChild());
            parent.setChild(node);
            if (child != null) {
                child.setParent(node);
            }
            return;
        }
        node.setValue(value);
    }

    public int get(int key) {
        Node node = getIndex(key);
        if (node != null) return node.getValue();
        return -1;
    }

    public void remove(int key) {
        Node node = getIndex(key);
        if (node == null) return;
        Node parent = node.getParent();
        if (parent == null) {
            node.setKey(-1);
            node.setValue(-1);
        } else {
            parent.setChild(node.getChild());
            if (node.getChild() != null) {
                node.getChild().setParent(parent);
            }
        }
    }

    //根据key查找node
    private Node getIndex(int key) {
        int index = key % length;
        if (elementData[index].getKey() == key) return elementData[index];
        Node p = elementData[index];
        while (p.getChild() != null) {
            p = p.getChild();
            if (p.getKey() == -1) return null;
            if (p.getKey() == key) return p;
        }
        return null;
    }
}
