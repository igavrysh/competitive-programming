package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Solution {
    class Point {
        public int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }; 
        public Point(int[] p) { this.x = p[0]; this.y = p[1]; }; 
        @Override
        public boolean equals(Object obj) {
            return !(obj instanceof Point) ? false : ((Point)obj).x == x && ((Point)obj).y == y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        HashMap<String, HashSet<Point>> M = new HashMap<>();
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                double slope = (y2 - y1 * 1.0) / (x2 * 1.0 - x1);
                double offset = 0;
                if (Double.isInfinite(slope)) {
                    offset = x1;
                } else {
                    offset = y1- (slope*x1);
                }
                //slope = (double) Math.round(slope * 100) / 100;
                //double offset = ((x2*y1) - (x1*y2* 1.0)) / ((x2-x1)*(y2-y1) * 1.0);
                //offset = (double) Math.round(offset * 100) / 100;
                String key = slope + "_" + offset;
                HashSet<Point> s = M.getOrDefault(key, new HashSet<>());
                s.add(new Point(points[i]));
                s.add(new Point(points[j]));
                M.put(key, s);
            }
        }

        Integer maxPoints = null;
        for (Map.Entry<String, HashSet<Point>> entry : M.entrySet()) {
            if (maxPoints == null) {
                maxPoints = entry.getValue().size();
            } else if (maxPoints < entry.getValue().size()) {
                maxPoints = entry.getValue().size();
            }
        }

        return maxPoints;
    }
}