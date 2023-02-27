package com.company;

public class SolutionBS {
    public int characterReplacement(String s, int k) {
        int low = 1;   // length l satifies condition, e.g. after max k replacement, string with length l which is substring of s has all the same chars
        int high = s.length()+1; // length h does not satisfy condition, e.g. any change in max k chars does not make any substr of s to have the same chars
        while (high-low>1) {
            int m = low+(high-low)/2;
            if (validReplacement(m, s, k)) {
                low=m;
            } else {
                high=m;
            }
        }
        return low;
    }

    private boolean validReplacement(int length, String s, int k) {
        int[] M = new int[26];
        int maxFq = 0;
        for (int end = 0; end < s.length(); end++) {
            M[s.charAt(end)-'A']++;
            if (end-length>=0) {
                M[s.charAt(end-length)-'A']--;
            }
            maxFq = Math.max(maxFq, M[s.charAt(end)-'A']);
            if (length-maxFq<=k) {
                return true;
            }
        }
        return false;
    }
}
