
class Solution {

    public int getMinProblemCount(int N, int[] S) {
        int maxDivBy3 = 0;
        boolean allRemDivBy2 = true;
        int maxRem = 0;
        for (int i = 0; i < N; i++) {
            maxDivBy3 = Math.max(S[i]/3, maxDivBy3);
            S[i] = S[i]%3;
            
            maxRem = Math.max(maxRem, S[i]);
            if (S[i]%2 == 1) {
                allRemDivBy2 = false;
            }
        }

        return maxDivBy3 + maxRem/2 + (allRemDivBy2 == true ? 0 : 1);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
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


}
