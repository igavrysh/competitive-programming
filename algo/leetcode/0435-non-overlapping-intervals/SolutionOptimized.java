import java.util.Arrays;

public class SolutionOptimized {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        int output = 0;
        int currEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= currEnd) {
                currEnd = intervals[i][1];
            } else {
                output++;
            }
        }
        return output;
    }
}
