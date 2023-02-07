package com.company;

import java.util.Stack;

public class SolutionStack {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> S = new Stack<>();
        int maxSize = 0;
        int zeroIndex = -1;
        // Last step, i = heights.length is required to process stack of nondecreasing
        // height indexes
        for (int i = 0; i <= heights.length; i++) {

            while (S.size() != 0 && (i == heights.length || heights[S.peek()] > heights[i])) {
                int idx = S.pop();
                int nextSize = 0;
                if (S.size() != 0) {
                    int prevIndex = S.peek();
                    nextSize = (i - prevIndex - 1) * heights[idx];
                } else {
                    nextSize = (i - 1 - zeroIndex) * heights[idx];
                }
                if (maxSize < nextSize) {
                    maxSize = nextSize;
                }
            }

            S.push(i);

            if (i < heights.length && heights[i] == 0) {
                zeroIndex = i;
            }
        }
        return maxSize;
    }

}
