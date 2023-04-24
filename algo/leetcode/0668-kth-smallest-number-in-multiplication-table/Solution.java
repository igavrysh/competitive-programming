class Solution {

    public static void main(String[] args) {
        testSolutionBS_1();
        testSolutionBS_2();
    }

    public int findKthNumber(int m, int n, int k) {
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        long bad = 0;
        long good = ((long)m)*n+1;

        while (good-bad>1) {
            long middle = bad + (good - bad) / 2;
            if (isGoodEnough(middle, m, n, k)) {
                good = middle;
            } else {
                bad = middle;
            }
        }
        return (int)good;
    }

    // good enough = number of integers in sorted multiplication table >= k
    private boolean isGoodEnough(long val, int m, int n, int k) {
        long accK = 0;
        for (int i = n; i >= 1; i--) {
            accK += Math.min(val/i, m);
            if (accK >= k) {
                return true;
            }
        }
        return false;
    }

    public static void testSolutionBS_1() {
        int m = 3, n = 3, k = 5;
        Solution s = new Solution();
        int output = s.findKthNumber(m, n, k);
        boolean passed = output == 3;
        System.out.println("testSolutionBS_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_2() {
        int m = 2, n = 3, k = 6;
        Solution s = new Solution();
        int output = s.findKthNumber(m, n, k);
        boolean passed = output == 6;
        System.out.println("testSolutionBS_2: " + (passed ? "passed" : "failed"));
    }
}