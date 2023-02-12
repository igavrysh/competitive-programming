package com.company;

import java.util.Stack;

public class SolutionStack {
    class Pair {
        public int height;
        public int idx;
        public Pair(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(height[0], 0));
        int output = 0;
        for (int i = 1; i < height.length; i++) {
            Pair sPair = null;
            while (s.size()>0 && s.peek().height<=height[i]) {
                sPair = s.pop();
                if (s.size() > 0) {
                    output += (Math.min(s.peek().height, height[i]) - sPair.height) * (i - sPair.idx);
                }
            }
            if (sPair != null) {
                s.push(new Pair(height[i], sPair.idx));
            } else {
                s.push(new Pair(height[i], i));
            }
        }

        return output;
    }
}