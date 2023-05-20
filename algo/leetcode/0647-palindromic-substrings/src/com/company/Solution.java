package com.company;

public class Solution {
    public int countSubstrings(String s) {
        boolean[][] DP = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            DP[i][i] = true;
            result++;
        }
        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j - 1) == s.charAt(j)) {
                DP[j - 1][j] = true;
                result++;
            }
        }
        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i < s.length() - j; i++) {
                int start = i;
                int end = i + j;
                if (DP[start + 1][end - 1] == true && s.charAt(start) == s.charAt(end)) {
                    DP[start][end] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
