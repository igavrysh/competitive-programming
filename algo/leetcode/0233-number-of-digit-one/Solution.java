class Solution {
    public int countDigitOne(int n) {
        int digits = (int)(Math.log10(n));
        // java int range = ~ [-2.1 * 10^9, ..., +2.9 * 10^9]
        // according to task desc, max n = 10^9 => max digits = 9, => m going to be 10 * 10^9 => 10^10 on the last iteration
        // 10^10 is > than Integer.MAX_VALUE, therefore there is going to be overflow that will affect the result
        long m = 10;
        long ones = 0;
        for (int i = 0; i <= digits; i++) {
            long toAdd = (long)(n / m) * (m/10) + Math.min(m/10, Math.max(n % m - (long)(m/10) + 1, 0));
            ones += toAdd;
            m *= 10;
        }
        return (int)ones;
    }

    public static void main(String[] args) {
        test4();
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int n = 99;
        int expectedOutput = 20;
        Solution sol = new Solution();
        int output = sol.countDigitOne(n);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int n = 999;
        int expectedOutput = 300;
        Solution sol = new Solution();
        int output = sol.countDigitOne(n);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int n = 9999;
        int expectedOutput = 4000;
        Solution sol = new Solution();
        int output = sol.countDigitOne(n);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int n = 1000000000;
        int expectedOutput = 900000001;
        Solution sol = new Solution();
        int output = sol.countDigitOne(n);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}