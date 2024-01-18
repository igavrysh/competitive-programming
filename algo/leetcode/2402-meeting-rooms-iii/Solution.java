import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;;

class Solution {
	public int mostBooked(int n, int[][] meetings) {
	    Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		int[] fq = new int[n];
		int max_fq = 0;
		int max_fq_room = -1;
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
                if (newFq > max_fq || (newFq == max_fq && idRoom < max_fq_room)) {
                    max_fq = fq[idRoom];
                    max_fq_room = idRoom;
                }
            } else {
                long[] earliestFree = Q.remove();
                availableRooms.add((int)earliestFree[0]);
                long endTime = earliestFree[1] + (meetings[i][1] - meetings[i][0]);

                int idRoom = availableRooms.remove();
                Q.offer(new long[]{idRoom, endTime});
                fq[idRoom]++;
                int newFq = fq[idRoom];
                if (newFq > max_fq || (newFq == max_fq && idRoom < max_fq_room)) {
                    max_fq = fq[idRoom];
                    max_fq_room = idRoom;
                }
            }
        }
        return max_fq_room;
    }

    public static void main(String[] args) {
        test5();
        test4();
        test3();
        test1();
        test2();
        /*
        PriorityQueue<int[]> Q = new PriorityQueue<>(
            (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        Q.offer(new int[]{0,2});
        Q.offer(new int[]{0,1});
        int[] p1 = Q.remove();
        int[] p2 = Q.remove();
        Q.offer(new int[]{2,3});
        Q.offer(new int[]{1,3});
        Q.offer(new int[]{3,3});
        int[] p1_1 = Q.remove();
        int[] p1_2 = Q.remove();
        int[] p1_3 = Q.remove();
        */
    }

    public static void test1() {
        int n = 2;
        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        int expOutput = 0;
        Solution sol = new Solution();
        int output = sol.mostBooked(n, meetings);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int n = 3;
        int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        int expOutput = 1;
        Solution sol = new Solution();
        int output = sol.mostBooked(n, meetings);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int n = 4;
        int[][] meetings = {{18,19},{3,12},{17,19},{2,13},{7,10}};
        int expOutput = 0;
        Solution sol = new Solution();
        int output = sol.mostBooked(n, meetings);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        int[][] meetings = null;
        String filePath = "input2";
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                // Splitting the line by comma
                String[] data = line.split(csvSplitBy);
                meetings = new int[data.length/2][2];
                for (int i = 0; i < meetings.length; i++) {
                    meetings[i] = new int[]{Integer.valueOf(data[i*2]), Integer.valueOf(data[i*2+1])};
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int n = 10;
        int expOutput = 1;
        Solution sol = new Solution();
        int output = sol.mostBooked(n, meetings);
        boolean passed = output == expOutput;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int[][] meetings = null;
        String filePath = "input1";
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                // Splitting the line by comma
                String[] data = line.split(csvSplitBy);
                meetings = new int[data.length/2][2];
                for (int i = 0; i < meetings.length; i++) {
                    meetings[i] = new int[]{Integer.valueOf(data[i*2]), Integer.valueOf(data[i*2+1])};
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int n = 10;
        int expOutput = 1;
        Solution sol = new Solution();
        int output = sol.mostBooked(n, meetings);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}

