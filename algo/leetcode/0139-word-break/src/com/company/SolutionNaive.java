package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionNaive {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wd = new HashSet<>(wordDict);
        return WB(0, s, wd);
    }

    private boolean WB(int startIndex, String s, Set<String> wordDict) {
        if (startIndex >= s.length()) {
            return true;
        }
        boolean result = false;
        for (int i = startIndex; i < s.length(); i++) {
            String subs = s.substring(startIndex, i + 1);
            if (wordDict.contains(subs)) {
                result = WB(i + 1, s, wordDict);
                if (result == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
