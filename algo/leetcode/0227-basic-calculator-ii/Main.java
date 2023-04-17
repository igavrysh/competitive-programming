public class Main {
    public static void main(String[] args) {
        testSolutionStack5();

        testSolutionStack4();

        testSolutionStack1();
        testSolutionStack2();
        testSolutionStack3();
        testSolutionStack4();
        /* 
        testSolution3();
        testSolution4();
        testSolution5();
        */
    }

    public static void testSolutionStack1() {
        String str = "3+2*2";
        SolutionStack s = new SolutionStack();
        int output = s.calculate(str);
        boolean passed = output == 7;
        System.out.println("testSolutionStack1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack2() {
        String str = " 3/2 ";
        SolutionStack s = new SolutionStack();
        int output = s.calculate(str);
        boolean passed = output == 1;
        System.out.println("testSolutionStack2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack3() {
        String str = " 3+5 / 2 ";
        SolutionStack s = new SolutionStack();
        int output = s.calculate(str);
        boolean passed = output == 5;
        System.out.println("testSolutionStack3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack4() {
        String str = "1-1-1";
        SolutionStack s = new SolutionStack();
        int output = s.calculate(str);
        boolean passed = output == -1;
        System.out.println("testSolutionStack4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionStack5() {
        String str = "1+2*5/3+6/4*2";
        SolutionStack s = new SolutionStack();
        int output = s.calculate(str);
        boolean passed = output == 6;
        System.out.println("testSolutionStack5: " + (passed ? "passed" : "failed"));
    }
}