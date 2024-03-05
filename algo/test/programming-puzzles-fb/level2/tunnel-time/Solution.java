import java.util.Arrays;

class Solution {

    public long getSecondsElapsed(long C, int N, long[] A, long[] B, long K) {
        Arrays.sort(A);
        Arrays.sort(B);
        long acc = 0;
        for (int i = 0; i < N; i++) {
            acc += B[i] - A[i];
        }

        long laps = K / acc;
        long rem = K % acc;

        if (rem == 0) {
            return (laps-1) * C + B[N-1];
        }

        int i = 0;
        while (rem - (B[i]-A[i]) > 0) {
            rem -= (B[i] - A[i]);
            i++;
        }

        return laps * C + A[i] + rem;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3_1();
        test3_2();
        test3_3();
        test3_4();
        test3_5();
        test3_6();
        test3_7();
        test4();
        test4_2();
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


    public static void test3_1() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 1;
        long expectedOutput = 2;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test3_1: " + (passed ? "passed" : "failed"));
    }

    public static void test3_2() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 2;
        long expectedOutput = 3;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test3_2: " + (passed ? "passed" : "failed"));
    }

    public static void test3_3() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 3;
        long expectedOutput = 7;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test3_3: " + (passed ? "passed" : "failed"));
    }

    public static void test3_4() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 4;
        long expectedOutput = 12;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test3_4: " + (passed ? "passed" : "failed"));
    }

    public static void test3_5() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 5;
        long expectedOutput = 13;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test3_5: " + (passed ? "passed" : "failed"));
    }

    public static void test3_6() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 6;
        long expectedOutput = 17;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test3_6: " + (passed ? "passed" : "failed"));
    }

    public static void test3_7() {
        long C = 10;
        int N = 2;
        long[] A = {1,6};
        long[] B = {3,7};
        long K = 7;
        long expectedOutput = 22;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test3_7: " + (passed ? "passed" : "failed"));
    }


    public static void test4() {
        long C = (long)Math.pow(10, 12);
        int N = 1;
        long[] A = {1};
        long[] B = {(long)Math.pow(10, 12)-1};
        long K = 7;
        long expectedOutput = 8;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test4_2() {
        long C = (long)Math.pow(10, 12);
        int N = 1;
        long[] A = {1};
        long[] B = {(long)Math.pow(10, 12)-1};
        long K = 3*((long)Math.pow(10, 12)-2) + 256L;
        long expectedOutput = C*3+256L+1L;
        Solution sol = new Solution();
        long output = sol.getSecondsElapsed(C, N, A, B, K);
        boolean passed = output == expectedOutput;
        System.out.println("test4_2: " + (passed ? "passed" : "failed"));
    }
}
