package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution2 {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        HashMap<String, HashSet<Integer>> M = new HashMap<>();
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                double slope = (y2 - y1 * 1.0) / (x2 * 1.0 - x1);
                double offset = Double.isInfinite(slope) ? x1 : y1 - (slope*x1) ;
                //slope = (double) Math.round(slope * 100) / 100;
                //double offset = ((x2*y1) - (x1*y2* 1.0)) / ((x2-x1)*(y2-y1) * 1.0);
                //offset = (double) Math.round(offset * 100) / 100;
                String key = slope + "_" + offset;
                HashSet<Integer> m = M.getOrDefault(key, new HashSet<>());

                if (!Double.isInfinite(slope)) {
                    m.add(x1);
                    m.add(x2);
                } else {
                    m.add(y1);
                    m.add(y2);
                }
                M.put(key, m);
            }
        }

        Integer maxPoints = 0;
        for (Map.Entry<String, HashSet<Integer>> entry : M.entrySet()) {
            if (maxPoints < entry.getValue().size()) {
                maxPoints = entry.getValue().size();
            }
        }

        return maxPoints;
    }
}
