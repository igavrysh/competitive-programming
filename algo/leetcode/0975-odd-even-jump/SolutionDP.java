public class SolutionDP {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[][] DP = new boolean[n][2];   //[][0] - even jumps, [][1] - odd jumps
        DP[n-1][0] = true;
        DP[n-1][1] = true;
        int res = 1;
        for (int i = n-2; i >= 0; i--) {
            int minLrgerThanI = -1;
            for (int j = n-1; j >= i+1; j--) {
                if (arr[i] <= arr[j] && (minLrgerThanI == -1 || arr[j] <= arr[minLrgerThanI])) {
                    minLrgerThanI = j;
                }
            }

            int minSmllerThanI = -1;
            for (int j = n-1; j >= i+1; j--) {
                if (arr[i] >= arr[j] && (minSmllerThanI == -1 || arr[j] >= arr[minSmllerThanI])) {
                    minSmllerThanI = j;
                }
            }

            DP[i][1] = minLrgerThanI == -1 ? false : DP[minLrgerThanI][0];
            DP[i][0] = minSmllerThanI == -1 ? false : DP[minSmllerThanI][1];

            if (DP[i][1]) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        testSolutionDP_4();
        testSolutionDP_2();
        testSolutionDP_1();
        testSolutionDP_3();
    }

    public static void testSolutionDP_4() {
        int[] arr = {1,2,3,2,1,4,4,5};
        int expOutput = 6;
        SolutionDP s = new SolutionDP();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("testSolutionDP_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDP_1() {
        int[] arr = {10,13,12,14,15};
        int expOutput = 2;
        SolutionDP s = new SolutionDP();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("testSolutionDP_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDP_2() {
        int[] arr = {2,3,1,1,4};
        int expOutput = 3;
        SolutionDP s = new SolutionDP();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("testSolutionDP_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDP_3() {
        int[] arr = {5,1,3,4,2};
        int expOutput = 3;
        SolutionDP s = new SolutionDP();
        int output = s.oddEvenJumps(arr);
        boolean passed = output == expOutput;
        System.out.println("testSolutionDP_3: " + (passed ? "passed" : "failed"));
    }
}
