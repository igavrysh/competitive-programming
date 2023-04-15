import java.util.Arrays;
import java.util.List;

public class Solution {

    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[][] events = new int[2*n][2];
        for (int i = 0; i < n; i++) {
            events[2*i] = new int[] { intervals.get(i).start, 1 };
            events[2*i+1] = new int[] { intervals.get(i).end, -1 };
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
