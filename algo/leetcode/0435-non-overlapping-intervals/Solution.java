import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // DP[0] = right edge of intervals 
        // DP[1] = number of erased overallping intervals for all intervals ending up to DP[0]
        List<int[]> DP = new ArrayList<>(); 
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        List<int[]> core = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            PriorityQueue<int[]> PQ = new PriorityQueue<>((i1, i2) -> (i2[1] - i2[0]) - (i1[1] - i1[0]));
            PQ.add(intervals[i]);
            while (i+1<n && intervals[i+1][1] == intervals[i][1]) {
                PQ.add(intervals[i+1]);
                i++;
            }

            int acc = 0;
            while (PQ.size() > 0) {
                int[] t = PQ.poll();
                
                if (core.size() > 0) {
                    int[] coreInt = core.get(core.size()-1);
                    if (coreInt[1] > t[0]) {
                        acc++;
                    } else {
                        core.add(t);
                    }
                } else {
                    core.add(t);
                }
            }

            DP.add(new int[]{ intervals[i][1], (DP.isEmpty() ? 0 : DP.get(DP.size()-1)[1]) + acc});
        }

        return DP.get(DP.size()-1)[1];
    }
}
