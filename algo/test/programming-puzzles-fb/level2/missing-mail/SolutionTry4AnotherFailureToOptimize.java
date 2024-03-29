import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class SolutionTry4AnotherFailureToOptimize {
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
    Double[][] mem;
    ArrayList<Double> maxAtLevels;

    int reuseCounter = 0;
    int totalCalls = 0;
    int checkOk = 0;
    int checkFail = 0;
    HashSet<Long> keys = new HashSet<>();

    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        this.N = N;
        this.V = V;
        this.C = C;
        this.S = S;
        this.mem = new Double[4000][10000];

        long totalRemSum = 0;
        for (int i = 0; i < V.length; i++) {
            totalRemSum += V[i];
        }

        maxAtLevels = new ArrayList<>();
        maxAtLevels.add(0, 0.0);

        return DP(0, 0, totalRemSum, 0);
    }

    private double DP(int idx, double delta, double totalRemSum, int lvl) {
        totalCalls++;
        //Long key = (long)((long)(delta * Math.pow(10, 6)) * Math.pow(10, 4)) + idx;
        //Long key = (long)((long)(idx * Math.pow(10, 3)) * Math.pow(10, 3)) + (long)(delta * Math.pow(10, 2));

        //keys.add(key);
        int key_idx = idx;
        int key_delta = (int)delta;

        if (mem[key_idx][key_delta] != null) {
            reuseCounter++;
            return mem[key_idx][key_delta];
        }

        if (maxAtLevels.size() == lvl+1) {
            maxAtLevels.add(0.0);
        }

        double take = 0.0;
        if (V[idx] + delta - C >= 0) {
            take = V[idx] + delta - C;
            if (totalRemSum - V[idx] - delta >= C && idx != N-1 && (totalRemSum - V[idx] - delta) >= maxAtLevels.get(lvl+1)) {
                checkOk++;
                take += DP(idx+1, 0, totalRemSum - V[idx] - delta, lvl+1);
            } else {
                checkFail++;
            }
        } else {
            checkFail++;
        }

        double keep = 0; 
        if (idx != N-1) {
            double newDelta = (1-S) * (delta + V[idx]);
            if (totalRemSum - V[idx] - delta + newDelta >= C && totalRemSum - V[idx] - delta + newDelta > take && (totalRemSum - V[idx] - delta + newDelta) >= maxAtLevels.get(lvl+1)) {
                checkOk++;
                keep = DP(idx+1, newDelta, totalRemSum - V[idx] - delta + newDelta, lvl+1);
            } else {
                checkFail++;
            }
        }
        
        double val = Math.max(take, keep);

        maxAtLevels.set(lvl, Math.max(maxAtLevels.get(lvl), val));

        mem[key_idx][key_delta] = val;

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

        SolutionTry4AnotherFailureToOptimize sol = new SolutionTry4AnotherFailureToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        System.out.println("testGenRandom5 output = " + Double.toString(output));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) 
            + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk 
            + " checkFail = " + sol.checkFail);
        //System.out.println("keys = " + sol.keys.toString());

    }

    public static void test1() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 0.0;
        double delta = 0.0001;
        double expectedOutput = 25.0;
        SolutionTry4AnotherFailureToOptimize sol = new SolutionTry4AnotherFailureToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test1: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) 
            + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk 
            + " checkFail = " + sol.checkFail);
        System.out.println("keys = " + sol.keys.toString());
    }

    public static void test2() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 1.0;
        double delta = 0.0001;
        double expectedOutput = 9.0;
        SolutionTry4AnotherFailureToOptimize sol = new SolutionTry4AnotherFailureToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test2: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) 
            + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk 
            + " checkFail = " + sol.checkFail);       
        System.out.println("keys = " + sol.keys.toString());

    }

    public static void test3() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.5;
        double delta = 0.0001;
        double expectedOutput = 17.0;
        SolutionTry4AnotherFailureToOptimize sol = new SolutionTry4AnotherFailureToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test3: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) 
            + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk 
            + " checkFail = " + sol.checkFail);

        System.out.println("keys = " + sol.keys.toString());

    }

    public static void test4() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.15;
        double delta = 0.0001;
        double expectedOutput = 20.10825;
        SolutionTry4AnotherFailureToOptimize sol = new SolutionTry4AnotherFailureToOptimize();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test4: " + (passed ? "passed" :  "failed"));
        System.out.println("reuse counter = " + Integer.toString(sol.reuseCounter) 
            + " totalCalls = " + sol.totalCalls + " checkOk = " + sol.checkOk 
            + " checkFail = " + sol.checkFail); 
        System.out.println("keys = " + sol.keys.toString());
    }
}