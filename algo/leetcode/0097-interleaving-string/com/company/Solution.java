package com.company;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] DP = new Boolean[s1.length()+1][s2.length()+1];
        return helper(s1, s2, s3, 0, 0, DP);
    }

    private boolean helper(String s1, String s2, String s3, int s1I, int s2I,
        Boolean[][] DP) {
        if (DP[s1I][s2I] != null) {
            return DP[s1I][s2I];
        }

        int s3I = s1I + s2I;

        if (s1I >= s1.length() && s2I >= s2.length() && s3I >= s3.length()) {
            return true;
        }

        if (DP[s1I][s2I] != null) {
            return DP[s1I][s2I];
        }

        if (s1I < s1.length() && s3I < s3.length() 
            && s1.charAt(s1I) == s3.charAt(s3I)
        ) {
            if (helper(s1, s2, s3, s1I+1, s2I, DP)) {
                DP[s1I][s2I] = true;
                return true;
            }
        }

        if (DP[s1I][s2I] != null) {
            return DP[s1I][s2I];
        }

        if (s2I < s2.length() && s3I < s3.length() 
            && s2.charAt(s2I) == s3.charAt(s3I)
        ) {
            if (helper(s1, s2, s3, s1I, s2I+1, DP)) {
                DP[s1I][s2I] = true;
                return true;
            }
        }
        
        DP[s1I][s2I] = false;
        return false;
    }
}