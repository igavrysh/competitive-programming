package com.company;

public class Solution {
    public String longestPalindrome(String s) {
        String[] output = new String[1];
        output[0] = "";
        for (int i = 0; i < s.length(); i++) {
            longestPalindromeInternal(s, i, i + 1, output);
            longestPalindromeInternal(s, i, i, output);
        }
        return output[0];
    }

    private void longestPalindromeInternal(String s, int start, int end, String[] output) {
        if (start < 0 || end >= s.length()) {
            return;
        }
        if (s.charAt(start) == s.charAt(end)) {
            if (output[0].length() < end + 1 - start) {
                output[0] = s.substring(start, end + 1);
            }
            longestPalindromeInternal(s, start - 1, end + 1, output);
        }
    }

}
