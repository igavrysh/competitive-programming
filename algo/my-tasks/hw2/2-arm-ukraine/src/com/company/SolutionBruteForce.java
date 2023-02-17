package com.company;

public class SolutionBruteForce {
    public int numCombinations(int x, int y, int z, int w) {
        int result = 0;
        for (int nX = 0; nX <= 100; nX++) {
            for (int nY = 0; nY <= 100; nY++) {
                for (int nZ = 0; nZ <= 100; nZ++) {
                    if (nX*x + nY*y + nZ*z == w) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
