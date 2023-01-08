package com.company;

// null
// ""
// "a"
// "abc"
// "abc dc" 

public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        int startIndex = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (startIndex == -1) {
                    startIndex = i;
                }
            } else { // current char is empty
                if (startIndex != -1) {
                    if (sb.length() > 0) {
                        sb.insert(0, " ");
                    }
                    sb.insert(0, s.substring(startIndex, i));
                    startIndex = -1;
                }
            }
        }

        if (startIndex != -1) {
            if (sb.length() > 0) {
                sb.insert(0, " ");
            }
            sb.insert(0, s.substring(startIndex, s.length()));
        }

        return sb.toString();
    }
}
