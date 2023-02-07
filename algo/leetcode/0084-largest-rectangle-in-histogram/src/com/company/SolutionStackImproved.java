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
}
