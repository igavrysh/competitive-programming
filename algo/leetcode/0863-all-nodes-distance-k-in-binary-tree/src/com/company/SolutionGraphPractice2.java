package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionGraphPractice2 {

    public static void main(String[] args) {
        testSolutionGraphPractice2_1();
        testSolutionGraphPractice2_2();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        dfsMapParents(root, parents);

        HashSet<TreeNode> seen = new HashSet<>();
        seen.add(target);
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(target);
        int distance = 0;
        List<Integer> output = new ArrayList<>();
        while (!Q.isEmpty()) {
            int l = Q.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = Q.poll();
                if (distance == k) {
                    output.add(node.val);
                } else {
                    if (node.left != null && !seen.contains(node.left)) {
                        Q.offer(node.left);
                        seen.add(node.left);
                    }
                    if (node.right != null && !seen.contains(node.right)) {
                        Q.offer(node.right);
                        seen.add(node.right);
                    }
                    TreeNode parent = parents.get(node);
                    if (parent != null && !seen.contains(parent)) {
                        Q.offer(parent);
                        seen.add(parent);
                    } 
                }
            }
            distance++;
        }
        return output;
    }

    private void dfsMapParents(TreeNode node, HashMap<TreeNode, TreeNode> parents) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            parents.put(node.left, node);
            dfsMapParents(node.left, parents);
        }

        if (node.right != null) {
            parents.put(node.right, node);
            dfsMapParents(node.right, parents);
        }
    }

    public static void testSolutionGraphPractice2_1() {
        TreeNode target 
            =  new TreeNode(5, 
                new TreeNode(6), 
                new TreeNode(2, 
                    new TreeNode(7), 
                    new TreeNode(4)));
        TreeNode root 
            = new TreeNode(3, 
                target, 
                new TreeNode(1, 
                    new TreeNode(0), 
                    new TreeNode(8)));
        SolutionGraphPractice2 sol = new SolutionGraphPractice2();
        int k = 2;
        List<Integer> output = sol.distanceK(root, target, k);
        Integer[] outputArr = new Integer[output.size()];
        for (int i = 0; i < output.size(); i++) {
            outputArr[i] = output.get(i);
        }
        Arrays.sort(outputArr);
        Integer[] expectedOutput = { 7, 4, 1 };
        Arrays.sort(expectedOutput);
        boolean passed = Arrays.deepEquals(outputArr, expectedOutput);
        System.out.println("testSolutionGraphPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGraphPractice2_2() {
        TreeNode target = new TreeNode(1);
        TreeNode root = target;
        SolutionGraphPractice2 sol = new SolutionGraphPractice2();
        int k = 3;
        List<Integer> output = sol.distanceK(root, target, k);
        Integer[] outputArr = new Integer[output.size()];
        for (int i = 0; i < output.size(); i++) {
            outputArr[i] = output.get(i);
        }
        Arrays.sort(outputArr);
        Integer[] expectedOutput = {};
        Arrays.sort(expectedOutput);
        boolean passed = Arrays.deepEquals(outputArr, expectedOutput);
        System.out.println("testSolutionGraphPractice2_2: " + (passed ? "passed" : "failed"));
    }
}
