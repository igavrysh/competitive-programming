package com.company;

public class Main {
    public static void main(String[] args) {
        testSolution1_1();
        testSolution1_2();
        testSolution1_3();
        testSolution1_4();
        testSolution1_5();
        testSolution1_6();
        testSolution1_7();
        testSolution1_8();
        testSolution1_9();

        testSolution2_1();
        testSolution2_2();
        testSolution2_3();
        testSolution2_4();
        testSolution2_5();
        testSolution2_6();
        testSolution2_7();
        testSolution2_8();
        testSolution2_9();

        testSolutionGCD_1();
        testSolutionGCD_2();
        testSolutionGCD_3();
        testSolutionGCD_4();
        testSolutionGCD_5();
        testSolutionGCD_6();
        testSolutionGCD_7();
        testSolutionGCD_8();
        testSolutionGCD_9();

        testSolutionSlope_1();
        testSolutionSlope_2();
        testSolutionSlope_3();
        testSolutionSlope_4();
        testSolutionSlope_5();
        testSolutionSlope_6();
        testSolutionSlope_7();
        testSolutionSlope_8();
        testSolutionSlope_9();
    }

    public static void testSolution1_1() {
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{1,1},{2,2},{3,3}});
        boolean passed = output == 3;
        System.out.println("testSolution1_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_2() {
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});
        boolean passed = output == 4;
        System.out.println("testSolution1_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_3() {
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{0,0}});
        boolean passed = output == 1;
        System.out.println("testSolution1_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_4() {
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{0,0},{1,0}});
        boolean passed = output == 2;
        System.out.println("testSolution1_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_5() {
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{0,0},{0,1}});
        boolean passed = output == 2;
        System.out.println("testSolution1_5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_6() {     
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolution1_6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_7() {     
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-1,5},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolution1_7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_8() {
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}});
        boolean passed = output == 5;
        System.out.println("testSolution1_8: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_9() {
        Solution s = new Solution();
        int output = s.maxPoints(new int[][] {
            {7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},
            {-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},
            {-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},
            {10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},
            {-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},
            {-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},
            {-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},
            {9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},
            {15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},
            {4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},
            {-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},
            {5,-17},{6,-6},{-11,-8}
        });
        boolean passed = output == 6;
        System.out.println("testSolution1_9: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_1() {
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{1,1},{2,2},{3,3}});
        boolean passed = output == 3;
        System.out.println("testSolution2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_2() {
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});
        boolean passed = output == 4;
        System.out.println("testSolution2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_3() {
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{0,0}});
        boolean passed = output == 1;
        System.out.println("testSolution2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_4() {
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{0,0},{1,0}});
        boolean passed = output == 2;
        System.out.println("testSolution2_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_5() {
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{0,0},{0,1}});
        boolean passed = output == 2;
        System.out.println("testSolution2_5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_6() {     
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolution2_6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_7() {     
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-1,5},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolution2_7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_8() {
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}});
        boolean passed = output == 5;
        System.out.println("testSolution2_8: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_9() {
        Solution2 s = new Solution2();
        int output = s.maxPoints(new int[][] {
            {7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},
            {-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},
            {-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},
            {10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},
            {-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},
            {-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},
            {-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},
            {9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},
            {15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},
            {4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},
            {-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},
            {5,-17},{6,-6},{-11,-8}
        });
        boolean passed = output == 6;
        System.out.println("testSolution2_9: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_1() {
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{1,1},{2,2},{3,3}});
        boolean passed = output == 3;
        System.out.println("testSolutionGCD_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_2() {
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});
        boolean passed = output == 4;
        System.out.println("testSolutionGCD_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_3() {
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{0,0}});
        boolean passed = output == 1;
        System.out.println("testSolutionGCD_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_4() {
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{0,0},{1,0}});
        boolean passed = output == 2;
        System.out.println("testSolutionGCD_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_5() {
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{0,0},{0,1}});
        boolean passed = output == 2;
        System.out.println("testSolutionGCD_5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_6() {     
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolutionGCD_6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_7() {     
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-1,5},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolutionGCD_7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_8() {
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}});
        boolean passed = output == 5;
        System.out.println("testSolutionGCD_8: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGCD_9() {
        SolutionGCD s = new SolutionGCD();
        int output = s.maxPoints(new int[][] {
            {7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},
            {-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},
            {-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},
            {10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},
            {-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},
            {-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},
            {-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},
            {9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},
            {15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},
            {4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},
            {-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},
            {5,-17},{6,-6},{-11,-8}
        });
        boolean passed = output == 6;
        System.out.println("testSolutionGCD_9: " + (passed ? "passed" : "failed"));
    }


    public static void testSolutionSlope_1() {
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{1,1},{2,2},{3,3}});
        boolean passed = output == 3;
        System.out.println("testSolutionSlope_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_2() {
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});
        boolean passed = output == 4;
        System.out.println("testSolutionSlope_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_3() {
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{0,0}});
        boolean passed = output == 1;
        System.out.println("testSolutionSlope_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_4() {
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{0,0},{1,0}});
        boolean passed = output == 2;
        System.out.println("testSolutionSlope_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_5() {
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{0,0},{0,1}});
        boolean passed = output == 2;
        System.out.println("testSolutionSlope_5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_6() {     
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolutionSlope_6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_7() {     
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{9,-25},{-4,1},{-1,5},{-7,7}});
        boolean passed = output == 3;
        System.out.println("testSolutionSlope_7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_8() {
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}});
        boolean passed = output == 5;
        System.out.println("testSolutionSlope_8: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionSlope_9() {
        SolutionSlope s = new SolutionSlope();
        int output = s.maxPoints(new int[][] {
            {7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},
            {-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},
            {-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},
            {10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},
            {-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},
            {-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},
            {-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},
            {9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},
            {15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},
            {4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},
            {-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},
            {5,-17},{6,-6},{-11,-8}
        });
        boolean passed = output == 6;
        System.out.println("testSolutionSlope_9: " + (passed ? "passed" : "failed"));
    }
}

