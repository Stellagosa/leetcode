package com.stellagosa.offer_II.offer_114;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/31 9:49
 * @Description: 外星文字典
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abc","ab"};
        System.out.println(solution.alienOrder(words));
    }

    // TAG 拓扑排序
    public String alienOrder(String[] words) {
        // 存储所有的字符
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
        }

        // 存储有向图
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            int minLen = Math.min(pre.length(), cur.length());
            if (pre.substring(0, minLen).equals(cur.substring(0,minLen)) && pre.length() > cur.length()) return "";

            for (int j = 0; j < minLen; j++) {
                if (pre.charAt(j) != cur.charAt(j)) {
                    Set<Character> characterSet = map.get(pre.charAt(j));
                    if (characterSet == null) {
                        Set<Character> set1 = new HashSet<>();
                        set1.add(cur.charAt(j));
                        map.put(pre.charAt(j), set1);
                    } else {
                        map.get(pre.charAt(j)).add(cur.charAt(j));
                    }
                    // 两个字符串比较只能判断出一条边
                    break;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!map.isEmpty()) {
            // 查找入度为 0 的节点
            Set<Character> temp = new HashSet<>(set);
            for (Set<Character> value : map.values()) {
                for (Character ch : value) {
                    temp.remove(ch);
                }
            }
            if (temp.size() == 0) return "";
            // 将入度为 0 的加入结果集中
            for (Character ch : temp) {
                map.remove(ch);
                set.remove(ch);
                builder.append(ch);
            }
        }

        // 将最后不能判断的字符加入结果集
        for (Character ch : set) {
            builder.append(ch);
        }

        return builder.toString();
    }
}
