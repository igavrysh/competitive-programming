import java.util.Arrays;

class Solution {

    public double getMaxDamageDealt(int N, int[] H, int[] D, int B) {
        double[][] dh = new double[N][3];
        for (int i = 0; i < N; i++) {
            dh[i] = new double[]{D[i], H[i], D[i]*H[i]};
        }
        Arrays.sort(dh, (double[] a1, double[] a2) -> -1*Double.compare(a1[2], a2[2]));
        return Math.max(findMax(0, 1, N, dh), findMax(1, 0, N, dh)) / B;
    }

    private double findMax(int i, int j, int N, double[][] dh) {
        double val = dh[i][2] + dh[j][2] + dh[j][0] * dh[i][1];

        int inc = i+1 != j ? 1 : 2;
        double valIPlus = 0, valJPlus = 0;
        if (i+inc < N) {
            valIPlus = dh[i+inc][2] + dh[j][2] + dh[j][0] * dh[i+inc][1];
            if (val > valIPlus) {
                valIPlus = findMax(i+inc, j, N, dh);
            }
        }

        inc = j+1 != i ? 1 : 2;
        if (j+inc < N) {
            valJPlus = dh[i][2] + dh[j+inc][2] + dh[j+inc][0] * dh[i][1];
            if (val > valIPlus) {
                valIPlus = findMax(i, j+inc, N, dh);
            }
        }

        return Math.max(val, Math.max(valIPlus, valJPlus));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int N = 3;
        int[] H = {2,1,4};
        int[] D = {3,1,2};
        int B = 4;
        double expectedOutput = 6.5;
        double delta = Math.pow(10, -6);
        Solution sol = new Solution();
        double output = sol.getMaxDamageDealt(N, H, D, B);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 4;
        int[] H = {1,1,2,100};
        int[] D = {1,2,1,3};
        int B = 8;
        double expectedOutput = 62.75;
        double delta = Math.pow(10, -6);
        Solution sol = new Solution();
        double output = sol.getMaxDamageDealt(N, H, D, B);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 4;
        int[] H = {1,1,2,3};
        int[] D = {1,2,1,100};
        int B = 8;
        double expectedOutput = 62.75;
        double delta = Math.pow(10, -6);
        Solution sol = new Solution();
        double output = sol.getMaxDamageDealt(N, H, D, B);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}