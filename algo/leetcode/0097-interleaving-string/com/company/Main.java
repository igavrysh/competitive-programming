package com.company;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Solution s = new Solution();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Solution s = new Solution();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s1 = "", s2 = "", s3 = "";
        Solution s = new Solution();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == true;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Solution s = new Solution();
        boolean result = s.isInterleave(s1, s2, s3);
        boolean passed = result == false;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}
