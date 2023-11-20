import java.util.HashMap;

public class SolutionInitialAttemptStringKey {
    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        HashMap<String, Double> mem = new HashMap<>();
        return DP(0, 0, N, V, C, S, mem);
    }

    private double DP(int idx, double delta, int N, int[] V, int C, double S, HashMap<String, Double> mem) {
        String key = Integer.toString((int)(delta * Math.pow(10, 6))) +  "_" + Integer.toString(idx);
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
    }

    public static void test1() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 0.0;
        double delta = 0.0001;
        double expectedOutput = 25.0;
        SolutionInitialAttemptStringKey sol = new SolutionInitialAttemptStringKey();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("SolutionStringKey test4: " + (passed ? "passed" :  "failed"));
    }

    public static void test2() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 5;
        double S = 1.0;
        double delta = 0.0001;
        double expectedOutput = 9.0;
        SolutionInitialAttemptStringKey sol = new SolutionInitialAttemptStringKey();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("SolutionStringKey test2: " + (passed ? "passed" :  "failed"));
    }

    public static void test3() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.5;
        double delta = 0.0001;
        double expectedOutput = 17.0;
        SolutionInitialAttemptStringKey sol = new SolutionInitialAttemptStringKey();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("SolutionStringKey test3: " + (passed ? "passed" :  "failed"));
    }

    public static void test4() {
        int N = 5;
        int[] V = {10,2,8,6,4};
        int C = 3;
        double S = 0.15;
        double delta = 0.0001;
        double expectedOutput = 20.10825;
        SolutionInitialAttemptStringKey sol = new SolutionInitialAttemptStringKey();
        double output = sol.getMaxExpectedProfit(N, V, C, S);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("SolutionStringKey test4: " + (passed ? "passed" :  "failed"));
    }

}
