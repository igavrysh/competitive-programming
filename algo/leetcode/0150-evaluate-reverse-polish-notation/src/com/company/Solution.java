package com.company;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equalsIgnoreCase("+") 
                || token.equalsIgnoreCase("-") 
                || token.equalsIgnoreCase("*") 
                || token.equalsIgnoreCase("/")
            ) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("Reached invalid state");
                } 
                nums.push(res);
            } else {
                nums.push(Integer.valueOf(token));
            }
        }
        if (nums.size() != 1) {
            throw new RuntimeException(
                "Result stack should be of size(0) but has invalid size(" + nums.size() + ")"
            );
        } 
        return nums.pop();
    }
}