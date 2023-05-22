package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionRecursiveMemo {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wd = new HashSet<>(wordDict);
        int[] memo = new int[s.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return WB(0, s, wd, memo);
    }

    private boolean WB(int startIndex, String s, Set<String> wordDict, int[] memo) {
        if (memo[startIndex] != -1) {
            if (memo[startIndex] == 0) {
                return false;
            }
            return false;
        }
        if (startIndex >= s.length()) {
            return true;
        }
        boolean result = false;
        for (int i = startIndex; i < s.length(); i++) {
            String subs = s.substring(startIndex, i + 1);
            if (wordDict.contains(subs)) {
                result = WB(i + 1, s, wordDict, memo);
                memo[startIndex] = 1;
                if (result == true) {
                    return true;
                }
            }
        }

        memo[startIndex] = 0;
        return false;
    }
}
