class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long good = 0;
        long bad = maxSum+1;
        while (bad - good > 1) {
            long m = (long)(good + (bad - good) / 2.0);
            if (check(m, n, index, maxSum)) {
                good = m;
            } else {
                bad = m;
            }
        }
        return (int)good;
    }

    private boolean check(long val, int n, int index, int maxSum) {
        long remainder = maxSum - val;

        long righLen = n-1-index;
        long rightSum = 0;
        if (righLen > (val-1)) {
            rightSum += ((val-1 + 1) * (val-1)) / 2.0 + righLen - (val-1);
        } else {
            rightSum += (val-1 + val-1-righLen+1) * righLen / 2.0;
        }
        
        long leftLen = index;
        long leftSum = 0;
        if (leftLen > (val-1)) {
            leftSum += ((val-1 + 1) * (val-1) / 2.0) + leftLen - (val-1);
        } else {
            leftSum += (val-1 + (val-1-leftLen+1)) * leftLen / 2.0;
        }

        return remainder - rightSum - leftSum >= 0;
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_4();
        testSolution_5();
    }

    public static void testSolution_1() {
        int n = 4, index = 2, maxSum = 6, expected = 2;
        Solution s = new Solution();
        int actual = s.maxValue(n, index, maxSum);
        boolean passed = actual == expected;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int n = 6, index = 1, maxSum = 10, expected = 3;
        Solution s = new Solution();
        int actual = s.maxValue(n, index, maxSum);
        boolean passed = actual == expected;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        int n = 3, index = 2, maxSum = 18, expected = 7;
        Solution s = new Solution();
        int actual = s.maxValue(n, index, maxSum);
        boolean passed = actual == expected;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        int n = 6, index = 2, maxSum = 931384943, expected = 155230825;
        Solution s = new Solution();
        int actual = s.maxValue(n, index, maxSum);
        boolean passed = actual == expected;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_5() {
        int n = 8257285, index = 4828516, maxSum = 850015631, expected = 29014;
        Solution s = new Solution();
        int actual = s.maxValue(n, index, maxSum);
        boolean passed = actual == expected;
        System.out.println("testSolution_5: " + (passed ? "passed" : "failed"));
    } 
}