package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();

        testSolutionPrevNodeOptimized1();
        testSolutionPrevNodeOptimized2();
        testSolutionPrevNodeOptimized3();
    }

    private static void testSolutionPrevNodeOptimized1() {
        TreeNode tn = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        SolutionPrevNodeOptimized s = new SolutionPrevNodeOptimized();
        int output = s.minDiffInBST(tn);
        boolean passed = output == 1;
        System.out.println("testSolutionPrevNodeOptimized1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPrevNodeOptimized2() {
        TreeNode tn = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        SolutionPrevNodeOptimized s = new SolutionPrevNodeOptimized();
        int output = s.minDiffInBST(tn);
        boolean passed = output == 1;
        System.out.println("testSolutionPrevNodeOptimized2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPrevNodeOptimized3() {
        TreeNode tn = new TreeNode(27, null, new TreeNode(34, null, new TreeNode(58, new TreeNode(50, new TreeNode(44), null), null)));
        SolutionPrevNodeOptimized s = new SolutionPrevNodeOptimized();
        int output = s.minDiffInBST(tn);
        boolean passed = output == 6;
        System.out.println("testSolutionPrevNodeOptimized3: " + (passed ? "passed" : "failed"));
    }

    private static void testSolution1() {
        TreeNode tn = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        SolutionList s = new SolutionList();
        int output = s.minDiffInBST(tn);
        boolean passed = output == 1;
        System.out.println("testSolutionList1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolution2() {
        TreeNode tn = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        SolutionList s = new SolutionList();
        int output = s.minDiffInBST(tn);
        boolean passed = output == 1;
        System.out.println("testSolutionList2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolution3() {
        TreeNode tn = new TreeNode(27, null, new TreeNode(34, null, new TreeNode(58, new TreeNode(50, new TreeNode(44), null), null)));
        SolutionList s = new SolutionList();
        int output = s.minDiffInBST(tn);
        boolean passed = output == 6;
        System.out.println("testSolutionList3: " + (passed ? "passed" : "failed"));
    }

    
}