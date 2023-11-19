import java.util.HashMap;

class Solution {

    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        HashMap<Long, Double> mem = new HashMap<>();
        
        return DP(0, 0, N, V, C, S, mem);
    }

    private double DP(int idx, double delta, int N, int[] V, int C, double S, HashMap<Long, Double> mem) {
        Long key = (long)(delta * Math.pow(10, 5) * Math.pow(10, 6)) + idx;
        if (mem.get(key) != null) {
            return mem.get(key);
        }


        double val = Math.max(
            V[idx] + delta - C + (idx == N-1 ? 0 : DP(idx+1, 0, N, V, C, S, mem)),
            (idx == N-1 ? 0 : DP(idx+1, (1-S) * (delta + V[idx]), N, V, C, S, mem))
        );

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
        Solution sol = new Solution();
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
