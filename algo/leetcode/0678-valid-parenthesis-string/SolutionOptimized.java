public class SolutionOptimized {

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_40();
        testSolution_4();
        testSolution_5();
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0; 
    }

    public static void testSolution_1() {
        String s = "(*))";
        SolutionOptimized sol = new SolutionOptimized();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        String s = "(*)";
        SolutionOptimized sol = new SolutionOptimized();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        String s = "(";
        SolutionOptimized sol = new SolutionOptimized();
        boolean expectedOutput = false;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_40() {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        SolutionOptimized sol = new SolutionOptimized();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_40: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        SolutionOptimized sol = new SolutionOptimized();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_5() {
        String s = "((()))()(())(*()()())**(())()()()()((*()*))((*()*)";
        SolutionOptimized sol = new SolutionOptimized();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_5: " + (passed ? "passed" : "failed"));
    }
}
