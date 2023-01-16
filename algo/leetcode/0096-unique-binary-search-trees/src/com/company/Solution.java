package com.company;

public class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for (int j = 2; j <= n; j++) {
            int res = 0;
            for (int i = 1; i <= j; i++) {
                res += (i != 1 ? G[i-1] : 1) * (i != n ? G[j-i] : 1);
            }
            G[j] = res;
        }

        return G[n];
    }
}
