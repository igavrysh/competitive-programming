// https://github.com/igavrysh

package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice2Linear {
    public int[][] merge(int[][] intervals) {
        sort(intervals);

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

    private void sort(int[][] intervals) {
        int n = intervals.length;
        int min = intervals[0][0];
        int max = intervals[0][0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }
        // fq[i].get(0) = end of first interval that starts with i
        // fq[i].get(1) = end of second interval that starts with i
        // fq[i].get(2) = end of third interval that starts with i
        // ...
        List<Integer>[] fq = new List[max-min+1];
        for (int i = 0; i < n; i++) {
            int val = intervals[i][0]-min;
            if (fq[val] == null) {
                fq[val] = new ArrayList<Integer>();
            } 
            fq[val].add(intervals[i][1]);
        }

        int idx = 0;
        for (int i = 0; i < fq.length; i++) {
            if (fq[i] == null) {
                continue;
            }
            List<Integer> l = fq[i];
            int j = 0;
            while (j < l.size()) {
                intervals[idx][0] = i+min;
                intervals[idx][1] = l.get(j);
                j++;
                idx++;
            }
        }
    }
}
