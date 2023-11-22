// Write any import statements here

class Solution {

    public int getUniformIntegerCountInInterval(long A, long B) {
        long div = 1;
        while (A / div >= 10) {
            div = div * 10 + 1;
        }

        int counter = -1 * (int)(A/div) + (A%div == 0 ? 1 : 0);

        while (B / div >= 10) {
            counter += 9;
            div = div * 10 + 1;
        }

        counter += B / div;

        return counter;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        long A = 75;
        long B = 300;
        int expectedOutput = 5;
        Solution s = new Solution();
        int output = s.getUniformIntegerCountInInterval(A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        long A = 1;
        long B = 9;
        int expectedOutput = 9;
        Solution s = new Solution();
        int output = s.getUniformIntegerCountInInterval(A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        long A = 999999999999l;
        long B = 999999999999l;
        int expectedOutput = 1;
        Solution s = new Solution();
        int output = s.getUniformIntegerCountInInterval(A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
