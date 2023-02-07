package com.company;

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        char[] chrs = s.toLowerCase().toCharArray();
        int l = 0, r = chrs.length-1;
        while (l < r) {
            if (!isAlpabetical(chrs[l])) {
                l++;
                continue;
            }
            if (!isAlpabetical(chrs[r])) {
                r--;
                continue;
            }
            if (chrs[l] != chrs[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlpabetical(char c) {
        return (c-'a'>=0 && c-'a' < 26) || (c-'0' >= 0 && c-'0' <= 9);
    }
}