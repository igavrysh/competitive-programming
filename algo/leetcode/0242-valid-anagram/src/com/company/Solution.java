package com.company;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { return false; }
        int[] M = new int[26];
        for (char ch : s.toCharArray()) {
            int index = ch-'a';
            M[index] = M[index] + 1;
        }
        for (char ch : t.toCharArray()) {
            if (M[ch-'a'] == 0) {
                return false;
            }
            M[ch-'a']--;
        }
        return true;
    }
}