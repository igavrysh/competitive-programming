package com.company;

class Main {
    public static void main(String[] args) {
        testMinStackSolution1();
        testMinStackSolution2();
    }

    public static void testMinStackSolution1() {
        boolean passed = true;
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        passed = passed && (minStack.getMin() == -3); // return -3
        minStack.pop();
        passed = passed && (minStack.top() == 0);    // return 0
        passed = passed && (minStack.getMin() == -2); // return -2
        System.out.println("testMinStackSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testMinStackSolution2() {
        boolean passed = true;
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        passed = passed && (minStack.getMin() == -2); // return -3
        passed = passed && (minStack.top() == -1); // return -3
        minStack.pop();
        passed = passed && (minStack.getMin() == -2); // return -2
        System.out.println("testMinStackSolution2: " + (passed ? "passed" : "failed"));
    }
}