package com.stellagosa.leetcode.leetcode1_99.leetcode_49;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/1 6:21
 * @Description: 字母异位词分组
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = solution.groupAnagrams(strs);
        for (List<String> strings : list) {
            for (String item : strings) {
                System.out.printf("%s\t", item);
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }
}
