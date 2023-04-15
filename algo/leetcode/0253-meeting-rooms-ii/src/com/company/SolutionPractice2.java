package com.company;

import java.util.Arrays;

public class SolutionPractice2 {

    public int minMeetingRooms(int[][] intervals) {
        int[][] events = new int[2*intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            events[2*i] = new int[] { intervals[i][0], 1};
            events[2*i+1] = new int[] { intervals[i][1], -1};
        }

        Arrays.sort(events, (e1, e2) -> e1[0] - e2[0]);
        int maxRooms = 0;
        int runningSum = 0;
        for (int i = 0; i < events.length; i++) {
            int acc = 0, j = 0;
            while (i+j<events.length && events[i+j][0] == events[i][0]) {
                acc += events[i+j][1];
                j++;
            }
            runningSum += acc;
            maxRooms = Math.max(maxRooms, runningSum);
            i = i+j-1;
        }
        return maxRooms;
    }
}
