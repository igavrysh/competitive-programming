package com.company;
import java.util.HashMap;
import java.util.Map;

public class SolutionSlope {
    public int maxPoints(int[][] points) {
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopes = new HashMap<>();
            int currMax = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                double slope = ((double)points[j][1] - points[i][1]) / ((double)points[j][0] - points[i][0]);
                int newAcc = slopes.getOrDefault(slope, 0)+1;
                if (newAcc > currMax) {
                    currMax = newAcc;
                }
                slopes.put(slope, newAcc);
            }
            maxPoints = Math.max(maxPoints, currMax+1);
        }
        return maxPoints;
    }
}
