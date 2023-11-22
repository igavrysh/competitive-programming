import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class SolutionTry1InitialAttempt {

    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        HashMap<Long, Double> mem = new HashMap<>();
        return DP(0, 0, N, V, C, S, mem);
    }

    private double DP(int idx, double delta, int N, int[] V, int C, double S, HashMap<Long, Double> mem) {
        Long key = (long)((long)(idx * Math.pow(10, 3)) + (long)delta *  Math.pow(10, 6));
        if (mem.get(key) != null) {
            return mem.get(key);
        }

        double take = 0.0;
        if (V[idx] + delta - C > 0) {
            take = V[idx] + delta - C + (idx == N-1 ? 0 : DP(idx+1, 0, N, V, C, S, mem));
        }

        double keep = idx == N-1 ? 0 : DP(idx+1, (1-S) * (delta + V[idx]), N, V, C, S, mem);

        double val = Math.max(take, keep);

        mem.put(key, val);

        return  val;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        testGenRandom5();
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

        SolutionTry1InitialAttempt sol = new SolutionTry1InitialAttempt();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        System.out.println("testGenRandom5 output = " + Double.toString(output));

    }

    public static void test1() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 0.0;
        double delta = 0.0001;
        double expectedOutput = 25.0;
        SolutionTry1InitialAttempt sol = new SolutionTry1InitialAttempt();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test1: " + (passed ? "passed" :  "failed"));
    }

    public static void test2() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 1.0;
        double delta = 0.0001;
        double expectedOutput = 9.0;
        SolutionTry1InitialAttempt sol = new SolutionTry1InitialAttempt();
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
        SolutionTry1InitialAttempt sol = new SolutionTry1InitialAttempt();
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
        SolutionTry1InitialAttempt sol = new SolutionTry1InitialAttempt();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test4: " + (passed ? "passed" :  "failed"));
    }

}
