package com.company;

public class SolutionBruteForce {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        int N = s.length();
        int output = 0;
        while (r<N) {
            boolean isGood = isGood(l, r, s, k);
            if (isGood || l==r) {
                if (isGood) {
                    output = Math.max(output, r-l+1);
                }
                r++;
            } else {
                l++;
            }
        }
        return output;
    }

    private boolean isGood(int l, int r,  String s, int k) {
        int[] FQ = new int[26];
        int maxFQ = 0;
        for (int i=l; i<=r; i++) {
            int idx = s.charAt(i)-'A';
            FQ[idx]++;
            maxFQ=Math.max(maxFQ, FQ[idx]);
        }
        return ((r-l+1)-maxFQ)<=k;
    }
}