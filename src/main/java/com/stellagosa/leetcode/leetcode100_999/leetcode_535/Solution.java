package com.stellagosa.leetcode.leetcode100_999.leetcode_535;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/29 7:07
 * @Description: TinyURL 的加密和解密
 */
public class Solution {

    private Map<Integer, String> map = new HashMap<>();
    private int id;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        map.put(id, longUrl);
        return String.valueOf(id);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer value = Integer.valueOf(shortUrl);
        return map.get(value);
    }
}
