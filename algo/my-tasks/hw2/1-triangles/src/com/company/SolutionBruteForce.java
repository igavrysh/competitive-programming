package com.company;

public class SolutionBruteForce {
    public double longestPerimeter(int[][] points) {
        int N = points.length;
        double maxPerimeter = 0;
        double perimeter = 0;
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                for (int k=j+1; k<N; k++) {
                    perimeter = distance(points[i], points[j]) 
                        + distance(points[j], points[k])
                        + distance(points[i], points[k]);
                    if (perimeter > maxPerimeter) {
                        maxPerimeter = perimeter;
                    }
                }
            }
        }
        return maxPerimeter;
    }

    private double distance(int[] p1, int[] p2) {
        return Math.sqrt(
            Math.pow(Math.abs(p1[0] - p2[0]), 2) 
            + Math.pow(Math.abs(p1[1] - p2[1]), 2));
    }
}
