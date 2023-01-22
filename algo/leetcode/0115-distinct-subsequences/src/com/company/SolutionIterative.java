package com.company;

public class SolutionIterative {
    public int numDistinct(String s, String t) {
        int[][] DP = new int[s.length()+1][t.length()+1];
        for (int iS = 0; iS < DP.length; iS++) {
            for (int iT = 0; iT < DP[0].length; iT++) {
                if (iT == 0) {
                    DP[iS][iT] = 1;
                } else {
                    DP[iS][iT] = (iS > 0 && iT > 0 && s.charAt(iS-1) == t.charAt(iT-1) ? DP[iS-1][iT-1] : 0)
                        + (iS > 0 ? DP[iS-1][iT] : 0);
                }
            }
        }
        return DP[DP.length-1][DP[0].length-1];
    }
}
