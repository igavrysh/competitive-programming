package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution s = new Solution();
        List<TreeNode> output = s.generateTrees(3);

        List<List<Integer>> actualOutput = new ArrayList<>();
        for (int i = 0; i < output.size(); i++) {
            actualOutput.add(TreeNode.toList(output.get(i)));
        }
        // [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
        List<List<Integer>> expectedOutput = Arrays.asList(new List[] {
            Arrays.asList(new Integer[] {1,null,2,null,3}),
            Arrays.asList(new Integer[] {1,null,3,2}),
            Arrays.asList(new Integer[] {2,1,3}),
            Arrays.asList(new Integer[] {3,1,null,null,2}),
            Arrays.asList(new Integer[] {3,2,null,1})
        });

        System.out.println("test1: " + (matched(expectedOutput, actualOutput) ? "passed" : "failed"));        
    }

    public static void test2() {
        Solution s = new Solution();
        List<TreeNode> output = s.generateTrees(1);

        List<List<Integer>> actualOutput = new ArrayList<>();
        for (int i = 0; i < output.size(); i++) {
            actualOutput.add(TreeNode.toList(output.get(i)));
        }
        // [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
        List<List<Integer>> expectedOutput = Arrays.asList(new List[] {
            Arrays.asList(new Integer[] {1})
        });

        System.out.println("test2: " + (matched(expectedOutput, actualOutput) ? "passed" : "failed"));        
    }

    private static boolean matched(List<List<Integer>> expectedOutput, List<List<Integer>> actualOutput) {
        int matched = 0;
        if (expectedOutput.size() == actualOutput.size()) {
            for (int i = 0; i < actualOutput.size(); i++) {
                for (int j = 0; j < expectedOutput.size(); j++) {
                    List<Integer> a = actualOutput.get(i);
                    List<Integer> e = expectedOutput.get(j);
                    int currentMatched = 0;
                    if (a.size() == e.size()) {
                        for (int h = 0; h < a.size(); h++) {
                            if ((a.get(h) == null && e.get(h) == null) 
                                || a.get(h) != null && a.get(h).equals(e.get(h))) {
                                currentMatched++;
                            }
                        }
                    }
                    if (currentMatched == e.size()) {
                        matched++;
                    }
                }
            }
        }
        return matched == expectedOutput.size();
    }
}
