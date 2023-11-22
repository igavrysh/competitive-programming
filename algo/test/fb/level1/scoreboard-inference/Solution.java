// Write any import statements here

class Solution {

    public int getMinProblemCount(int N, int[] S) {
        boolean allDivBy2 = true;
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, S[i]);
            if (S[i] % 2 == 1) {
                allDivBy2 = false;
            }
        }

        if (allDivBy2) {
            return max / 2;
        }
        return max/2 + 1;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int N = 6;
        int[] S = {1,2,3,4,5,6};
        int expectedOutput = 4;
        Solution s = new Solution();
        int output = s.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 4;
        int[] S = {4,3,3,4};
        int expectedOutput = 3;
        Solution s = new Solution();
        int output = s.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 4;
        int[] S = {2,4,6,8};
        int expectedOutput = 4;
        Solution s = new Solution();
        int output = s.getMinProblemCount(N, S);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}
