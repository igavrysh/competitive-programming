package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    public static void testSolution_1() {
        Solution s = new Solution();
        TreeNode o = s.buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{3,9,20,null,null,15,7});
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        Solution s = new Solution();
        TreeNode o = s.buildTree(new int[] {-1}, new int[] {-1});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{-1});
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        Solution s = new Solution();
        TreeNode o = s.buildTree(new int[] {1,2}, new int[] {1,2});
        List<Integer> outputList = TreeNode.toList(o);
        boolean passed = Arrays.deepEquals(outputList.toArray(), new Integer[]{2, 1});
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }
    
}
