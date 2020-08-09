package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void test1() {
        TreeNode tree = new TreeNode(
                1,
                null,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        null));
        Solution solution = new Solution();
        List<Integer> output = solution.inorderTraversal(tree);
        Integer[] expectedResult = new Integer[]{1, 3, 2};
        boolean checked = Arrays.equals(output.toArray(), expectedResult);
        System.out.println(checked ? "test1 passed" : "test1 failed");
    }

    public static void test2() {
        TreeNode tree = new TreeNode(
                1,
                null,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        null));
        SolutionResultPassedAsArgument solution = new SolutionResultPassedAsArgument();
        List<Integer> output = solution.inorderTraversal(tree);
        Integer[] expectedResult = new Integer[]{1, 3, 2};
        boolean checked = Arrays.equals(output.toArray(), expectedResult);
        System.out.println(checked ? "test2 passed" : "test2 failed");
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
