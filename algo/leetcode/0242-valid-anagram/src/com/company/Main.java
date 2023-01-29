package com.company;

class Main {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        String s = "anagram", t = "nagaram";
        Solution solution = new Solution();
        boolean isAnagram = solution.isAnagram(s, t);
        boolean passed = isAnagram == true;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s = "rat", t = "car";
        Solution solution = new Solution();
        boolean isAnagram = solution.isAnagram(s, t);
        boolean passed = isAnagram == false;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}