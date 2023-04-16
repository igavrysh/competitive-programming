package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice2 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> l = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            l.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && newInterval[1] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        l.add(newInterval);

        while (i < intervals.length) {
            l.add(intervals[i]);
            i++;
        }

        int[][] output = new int[l.size()][2];
        for (i = 0; i < l.size(); i++) {
            output[i] = l.get(i);
        }

        return output;
    }
}
