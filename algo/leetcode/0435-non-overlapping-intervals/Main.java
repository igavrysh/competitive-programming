class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
        testSolutionOptimized1();
        testSolutionOptimized2();
        testSolutionOptimized3();
    }

    public static void testSolution1() {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        Solution s = new Solution();
        int output = s.eraseOverlapIntervals(intervals);
        boolean passed = output == 1;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        int[][] intervals = {{1,2},{1,2},{1,2}};
        Solution s = new Solution();
        int output = s.eraseOverlapIntervals(intervals);
        boolean passed = output == 2;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        int[][] intervals = {{1,2},{2,3}};
        Solution s = new Solution();
        int output = s.eraseOverlapIntervals(intervals);
        boolean passed = output == 0;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized1() {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        SolutionOptimized s = new SolutionOptimized();
        int output = s.eraseOverlapIntervals(intervals);
        boolean passed = output == 1;
        System.out.println("testSolutionOptimized1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized2() {
        int[][] intervals = {{1,2},{1,2},{1,2}};
        SolutionOptimized s = new SolutionOptimized();
        int output = s.eraseOverlapIntervals(intervals);
        boolean passed = output == 2;
        System.out.println("testSolutionOptimized2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized3() {
        int[][] intervals = {{1,2},{2,3}};
        SolutionOptimized s = new SolutionOptimized();
        int output = s.eraseOverlapIntervals(intervals);
        boolean passed = output == 0;
        System.out.println("testSolutionOptimized3: " + (passed ? "passed" : "failed"));
    }

    

}




// [1,2],[2,3],[3,4],[1,3]


// 1 2 2 3