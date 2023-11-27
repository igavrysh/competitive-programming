
class Solution {

    public int getMinProblemCount(int N, int[] S) {
        boolean remOne = false, remTwo = false;
        boolean hasOne = false;
        int maxVal = S[0];
        for (int i = 0; i < N; i++) {
            maxVal = Math.max(maxVal, S[i]);
            if (S[i] % 3 == 1) {
                remOne = true;
            }

            if (S[i] % 3 == 2) {
                remTwo = true;
            }

            if (S[i] == 1) {
                hasOne = true;
            }
        }

        if (maxVal % 3 == 0) {
            // if max value is divided by 3
            // and we should have 1s & 2s based on arr S
            // we don't need last 3, and can build it with present 1s and 2s


            if (remOne && remTwo) {
                // -1 last 3s and +1 one and +1 two
                return maxVal / 3 - 1 + 1 + 1;
            }
        }

        if (maxVal % 3 == 1 && !hasOne) {
            boolean hasMaxMultBy3 = false;
            for (int i = 0; i < N; i++) {
                if (S[i] == (maxVal / 3) * 3) {
                    hasMaxMultBy3 = true;
                    break;
                }

            }

            // 2, 3, 4, 5, 6, 7, 8, 10 
            // can make any number in range 2.....maxVal except 1 and (maxval/3) *3, with 3s:(maxVal/3)-1 and 2s:2, total number = maxVal/3+1
            if (!hasMaxMultBy3) {
                return maxVal / 3 + 1;
            }
        }

        // by default we can make any number with enough 3s and/or 1s and 2s (depending if we need them based on array of S)
        return maxVal/3 + (remOne ? 1 : 0) + (remTwo ? 1 : 0);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }

    public static void test1() {
        int N = 5;
        int[] S = {1,2,3,4,5};
        int expectedOutput = 3;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 4;
        int[] S = {4,3,3,4};
        int expectedOutput = 2;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }


    public static void test3() {
        int N = 4;
        int[] S = {2,4,6,8};
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int N = 1;
        int[] S = {8};
        int expectedOutput = 3;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        int N = 3;
        int[] S = {3,6,9};
        int expectedOutput = 3;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        int N = 3;
        int[] S = {3,6,10};
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        int N = 3;
        int[] S = {3,6,11};
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }

    public static void test8() {
        int N = 3;
        int[] S = {7,8,9};
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test8: " + (passed ? "passed" : "failed"));
    }

    public static void test9() {
        int[] S = {2, 3, 4, 5, 6, 7, 8, 10};
        int N = S.length;
        int expectedOutput = 10/3+1; // 3s: 2, 2s: 2, total 4
        Solution sol = new Solution();
        int output = sol.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test9: " + (passed ? "passed" : "failed"));
    }
}
