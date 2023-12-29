import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

class Solution {

    public static class Point {
        public int x;
        public int height;
        public boolean isStarting;

        public Point(int x, int height, boolean isStarting) {
            this.x = x;
            this.height = height;
            this.isStarting = isStarting;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int N = buildings.length;
        Point[] points = new Point[2*N];
        for (int i = 0; i < N; i++) {
            points[2*i] = new Point(buildings[i][0], buildings[i][2], true);
            points[2*i+1] = new Point(buildings[i][1], buildings[i][2], false);
        }

        Arrays.sort(points, (Point p1, Point p2) -> {
            if (Integer.compare(p1.x, p2.x) != 0) {
                return Integer.compare(p1.x, p2.x);
            }

            if (p1.isStarting && p2.isStarting) {
                return p1.height >= p2.height ? -1 : 1;
            }

            if (!p1.isStarting && !p2.isStarting) {
                return p1.height <= p2.height ? -1 : 1;
            }

            if (!p1.isStarting && p2.isStarting) {
                return 1;
            }

            if (p1.isStarting && !p2.isStarting) {
                return -1;
            }

            throw new RuntimeException("unreacheable state reached");
        });

        TreeMap<Integer, Integer> q = new TreeMap<>(Comparator.reverseOrder());
        q.put(0, 0);
        int maxHeight = 0;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if (points[i].isStarting) {
                q.compute(points[i].height, (key, value) -> {
                    if (value == null) {
                        return 1;
                    } else {
                        return value+1;
                    }
                });

                Integer height = q.firstKey();
                if (height > maxHeight) {
                    int _i = i, _height = height;
                    result.add(new ArrayList(){{ add(points[_i].x); add(_height); }});
                    maxHeight = height;
                }
            } else {
                Integer prevHeight = q.firstKey();
                q.compute(points[i].height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    } else {
                        return value-1;
                    }
                });

                Integer newHeight = q.firstKey();
                if (prevHeight > newHeight) {
                    maxHeight = newHeight;
                    int _i = i, _newHeight = newHeight;
                    result.add(new ArrayList<>(){{ add(points[_i].x); add(_newHeight); }});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        test3();
        test1();
        test2();
    }

    public static void test3() {
        int[][] buildings = {
            {1,38,219},{2,19,228},{2,64,106},{3,80,65},{3,84,8},
            {4,12,8},{4,25,14},{4,46,225},{4,67,187},{5,36,118},
            {5,48,211},{5,55,97},{6,42,92},{6,56,188},{7,37,42},
            {7,49,78},{7,84,163},{8,44,212},{9,42,125},{9,85,200},
            {9,100,74},{10,13,58},{11,30,179},{12,32,215},{12,33,161},
            {12,61,198},{13,38,48},{13,65,222},{14,22,1},{15,70,222},
            {16,19,196},{16,24,142},{16,25,176},{16,57,114},{18,45,1},
            {19,79,149},{20,33,53},{21,29,41},{23,77,43},{24,41,75},
            {24,94,20},{27,63,2},{31,69,58},{31,88,123},{31,88,146},
            {33,61,27},{35,62,190},{35,81,116},{37,97,81},{38,78,99},
            {39,51,125},{39,98,144},{40,95,4},{45,89,229},{47,49,10},
            {47,99,152},{48,67,69},{48,72,1},{49,73,204},{49,77,117},
            {50,61,174},{50,76,147},{52,64,4},{52,89,84},{54,70,201},
            {57,76,47},{58,61,215},{58,98,57},{61,95,190},{66,71,34},
            {66,99,53},{67,74,9},{68,97,175},{70,88,131},{74,77,155},
            {74,99,145},{76,88,26},{82,87,40},{83,84,132},{88,99,99}
        };
        int[][] expectedOutputA = {
            {1,219},{2,228},{19,225},{45,229},{89,190},
            {95,175},{97,152},{99,74},{100,0}
        };
        List<List<Integer>> expectedOutput = transform(expectedOutputA);
        Solution sol = new Solution();
        List<List<Integer>> output = sol.getSkyline(buildings);
        boolean passed = match(output, expectedOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int[][] expectedOutputA = {{2,10},{3,15},{7,12},{12,0},{15,10},{20,8},{24,0}};
        List<List<Integer>> expectedOutput = transform(expectedOutputA);
        Solution sol = new Solution();
        List<List<Integer>> output = sol.getSkyline(buildings);
        boolean passed = match(output, expectedOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] buildings = {{0,2,3},{2,5,3}};
        int[][] expectedOutputA = {{0,3},{5,0}};
        List<List<Integer>> expectedOutput = transform(expectedOutputA);
        Solution sol = new Solution();
        List<List<Integer>> output = sol.getSkyline(buildings);
        boolean passed = match(output, expectedOutput);
        System.out.println("test12 " + (passed ? "passed" : "failed"));
    }

    public static boolean match(List<List<Integer>> output, List<List<Integer>> expectedOutput) {
        boolean matched = true;
        matched = output.size() == expectedOutput.size();
        if (matched) {
            for (int i = 0; i < output.size(); i++) {
                for (int j = 0; j < output.get(i).size(); j++) {
                    if (!output.get(i).get(j).equals(expectedOutput.get(i).get(j))) {
                        matched = false;
                        break;
                    }
                }
                if (!matched) {
                    break;
                }
            }
        }
        return matched;
    }

    public static List<List<Integer>> transform(int[][] a) {
        return new ArrayList<>(){{
            for (int i = 0; i < a.length; i++) {
                int _i = i;
                add(new ArrayList<Integer>(){{
                    for (int j = 0; j < a[_i].length; j++) {
                        add(a[_i][j]);
                    }
                }});
            }
        }};
    }
}
