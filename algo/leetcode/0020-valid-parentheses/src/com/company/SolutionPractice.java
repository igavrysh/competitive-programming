package com.company;

import java.util.Stack;

public class SolutionPractice {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.size() == 0) {
                    return false;
                }
                char stackCh = stack.pop();
                if ((stackCh == '{' && ch == '}') 
                    || (stackCh == '(' && ch == ')') 
                    || (stackCh == '[' && ch == ']')) 
                {
                    continue;
                }  else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}