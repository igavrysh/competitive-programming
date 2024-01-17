public class Solution {
    public int maximumSwap(int num) {
        if (num <= 1) {
            return num;
        }
        int n = (int)(Math.log(num) / Math.log(10));
        while (Math.pow(10, n) <= num) {
            n++;
        }

        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[n-1-i] = num%10;
            num = num / 10;
        }

        int[][] max = new int[n][2];
        int max_r = t[n-1];
        int max_r_idx = n-1;
        for (int i = n-1; i >= 0; i--) {
            if (max_r < t[i]) {
                max_r = t[i];
                max_r_idx = i;
            }

            max[i] = new int[]{max_r, max_r_idx};
        }

        for (int i = 0; i < n; i++) {
            if (t[i] < max[i][0]) {
                int tmp = t[i];
                t[i] = t[max[i][1]];
                t[max[i][1]] = tmp;
                break;
            }
        }

        int output = 0;
        for (int i = 0; i < n; i++) {
            output = output * 10 + t[i];
        }
        return output;
    }
    
    public static void main(String[] args) {
        test4();
        test1();
        test2();
    }

    public static void test1() {
        int input = 2736;
        int expOutput = 7236;
        Solution sol = new Solution();
        int output = sol.maximumSwap(input);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int input = 9973;
        int expOutput = 9973;
        Solution sol = new Solution();
        int output = sol.maximumSwap(input);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int input = 1000;
        int expOutput = 1000;
        Solution sol = new Solution();
        int output = sol.maximumSwap(input);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}
