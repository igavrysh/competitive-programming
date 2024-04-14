package com.company;

import java.util.Stack;

public class SolutionStackImproved {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> S = new Stack<>();
        S.push(-1);
        int maxSize = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (S.peek() != -1 && (i == heights.length || heights[S.peek()] > heights[i])) {
                int idx = S.pop();
                int nextSize = 0;
                int prevIndex = S.peek();
                nextSize = (i - prevIndex - 1) * heights[idx];
                if (maxSize < nextSize) {
                    maxSize = nextSize;
                }
            }
            S.push(i);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        SolutionStackImproved s = new SolutionStackImproved();
        int output = s.largestRectangleArea(heights);
        boolean passed = output == 10;
        System.out.println("testStackImproved1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] heights = { 2, 4 };
        SolutionStackImproved s = new SolutionStackImproved();
        int output = s.largestRectangleArea(heights);
        boolean passed = output == 4;
        System.out.println("testStackImproved2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] heights = { 2, 1, 2 };
        SolutionStackImproved s = new SolutionStackImproved();
        int output = s.largestRectangleArea(heights);
        boolean passed = output == 3;
        System.out.println("testStackImproved2: " + (passed ? "passed" : "failed"));
    }
}
