package com.stellagosa.leetcode.leetcode1_99.leetcode_71;

import java.util.LinkedList;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/6 13:33
 * @Description: 简化路径
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        LinkedList<String> deque = new LinkedList<>();
        for (String s : paths) {
            switch (s) {
                case ".":
                case "":
                    //do nothing
                    break;
                case "..":
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    }
                    break;
                default:
                    deque.addLast(s);
                    break;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        for (String str : deque) {
            builder.append(str).append("/");
        }
        if (builder.length() == 1) return builder.toString();
        else return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
