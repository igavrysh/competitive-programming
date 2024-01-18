import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionSlightImprv {
    public int mostBooked(int n, int[][] meetings) {
	    Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
		int[] fq = new int[n];
		PriorityQueue<long[]> Q = new PriorityQueue<>(
            (a, b) -> a[1] == b[1] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>(Integer::compare);
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        //int max_fq = 0;
		//int max_fq_room = -1;

		for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            while (!Q.isEmpty() && Q.peek()[1] <= start) {
                long[] freed = Q.remove();
                availableRooms.offer((int)freed[0]);
            }
            
            if (!availableRooms.isEmpty()) {
                int idRoom = availableRooms.remove();
                Q.offer(new long[]{idRoom, end});
                fq[idRoom]++;

                /* 
                // not worth optimization - spending cpu branching time on every meeting out of 5x10^5 meetings
                // its cheeper to go 0..100 in fqmap in the end
                int newFq = fq[idRoom];
                if (newFq > max_fq || (newFq == max_fq && idRoom < max_fq_room)) {
                    max_fq = fq[idRoom];
                    max_fq_room = idRoom;
                }
                */

            } else {
                long[] earliestFree = Q.remove();
                long endTime = earliestFree[1] + (end - start);
                int idRoom = (int)earliestFree[0];
                Q.offer(new long[]{idRoom, endTime});
                fq[idRoom]++;

                /* 
                int newFq = fq[idRoom];
                if (newFq > max_fq || (newFq == max_fq && idRoom < max_fq_room)) {
                    max_fq = fq[idRoom];
                    max_fq_room = idRoom;
                }
                */
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
