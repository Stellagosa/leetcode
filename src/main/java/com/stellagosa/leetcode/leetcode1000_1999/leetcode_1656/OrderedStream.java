package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1656;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/16 8:22
 * @Description: 设计有序流
 */
public class OrderedStream {

    String[] arr;

    int ptr;

    public OrderedStream(int n) {
        arr = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        arr[idKey] = value;
        if (idKey == ptr) {
            while (ptr != arr.length && arr[ptr] != null) {
                res.add(arr[ptr]);
                ptr++;
            }
        }
        return res;
    }

    // Map<Integer, String> map;
    //
    // int ptr;
    //
    // public OrderedStream(int n) {
    //     map = new HashMap<>(n * 3 / 2);
    //     ptr = 1;
    // }
    //
    // public List<String> insert(int idKey, String value) {
    //     List<String> res = new ArrayList<>();
    //     map.put(idKey, value);
    //     if (idKey == ptr) {
    //         while (true) {
    //             String str = map.get(ptr);
    //             if (str == null) break;
    //             res.add(str);
    //             ptr++;
    //         }
    //     }
    //     return res;
    // }

}
