package com.company;

public class SolutionRecursiveMemoization {
    public int numDistinct(String s, String t) {
        int[][] DP = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                DP[i][j] = -1;
            }
        }
        return num(0, 0, s, t, DP);
    }

    private int num(int iS, int iT, String s, String t, int[][] DP) {
        if (iT == t.length()) {
            DP[iS][iT] = 1;
            return 1;
        }

        if (iS == s.length()) {
            DP[iS][iT] = 0;
            return 0;
        }

        int result = 0; 
        if (t.charAt(iT) == s.charAt(iS)) {
            result += DP[iS+1][iT+1] != -1 ? DP[iS+1][iT+1] : num(iS+1, iT+1, s, t, DP);
        }
        result += DP[iS+1][iT] != -1 ? DP[iS+1][iT] : num(iS+1, iT, s, t, DP);

        DP[iS][iT] = result;

        return result;
    }
}

