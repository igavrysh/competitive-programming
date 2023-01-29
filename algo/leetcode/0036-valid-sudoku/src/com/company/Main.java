package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();

        testSolutionArray1();
        testSolutionArray2();
    }

    public static void test1() {
        char[][] b = new char[][]
            {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
        Solution s = new Solution();
        boolean output = s.isValidSudoku(b);
        boolean passed = output == true;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
    
    public static void test2() {
        char[][] b = new char[][]
            {{'8','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
        Solution s = new Solution();
        boolean output = s.isValidSudoku(b);
        boolean passed = output == false;
        System.out.println("test2: " + (passed ? "passed" : "false"));
    }

    public static void testSolutionArray1() {
        char[][] b = new char[][]
            {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
        SolutionArray s = new SolutionArray();
        boolean output = s.isValidSudoku(b);
        boolean passed = output == true;
        System.out.println("testSolutionArray1: " + (passed ? "passed" : "failed"));
    }
    
    public static void testSolutionArray2() {
        char[][] b = new char[][]
            {{'8','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
        SolutionArray s = new SolutionArray();
        boolean output = s.isValidSudoku(b);
        boolean passed = output == false;
        System.out.println("testSolutionArray2: " + (passed ? "passed" : "false"));
    }
}
