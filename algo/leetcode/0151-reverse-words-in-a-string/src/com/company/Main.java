package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        Solution sol = new Solution();
        String output = sol.reverseWords("abc dc"); 
        boolean passed = output.equals("dc abc");
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution sol = new Solution();
        String output = sol.reverseWords("abc    dc"); 
        boolean passed = output.equals("dc abc");
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution sol = new Solution();
        String output = sol.reverseWords("abc"); 
        boolean passed = output.equals("abc");
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        Solution sol = new Solution();
        String output = sol.reverseWords(null); 
        boolean passed = output == null;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        Solution sol = new Solution();
        String output = sol.reverseWords("12 df sdf"); 
        boolean passed = output.equals("sdf df 12");
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }
}
