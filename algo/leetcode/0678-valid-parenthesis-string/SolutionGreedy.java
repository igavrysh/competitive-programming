public class SolutionGreedy {

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
        int leftBrkLo = 0, leftBrkHi = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftBrkLo += 1;
                leftBrkHi += 1;
            } else if (ch == ')') {
                leftBrkLo = Math.max(0, leftBrkLo-1);
                leftBrkHi -= 1;
            } else if (ch == '*') {
                leftBrkHi += 1;
                leftBrkLo = Math.max(0, leftBrkLo-1);
            }

            if (leftBrkHi < 0) {
                return false;
            }
        }
        return leftBrkLo == 0;
    }

    public static void testSolution_1() {
        String s = "(*))";
        SolutionGreedy sol = new SolutionGreedy();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        String s = "(*)";
        SolutionGreedy sol = new SolutionGreedy();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        String s = "(";
        SolutionGreedy sol = new SolutionGreedy();
        boolean expectedOutput = false;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_40() {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        SolutionGreedy sol = new SolutionGreedy();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_40: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        SolutionGreedy sol = new SolutionGreedy();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_5() {
        String s = "((()))()(())(*()()())**(())()()()()((*()*))((*()*)";
        SolutionGreedy sol = new SolutionGreedy();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_5: " + (passed ? "passed" : "failed"));
    }
}
