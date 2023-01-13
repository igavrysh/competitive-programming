package com.company;

public class Solution1Recursive {
    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(0, 0, s1, s2, s3);
    }

    private boolean helper(int s1I, int s2I, String s1, String s2, String s3) {
        int s3I = s1I + s2I;

        if (s1I >= s1.length() && s2I >= s2.length() && s3I >= s3.length()) {
            return true;
        }

        if (s1I < s1.length() && s3I < s3.length() 
            && s1.charAt(s1I) == s3.charAt(s3I)
        ) {
            if (helper(s1I+1, s2I, s1, s2, s3)) {
                return true;
            }
        }

        if (s2I < s2.length() && s3I < s3.length() 
            && s2.charAt(s2I) == s3.charAt(s3I)
        ) {
            if (helper(s1I, s2I+1, s1, s2, s3)) {
                return true;
            }
        }
        
        return false;
    }
}
