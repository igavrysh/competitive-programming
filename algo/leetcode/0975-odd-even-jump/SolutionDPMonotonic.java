import java.util.Arrays;
import java.util.Stack;

class SolutionDPMonotonic {

    public int oddEvenJumps(int[] arr) {
        
        int n = arr.length;

        Integer[][] valIdxAsc = new Integer[n][2];
        Integer[][] valIdxDesc = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            valIdxAsc[i] = new Integer[] {arr[i], i};
            valIdxDesc[i] = new Integer[] {arr[i], i};
        }

        Arrays.sort(valIdxAsc, (valIdx1, valIdx2) -> valIdx2[0] == valIdx1[0] ? valIdx1[1] - valIdx2[1] : valIdx1[0] - valIdx2[0]);
        Arrays.sort(valIdxDesc, (valIdx1, valIdx2) -> valIdx1[0] == valIdx2[0] ? valIdx1[1] - valIdx2[1] : valIdx2[0] - valIdx1[0]);

        // indexes of next smallest greater than current index
        int[] nxtSmallestGreaterThan = new int[n];
        Stack<Integer[]> S1 = new Stack<>();
             
        // indexes of next largest smaller than current index
        int[] nxtLargestSmallerThan = new int[n];
        Stack<Integer[]> S2 = new Stack<>();

        for (int i=0; i<n; i++) {
            while (!S1.isEmpty() && S1.peek()[1] < valIdxAsc[i][1]) {
                Integer[] pair = S1.pop();
                nxtSmallestGreaterThan[pair[1]] = valIdxAsc[i][1];
            }
            S1.push(valIdxAsc[i]);


            while (!S2.isEmpty() && S2.peek()[1] < valIdxDesc[i][1]) {
                Integer[] pair = S2.pop();
                nxtLargestSmallerThan[pair[1]] = valIdxDesc[i][1];
            }
            S2.push(valIdxDesc[i]);
        }

        while (!S1.isEmpty()) {
            nxtSmallestGreaterThan[S1.pop()[1]] = -1;
        }

        while (!S2.isEmpty()) {
            nxtLargestSmallerThan[S2.pop()[1]] = -1;
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
        SolutionDPMonotonic s = new SolutionDPMonotonic();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] arr = {2,3,1,1,4};
        int expOutput = 3;
        SolutionDPMonotonic s = new SolutionDPMonotonic();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] arr = {5,1,3,4,2};
        int expOutput = 3;
        SolutionDPMonotonic s = new SolutionDPMonotonic();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}