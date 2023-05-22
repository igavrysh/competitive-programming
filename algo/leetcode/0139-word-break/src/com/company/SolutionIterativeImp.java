package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionIterativeImp {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLength = 0;
        for (String word : wordDict) {
            if (maxLength < word.length()) {
                maxLength = word.length();
            }
        }
        Set<String> wd = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i + 1 - j - 1 > maxLength) {
                    break;
                }
                String t = s.substring(j, i + 1);
                if (wd.contains(t) && (j == 0 || dp[j - 1] == 1)) {
                    dp[i] = 1;
                }
            }
        }
        return dp[s.length() - 1] == 1;
    }
}
