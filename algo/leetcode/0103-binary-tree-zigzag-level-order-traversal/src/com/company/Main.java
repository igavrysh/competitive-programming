package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        TreeNode node = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20,
                new TreeNode(15),
                new TreeNode(7)
            )
        );
        Solution s = new Solution();
        List<List<Integer>> output = s.zigzagLevelOrder(node);
        boolean passed = output.get(0).equals(Arrays.asList(new Integer[]{3}))
            && output.get(1).equals(Arrays.asList(new Integer[]{20,9}))
            && output.get(2).equals(Arrays.asList(new Integer[]{15,7}))
            && output.size() == 3;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode node = new TreeNode(1);
        Solution s = new Solution();
        List<List<Integer>> output = s.zigzagLevelOrder(node);
        boolean passed = output.get(0).equals(Arrays.asList(new Integer[]{1}))
            && output.size() == 1;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        TreeNode node = null;
        Solution s = new Solution();
        List<List<Integer>> output = s.zigzagLevelOrder(node);
        boolean passed = output.size() == 0;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    //[1,2,3,4,null,null,5]
    // 1
    // 2      3
    // 4 null null 5
    public static void test4() {
        TreeNode node = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                null
            ),
            new TreeNode(3,
                null,
                new TreeNode(5)
            )
        );
        Solution s = new Solution();
        List<List<Integer>> output = s.zigzagLevelOrder(node);
        boolean passed = output.get(0).equals(Arrays.asList(new Integer[]{1}))
            && output.get(1).equals(Arrays.asList(new Integer[]{3,2}))
            && output.get(2).equals(Arrays.asList(new Integer[]{4,5}))
            && output.size() == 3;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        TreeNode node = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5)),
            new TreeNode(3,
                new TreeNode(6),
                new TreeNode(7)
            )
        );
        Solution s = new Solution();
        List<List<Integer>> output = s.zigzagLevelOrder(node);
        boolean passed = output.get(0).equals(Arrays.asList(new Integer[]{1}))
            && output.get(1).equals(Arrays.asList(new Integer[]{3,2}))
            && output.get(2).equals(Arrays.asList(new Integer[]{4,5,6,7}))
            && output.size() == 3;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

}
