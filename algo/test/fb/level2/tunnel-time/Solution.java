import java.util.Arrays;

class Solution {

    public long getSecondsElapsed(long C, int N, long[] A, long[] B, long K) {
        Arrays.sort(A);
        Arrays.sort(B);
        long acc = 0;
        for (int i = 0; i < N; i++) {
            acc += B[i] - A[i];
        }
        long lastEnd = B[N-1];
        long lastRem = C - lastEnd;

        long result = C * ((K / acc) - 1) + lastEnd;
        long rem = K % acc;

        if (rem > 0) {
            result += lastRem;
        }

        for (int i = 0; i < N; i++) {
            if (rem - (B[i]-A[i]) <= 0){
                result += (A[i] + rem);
                break;
            }
            rem -= B[i]-A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 7;
        long expectedOutput = 22;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        long C = 50;
        int N = 3;
        long[] A = {39,19,28};
        long[] B = {49,27,35};
        long K = 15;
        long expectedOutput = 35;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

}
