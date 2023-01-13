package com.company;

public class Solution4IterativeOptimized {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[] DP = new Boolean[s2.length()+1];
        DP[0] = true;

        for (int i = 0; i < s1.length()+1; i++) {
            Boolean[] newDP = new Boolean[s2.length()+1];
            for (int j = 0; j < DP.length; j++) {
                if (i == 0 && i == j) {
                    newDP[0] = true;
                    continue;
                }

                Boolean result = null;

                if (i-1>=0 && DP[j] != null && DP[j] == true) {
                    if (i-1>=0 && (i-1+j) < s3.length()) {
                        result = s1.charAt(i-1) == s3.charAt(i-1+j);
                    }
                }

                if (result == null || (result != null && result == false)) {
                    if (j-1>= 0 && newDP[j-1] != null && newDP[j-1] == true) {
                        if (j-1>=0 && (i+j-1) < s3.length()) {
                            result = s2.charAt(j-1) == s3.charAt(i+j-1);
                        }
                    }
                }

                newDP[j] = result;
            }
            DP = newDP;
        }
        
        if (DP[s2.length()] != null) {
            return DP[s2.length()];
        }

        return false;
    }
}
