package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testSolution1_1();
        testSolution1_2();
        testSolution1_3();

        testSolution2_1();
        testSolution2_2();
        testSolution2_3();
    }

    public static void testSolution1_1() {
        Solution s = new Solution();
        TreeNode o = s.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{3,9,20,null,null,15,7});
        System.out.println("testSolution1_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_2() {
        Solution s = new Solution();
        TreeNode o = s.buildTree(new int[] {-1}, new int[] {-1});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{-1});
        System.out.println("testSolution1_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_3() {
        Solution s = new Solution();
        TreeNode o = s.buildTree(new int[] {2,1}, new int[] {1,2});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{2, 1});
        System.out.println("testSolution1_3: " + (passed ? "passed" : "failed"));
    }


    public static void testSolution2_1() {
        Solution2 s = new Solution2();
        TreeNode o = s.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{3,9,20,null,null,15,7});
        System.out.println("testSolution2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_2() {
        Solution2 s = new Solution2();
        TreeNode o = s.buildTree(new int[] {-1}, new int[] {-1});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{-1});
        System.out.println("testSolution2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_3() {
        Solution2 s = new Solution2();
        TreeNode o = s.buildTree(new int[] {2,1}, new int[] {1,2});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{2, 1});
        System.out.println("testSolution2_3: " + (passed ? "passed" : "failed"));
    }
}
