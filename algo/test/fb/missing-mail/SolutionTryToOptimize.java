import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SolutionTryToOptimize {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        testGenRandom5();
    }

    int N;
    int[] V;
    int C;
    double S;
    HashMap<Long, Double> mem;

    private int reuseCounter = 0;
    private int totalCalls = 0;
    private int checkOk = 0;
    private int checkFail = 0;
    private HashSet<Long> keys = new HashSet<>();

    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        this.N = N;
        this.V = V;
        this.C = C;
        this.S = S;
        this.mem = new HashMap<>();

        long totalRemSum = 0;
        for (int i = 0; i < V.length; i++) {
            totalRemSum += V[i];
        }

        return DP(0, 0, totalRemSum);
    }

    private double DP(int idx, double delta, double totalRemSum) {
        totalCalls++;
        Long key = (long)(delta * Math.pow(10, 4) * Math.pow(10, 6))  + idx;
        keys.add(key);


        if (mem.get(key) != null) {
            reuseCounter++;
            return mem.get(key);
        }

        double take = 0.0;
        if (V[idx] + delta - C >= 0) {
            take = V[idx] + delta - C;
            if (totalRemSum - V[idx] - delta >= C && idx != N-1) {
                take += DP(idx+1, 0, totalRemSum - V[idx] - delta);
            }
            checkOk++;
        } else {
            checkFail++;
        }

        double keep = 0; 
        if (idx != N-1) {
            double newDelta = (1-S) * (delta + V[idx]);
            if (totalRemSum - V[idx] - delta + newDelta >= C) {
                keep = DP(idx+1, newDelta, totalRemSum - V[idx] - delta + newDelta);
                checkOk++;
            } else {
                checkFail++;
            }
        }
        
        double val = Math.max(take, keep);

        mem.put(key, val);

        return  val;
    }

    public static void testGenRandom5() {
        int N = 4000;
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

        SolutionTryToOptimize sol = new SolutionTryToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        System.out.println("testGenRandom5 output = " + Double.toString(output));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk + " checkFail = " + sol.checkFail);
        //System.out.println("keys = " + sol.keys.toString());

    }

    public static void test1() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 0.0;
        double delta = 0.0001;
        double expectedOutput = 25.0;
        SolutionTryToOptimize sol = new SolutionTryToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test1: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk + " checkFail = " + sol.checkFail);
        System.out.println("keys = " + sol.keys.toString());


    }

    public static void test2() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 1.0;
        double delta = 0.0001;
        double expectedOutput = 9.0;
        SolutionTryToOptimize sol = new SolutionTryToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test2: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk + " checkFail = " + sol.checkFail);
        System.out.println("keys = " + sol.keys.toString());

    }

    public static void test3() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.5;
        double delta = 0.0001;
        double expectedOutput = 17.0;
        SolutionTryToOptimize sol = new SolutionTryToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test3: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk + " checkFail = " + sol.checkFail);
        System.out.println("keys = " + sol.keys.toString());

    }

    public static void test4() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.15;
        double delta = 0.0001;
        double expectedOutput = 20.10825;
        SolutionTryToOptimize sol = new SolutionTryToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test4: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk + " checkFail = " + sol.checkFail);
        System.out.println("keys = " + sol.keys.toString());
    }

}
