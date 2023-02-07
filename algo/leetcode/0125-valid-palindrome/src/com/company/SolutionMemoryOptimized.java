package com.company;

public class SolutionMemoryOptimized {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int l = 0, r = s.length()-1;
        while (l < r) {
            char lCh = s.charAt(l);
            char rCh = s.charAt(r);

            if (!Character.isLetterOrDigit(lCh)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(rCh)) {
                r--;
                continue;
            }
            if (Character.toLowerCase(lCh) != Character.toLowerCase(rCh)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlpabetical(char c) {
        return (c-'A'>=0 && c-'A' < 26) || (c-'a'>=0 && c-'a' < 26) || (c-'0' >= 0 && c-'0' <= 9);
    }
}
