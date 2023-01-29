package com.company;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution s = new Solution();
        boolean output = s.containsDuplicate(new int[]{1,2,3,1});
        boolean passed = output == true;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        boolean output = s.containsDuplicate(new int[]{1,2,3,4});
        boolean passed = output == false;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        boolean output = s.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
        boolean passed = output == true;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}