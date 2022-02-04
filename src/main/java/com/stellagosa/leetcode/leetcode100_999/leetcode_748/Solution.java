package com.stellagosa.leetcode.leetcode100_999.leetcode_748;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/10 11:07
 * @Description: 最短补全词
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String lincensePlate = "OgEu755";
        String[] words = new String[]{"enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus" };
        String word = solution.shortestCompletingWord(lincensePlate, words);
        System.out.println(word);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] arr = new int[26];
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a']++;
            }
        }

        int len = 16;
        String res = "";

        for (String word : words) {
            if (!res.equals("")) {
                if (word.length() > len) continue;
            }
            int[] target = new int[26];
            boolean ok = true;
            for (char ch : word.toCharArray()) {
                target[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (target[i] < arr[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                if (word.length() < len) {
                    len = word.length();
                    res = word;
                }
            }
        }
        return res;
    }

//    public String shortestCompletingWord(String licensePlate, String[] words) {
//        Map<Character, Integer> map = count(licensePlate.toLowerCase());
//        int len = 16;
//        String res = "";
//
//        for (String word : words) {
//            if (!res.equals("")) {
//                //说明已经确定一个匹配结果了，而word的长度大于前面的匹配结果，就不用比较了
//                if (word.length() >= len) continue;
//            }
//            Map<Character, Integer> target = count(word);
//            boolean ok = true;
//            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                Character key = entry.getKey();
//                Integer value = entry.getValue();
//                if (target.getOrDefault(key, 0) < value) {
//                    ok = false;
//                    break;
//                }
//            }
//            if (ok) {
//                if (word.length() < len) {
//                    res = word;
//                    len = word.length();
//                }
//            }
//        }
//        return res;
//    }
//
//    // 统计 String 中各个字母的个数
//    private Map<Character, Integer> count(String str) {
//        Map<Character, Integer> map = new HashMap<>();
//        // 统计各个字母个数
//        for (char ch : str.toCharArray()) {
//            if (ch >= 'a' && ch <= 'z') {
//                map.merge(ch, 1, Integer::sum);
//            }
//        }
//        return map;
//    }

}
