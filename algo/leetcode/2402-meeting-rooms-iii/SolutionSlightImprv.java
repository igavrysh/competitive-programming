import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionSlightImprv {
    public int mostBooked(int n, int[][] meetings) {
	    Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		int[] fq = new int[n];
		PriorityQueue<long[]> Q = new PriorityQueue<>(
            (a, b) -> a[1] == b[1] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>(Integer::compare);
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
		for (int i = 0; i < meetings.length; i++) {
            while (!Q.isEmpty() && Q.peek()[1] <= meetings[i][0]) {
                long[] freed = Q.remove();
                availableRooms.add((int)freed[0]);
            }
            
            if (availableRooms.size() > 0) {
                int idRoom = availableRooms.remove();
                Q.offer(new long[]{idRoom, meetings[i][1]});
                fq[idRoom]++;
                int newFq = fq[idRoom];
            } else {
                long[] earliestFree = Q.remove();
                availableRooms.add((int)earliestFree[0]);
                long endTime = earliestFree[1] + (meetings[i][1] - meetings[i][0]);

                int idRoom = availableRooms.remove();
                Q.offer(new long[]{idRoom, endTime});
                fq[idRoom]++;
            }
        }

        int max_fq = 0;
        int max_fq_room = -1;
        for (int i = 0; i < n; i++) {
            if (fq[i] > max_fq) {
                max_fq = fq[i];
                max_fq_room = i;
            }
        }
        return max_fq_room;
    }
}
