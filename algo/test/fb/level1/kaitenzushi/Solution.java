import java.util.LinkedHashSet;

class Solution {

    public int getMaximumEatenDishCount(int N, int[] D, int K) {
        int counter = 0;
        LinkedHashSet<Integer> eaten = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            if (!eaten.contains(D[i])) {
                if (eaten.size() == K) {
                    eaten.remove(eaten.iterator().next());                    
                }
                eaten.add(D[i]);
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int N = 6;
        int[] D = {1,2,3,3,2,1};
        int K = 1;

        Solution s = new Solution();
        int output = s.getMaximumEatenDishCount(N, D, K);
        int expectedOutput = 5;
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 6;
        int[] D = {1,2,3,3,2,1};
        int K = 2;

        Solution s = new Solution();
        int output = s.getMaximumEatenDishCount(N, D, K);
        int expectedOutput = 4;
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 7;
        int[] D = {1,2,1,2,1,2,1};
        int K = 2;

        Solution s = new Solution();
        int output = s.getMaximumEatenDishCount(N, D, K);
        int expectedOutput = 2;
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}
