package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionPractice2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> l = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1]>=intervals[i][0] && curr[0]<=intervals[i][1]) {
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                l.add(curr);
                curr = intervals[i];
            }
        }
        l.add(curr);

        int[][] output = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            output[i] = l.get(i);
        }
        return output;
    }
}
