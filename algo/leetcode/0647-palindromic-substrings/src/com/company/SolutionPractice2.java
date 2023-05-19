package com.company;

public class SolutionPractice2 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[] DP = new boolean[n];
        // [0] - length, [1] - start idx, [2] - end idx
        int output = 0;
        boolean[] newDP = new boolean[n];
        for (int end = 0; end < n; end++ ) {
            newDP[end] = true;
            output++;
            for (int start = end-1;  start >=0 ; start--) {
                newDP[start] = (end-1<start+1 ? true : DP[start+1]) 
                    && s.charAt(start) == s.charAt(end);
                if (newDP[start]) {
                    output++;
                
                }
            }
            boolean[] tmp = DP;
            DP = newDP;
            newDP = tmp;
        }
        return output;
    }
}
