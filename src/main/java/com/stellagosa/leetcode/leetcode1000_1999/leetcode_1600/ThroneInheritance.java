package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1600;

import java.util.*;

/**
 * @author Stellagosa
 * @description 王位继承顺序
 * @date 2024/4/7 8:28 星期日
 */
public class ThroneInheritance {
    private final Map<String, Node> map;
    private final String king;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        map = new HashMap<>();
        map.put(kingName, new Node(kingName));
    }

    public void birth(String parentName, String childName) {
        Node parentNode = map.get(parentName);
        if (parentNode.children == null) {
            parentNode.children = new ArrayList<>();
        }
        parentNode.children.add(childName);
        map.put(childName, new Node(childName));
    }

    public void death(String name) {
        map.get(name).dead = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(this.king, result);
        return result;
    }

    private void dfs(String name, List<String> result) {
        Node node = map.get(name);
        if (!node.dead) {
            result.add(node.name);
        }
        if (node.children == null) return;
        for (String child : node.children) {
            dfs(child, result);
        }
    }


    public static class Node {
        String name;
        List<String> children;
        boolean dead;

        Node() {
        }

        Node(String name, List<String> children, boolean dead) {
            this.name = name;
            this.children = children;
            this.dead = dead;
        }

        Node(String name) {
            this(name, null, false);
        }
    }
}
