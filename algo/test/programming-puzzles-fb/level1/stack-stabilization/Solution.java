// Write any import statements here

import java.util.HashSet;

class Solution {

    public int getMinimumDeflatedDiscCount(int N, int[] R) {
        HashSet<Integer> defl = new HashSet<>();
        for (int i = 1; i < N; i++) {
            if (R[i] <= R[i-1]) {
                int j = i-1;
                while ( j >= 0 && R[j+1] <= R[j]) {
                    R[j] = R[j+1]-1;
                    if (R[j] == 0) {
                        return -1;
                    }
                    defl.add(j);
                    j--;
                }
            }
        }
        return defl.size();
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int N = 5;
        int[] R = {2,5,3,6,5};
        int expectedOutput = 3;

        Solution s = new Solution();
        int output = s.getMinimumDeflatedDiscCount(N, R);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 3;
        int[] R = {100,100,100};
        int expectedOutput = 2;

        Solution s = new Solution();
        int output = s.getMinimumDeflatedDiscCount(N, R);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 4;
        int[] R = {6,5,4,3};
        int expectedOutput = -1;

        Solution s = new Solution();
        int output = s.getMinimumDeflatedDiscCount(N, R);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}
