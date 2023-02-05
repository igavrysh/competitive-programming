package com.company;

import java.util.Stack;

class SolutionMonotonicStack {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (S.size() > 0 && temperatures[S.peek()] < temperatures[i]) {
                int idx = S.pop();
                output[idx] = i-idx;
            }
            S.push(i);
        }
        return output;
    }
}