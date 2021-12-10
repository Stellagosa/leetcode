package com.stellagosa.leetcode.leetcode101_1000.leetcode_721;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:58
 */
public class Solution {

//    [["John","johnsmith@mail.com","john_newyork@mail.com"],
//    ["John","johnsmith@mail.com","john00@mail.com"],
//    ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]

//    [["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],
//    ["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],
//    ["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],
//    ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],
//    ["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]

//    {{"David", "David0@m.co", "David1@m.co"},
//    {"David", "David3@m.co", "David4@m.co"},
//    {"David", "David4@m.co", "David5@m.co"},
//    {"David", "David2@m.co", "David3@m.co"},
//    {"David", "David1@m.co", "David2@m.co"}};

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        String[][] strings = new String[][]
                {{"David", "David0@m.co", "David1@m.co"},
                        {"David", "David3@m.co", "David4@m.co"},
                        {"David", "David4@m.co", "David5@m.co"},
                        {"David", "David2@m.co", "David3@m.co"},
                        {"David", "David1@m.co", "David2@m.co"}};

        for (String[] string : strings) {
            List<String> list = new ArrayList<>();
            Collections.addAll(list, string);
            accounts.add(list);
        }

        Solution solution = new Solution();
        List<List<String>> lists = solution.accountsMerge(accounts);
        System.out.println(lists);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }

        return merged;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}

