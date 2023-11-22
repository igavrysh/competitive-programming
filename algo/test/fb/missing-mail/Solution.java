import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        double[] DP = new double[N];
        double globalMax = 0;
        for (int i = 0; i < N; i++) {
            double best = 0;
            double value = 0;
            double mult = 1;
            for (int j = i; j >= 0; j--) {
                value += V[j] * mult;
                best = Math.max(best, value - C + (j > 0 ? DP[j-1] : 0));
                mult *= (1-S);
            }
            DP[i] = best;
            globalMax = Math.max(DP[i], globalMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        testGenRandom5();
    }

    public static void test1() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 0.0;
        double delta = 0.0001;
        double expectedOutput = 25.0;
        Solution sol = new Solution();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test1: " + (passed ? "passed" :  "failed"));
    }


    public static void testGenRandom5() {
        int N = 3000;
        int minV = 0, maxV = 1000;
        int minC = 1, maxC = 1000;
        double minS = 0.0, maxS = 1.0;
        int[] V = new int[N];
    
        for (int i = 0; i < N; i++) {
            V[i] = ThreadLocalRandom.current().nextInt(minV, maxV + 1);
        }

        int C = ThreadLocalRandom.current().nextInt(minC, maxC + 1);
        Random r = new Random();
        double S = minS + (maxS - minS) * r.nextDouble();

        Solution sol = new Solution();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        System.out.println("testGenRandom5 output = " + Double.toString(output));
    }

    public static void test2() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 1.0;
        double delta = 0.0001;
        double expectedOutput = 9.0;
        Solution sol = new Solution();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test2: " + (passed ? "passed" :  "failed"));
    }

    public static void test3() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.5;
        double delta = 0.0001;
        double expectedOutput = 17.0;
        Solution sol = new Solution();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test3: " + (passed ? "passed" :  "failed"));
    }

    public static void test4() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.15;
        double delta = 0.0001;
        double expectedOutput = 20.10825;
        Solution sol = new Solution();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test4: " + (passed ? "passed" :  "failed"));
    }
}
