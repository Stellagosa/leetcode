package com.stellagosa.leetcode.leetcode_1220;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/17 10:05
 * @Description: 统计元音字母序列的数目
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelPermutation(158));
    }

    public int countVowelPermutation(int n) {
        int mod = 1000000007;
        int aPre = 1, ePre = 1, iPre = 1, oPre = 1, uPre = 1;
        int a = 1, e = 1, i = 1, o = 1, u = 1;

        while (n-- > 1) {
            a = ePre;
            e = (aPre + iPre) % mod;
            i = ((aPre + ePre) % mod + (oPre + uPre) % mod) % mod;
            o = (iPre + uPre) % mod;
            u = aPre;
            aPre = a;
            ePre = e;
            iPre = i;
            oPre = o;
            uPre = u;
        }
        return (((a + e) % mod + (i + o) % mod) % mod + u) % mod;
    }

    // public int countVowelPermutation(int n) {
    //     int mod = 1000000007;
    //     int[] aBegin = new int[n];
    //     int[] eBegin = new int[n];
    //     int[] iBegin = new int[n];
    //     int[] oBegin = new int[n];
    //     int[] uBegin = new int[n];
    //     aBegin[0] = 1;
    //     eBegin[0] = 1;
    //     iBegin[0] = 1;
    //     oBegin[0] = 1;
    //     uBegin[0] = 1;
    //
    //     for (int i = 1; i < n; i++) {
    //         aBegin[i] = eBegin[i - 1];
    //         eBegin[i] = (aBegin[i - 1] + iBegin[i - 1]) % mod;
    //         iBegin[i] = ((aBegin[i - 1] + eBegin[i - 1]) % mod + (oBegin[i - 1] + uBegin[i - 1]) % mod) % mod;
    //         oBegin[i] = (iBegin[i - 1] + uBegin[i - 1]) % mod;
    //         uBegin[i] = aBegin[i - 1];
    //     }
    //     return (((aBegin[n - 1] + eBegin[n - 1]) % mod + (iBegin[n - 1] + oBegin[n - 1]) % mod) %mod + uBegin[n - 1]) % mod;
    // }
}

// aBegin[n] = eBegin[n-1];
// eBegin[n] = aBegin[n-1]+iBegin[n-1]
// iBegin[n] = aBegin[n-1]+eBegin[n-1]+oBegin[n-1]+uBegin[n-1]
// oBegin[n] = iBegin[n-1]+uBegin[n-1]
// uBegin[n] = aBegin[n-1]
