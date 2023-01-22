package com.company;

public class SolutionIterativeOptimized {
    public int numDistinct(String s, String t) {
        int[] DP = new int[s.length()+1];
        for (int iT = 0; iT < t.length()+1; iT++) {
            int[] cDP = new int[s.length()+1];
            for (int iS = 0; iS < DP.length; iS++) {
                if (iT == 0) {
                    cDP[iS] = 1;
                } else {
                    cDP[iS] = (iS > 0 && iT > 0 && s.charAt(iS-1) == t.charAt(iT-1) ? DP[iS-1] : 0)
                        + (iS > 0 ? cDP[iS-1] : 0);
                }
            }
            DP = cDP;
        }
        return DP[s.length()];
    }  
}
