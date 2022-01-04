public class SolutionTest {
    public static void main(String[] args) {
        runTest1();
        runTest2();
    }

    public static void runTest1() {
        System.out.println("Running test 1");
        String num1 = "123";
        String num2 = "321";
        Solution sol = new Solution();
        assert(sol.addStrings(num1, num2).equals("444"));
        System.out.println("Finished test 1");
    }

    public static void runTest2() {
        System.out.println("Running test 2");
        String num1 = "5099";
        String num2 = "1";
        Solution sol = new Solution();
        assert(sol.addStrings(num1, num2).equals("5100"));
        System.out.println("Finished test 2");
    }
}