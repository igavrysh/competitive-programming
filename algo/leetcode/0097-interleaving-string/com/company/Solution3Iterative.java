package com.company;

public class Solution3Iterative {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] DP = new Boolean[s1.length()+1][s2.length()+1];
        DP[0][0] = true;

        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                if (i == 0 && i == j) {
                    continue;
                }

                Boolean result = null;

                if (i-1>=0 && DP[i-1][j] != null && DP[i-1][j] == true) {
                    if (i-1>=0 && (i-1+j) < s3.length()) {
                        result = s1.charAt(i-1) == s3.charAt(i-1+j);
                    }
                }

                if (result == null || (result != null && result == false)) {
                    if (j-1>= 0 && DP[i][j-1] != null && DP[i][j-1] == true) {
                        if (j-1>=0 && (i+j-1) < s3.length()) {
                            result = s2.charAt(j-1) == s3.charAt(i+j-1);
                        }
                    }
                }

                DP[i][j] = result;
            }
        }
        
        if (DP[s1.length()][s2.length()] != null) {
            return DP[s1.length()][s2.length()];
        }

        return false;
    }
}
