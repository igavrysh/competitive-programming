import java.util.Arrays;

class Solution {

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here

        Arrays.sort(S);

        long acc = 0;

        for (int i = -1; i < M; i++) {
            long s_l = 0;
            if (i == -1) {
                s_l = -K;
            } else {
                s_l = S[i];
            }

            long s_r = 0;

            if (i == M - 1) {
                s_r = N + K + 1;
            } else {
                s_r = S[i + 1];
            }

            acc += Math.max(0, ((s_r - s_l - 1) - K) / (1 + K));
        }
        return acc;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int N = 15;
        int K = 2;
        int M = 3;
        long[] S = {11, 6, 14};

        Solution s = new Solution();
        long output = s.getMaxAdditionalDinersCount(N, K, M, S);
        boolean passed = output == 1;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }


}