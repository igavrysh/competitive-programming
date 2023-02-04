package com.company;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> S;
    private Stack<Integer> minS;

    public MinStack() {
        S = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int val) {
        int min = S.size() > 0 ? Math.min(val, minS.peek()) : val;
        S.push(val);
        minS.push(min);
    }
    
    public void pop() {
        S.pop();
        minS.pop();
    }
    
    public int top() {
        return S.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}
