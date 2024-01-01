public class SolutionBF {
    public int countDigitOne(int n) {
        int ones = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                if (num % 10 == 1) {
                    ones++;
                }
                num = num /10;
            }
        }
        return ones;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int n = 99;
        int expectedOutput = 20;
        SolutionBF sol = new SolutionBF();
        int output = sol.countDigitOne(n);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int n = 999;
        int expectedOutput = 300;
        SolutionBF sol = new SolutionBF();
        int output = sol.countDigitOne(n);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int n = 9999;
        int expectedOutput = 4000;
        SolutionBF sol = new SolutionBF();
        int output = sol.countDigitOne(n);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
    
}
