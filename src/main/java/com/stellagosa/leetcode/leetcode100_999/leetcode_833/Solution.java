package com.stellagosa.leetcode.leetcode100_999.leetcode_833;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/15 8:26
 * @Description: 字符串中的查找与替换
 */
public class Solution {

    public static void main(String[] args) {
        int[] indices = {0, 2};
        String[] sources = {"ab", "cd"};
        String[] targets = {"eee", "fff"};
        String s = "abcd";
        Solution solution = new Solution();
        System.out.println(solution.findReplaceString(s, indices, sources, targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int len = s.length();
        int[] arr = new int[len];
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                arr[indices[i]] = i + 1;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                builder.append(targets[arr[i] - 1]);
                i += sources[arr[i] - 1].length() - 1;
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    // public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    //     Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    //     for (int i = 0; i < indices.length; i++) {
    //         queue.offer(new int[]{indices[i], i});
    //     }
    //     StringBuilder builder = new StringBuilder();
    //     int len = s.length();
    //     int pos = 0;
    //     while (!queue.isEmpty()) {
    //         int[] poll = queue.poll();
    //         String source = sources[poll[1]];
    //         int index = poll[0];
    //         while (pos < len && pos < index) {
    //             builder.append(s.charAt(pos));
    //             pos++;
    //         }
    //         boolean flag = false;
    //         for (int i = 0; i < source.length(); i++) {
    //             if (i + index > len - 1 || s.charAt(i + index) != source.charAt(i)) {
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //         if (!flag) {
    //             builder.append(targets[poll[1]]);
    //             pos += source.length();
    //         }
    //     }
    //     while (pos < len) {
    //         builder.append(s.charAt(pos));
    //         pos++;
    //     }
    //
    //     return builder.toString();
    // }

    // public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    //     int k = indices.length;
    //     // indices 下标的排序
    //     int[] array = IntStream.range(0, k).boxed().sorted(Comparator.comparingInt(o -> indices[o])).mapToInt(Integer::intValue).toArray();
    //     StringBuilder builder = new StringBuilder();
    //     int len = s.length();
    //     int pos = 0;
    //     for (int i : array) {
    //         int index = indices[i];
    //         String source = sources[i];
    //         while (pos < len && pos < index) {
    //             builder.append(s.charAt(pos));
    //             pos++;
    //         }
    //         boolean flag = false;
    //         for (int j = 0; j < source.length(); j++) {
    //             if (j + index > len - 1 || s.charAt(j + index) != source.charAt(j)) {
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //         if (!flag) {
    //             builder.append(targets[i]);
    //             pos += source.length();
    //         }
    //     }
    //     while (pos < len) {
    //         builder.append(s.charAt(pos));
    //         pos++;
    //     }
    //
    //     return builder.toString();
    // }


}
