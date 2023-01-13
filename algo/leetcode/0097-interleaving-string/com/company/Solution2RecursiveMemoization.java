package com.company;

class Solution2RecursiveMemoization {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] DP = new Boolean[s1.length()+1][s2.length()+1];
        return helper(0, 0, DP, s1, s2, s3);
    }

    private boolean helper(int s1I, int s2I, Boolean[][] DP, String s1, String s2, String s3) {
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
            if (helper(s1I+1, s2I, DP, s1, s2, s3)) {
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
            if (helper(s1I, s2I+1, DP, s1, s2, s3)) {
                DP[s1I][s2I] = true;
                return true;
            }
        }
        
        DP[s1I][s2I] = false;
        return false;
    }
}