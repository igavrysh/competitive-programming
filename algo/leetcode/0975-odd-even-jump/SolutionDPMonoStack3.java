import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SolutionDPMonoStack3 {
    private ArrayList<Integer>[] fq = null;

    private void fillFq(int[] arr) {
        int n = arr.length;
        int min = arr[0], max = arr[0];
        for (int i=0; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        fq = new ArrayList[max-min+1];
        for (int i=0; i<n; i++) {
            int idx = arr[i]-min;
            ArrayList<Integer> l = fq[idx];
            if (fq[idx] == null) {
                l = new ArrayList<>();
                fq[idx] = l;
            }
            l.add(i);
        }
    }

    private void asc(Integer[] dst) {
        int idx = 0;
        for (int i=0; i<fq.length; i++) {
            ArrayList<Integer> l = fq[i];
            if (l == null) {
                continue;
            }
            for (int j=0; j<l.size(); j++) {
                dst[idx++] = l.get(j);
            }
        }
    }

    private void desc(Integer[] dst) {
        int idx = 0;
        for (int i=fq.length-1; i>=0; i--) {
            ArrayList<Integer> l = fq[i];
            if (l == null) {
                continue;
            }
            for (int j=0; j<l.size(); j++) {
                dst[idx++] = l.get(j);
            }
        }
    }

    public int oddEvenJumps(int[] arr) {
        
        int n = arr.length;

        Integer[] idxs = new Integer[n];
        fillFq(arr);

        // mono stack solution
        //Stack<Integer> S = new Stack<>();
        Deque<Integer> S = new ArrayDeque<>();

        asc(idxs);

        // indexes of next smallest greater than current index
        int[] nxtSmallestGreaterThan = new int[n];

        for (int i=0; i<n; i++) {
            while (!S.isEmpty() && S.peek() < idxs[i]) {
                Integer idx = S.pop();
                nxtSmallestGreaterThan[idx] = idxs[i];
            }
            S.push(idxs[i]);
        }
        while (!S.isEmpty()) {
            nxtSmallestGreaterThan[S.pop()] = -1;
        }


        desc(idxs);

        // indexes of next largest smaller than current index
        int[] nxtLargestSmallerThan = new int[n];

        for (int i=0; i<n; i++) {

            while (!S.isEmpty() && S.peek() < idxs[i]) {
                Integer idx = S.pop();
                nxtLargestSmallerThan[idx] = idxs[i];
            }
            S.push(idxs[i]);
        }

        while (!S.isEmpty()) {
            nxtLargestSmallerThan[S.pop()] = -1;
        }

        boolean[][] DP = new boolean[n][2];   //[][0] - even jumps, [][1] - odd jumps
        DP[n-1][0] = true;
        DP[n-1][1] = true;
        int res = 1;
        for (int i = n-2; i >= 0; i--) {
            DP[i][1] = nxtSmallestGreaterThan[i] == -1 ? false : DP[nxtSmallestGreaterThan[i]][0];
            DP[i][0] = nxtLargestSmallerThan[i] == -1 ? false : DP[nxtLargestSmallerThan[i]][1];
            if (DP[i][1]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        test3();
        test2();
        test1();
    }

    public static void test1() {
        int[] arr = {10,13,12,14,15};
        int expOutput = 2;
        SolutionDPMonoStack3 s = new SolutionDPMonoStack3();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] arr = {2,3,1,1,4};
        int expOutput = 3;
        SolutionDPMonoStack3 s = new SolutionDPMonoStack3();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] arr = {5,1,3,4,2};
        int expOutput = 3;
        SolutionDPMonoStack3 s = new SolutionDPMonoStack3();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
