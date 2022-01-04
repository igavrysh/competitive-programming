package com.company;

public class Main {

    public static void test1() {
        Solution solution = new Solution();
        boolean verified = solution.maxProduct(new int[]{1, 2, 3}) == 6;
        System.out.println(verified ? "test1 passed" : "test1 failed");
    }

    public static void test2() {
        Solution solution = new Solution();
        boolean verified = solution.maxProduct(new int[]{1, 0, 3}) == 3;
        System.out.println(verified ? "test2 passed" : "test2 failed");
    }

    public static void test3() {
        Solution solution = new Solution();
        boolean verified = solution.maxProduct(new int[]{2, 4, 0, 3, 2}) == 8;
        System.out.println(verified ? "test3 passed" : "test3 failed");
    }

    public static void test4() {
        Solution solution = new Solution();
        boolean verified = solution.maxProduct(new int[]{0}) == 0;
        System.out.println(verified ? "test4 passed" : "test4 failed");
    }

    public static void test5() {
        Solution solution = new Solution();
        boolean verified = solution.maxProduct(new int[]{0, 1, 2, 3, 0, 2, 4, 0, 1}) == 8;
        System.out.println(verified ? "test5 passed" : "test5 failed");
    }

    public static void test6() {
        Solution solution = new Solution();
        boolean verified = solution.maxProduct(new int[]{2, 3, -2, 4}) == 6;
        System.out.println(verified ? "test6 passed" : "test6 failed");
    }

    public static void test7() {
        Solution solution = new Solution();
        boolean verified = solution.maxProduct(new int[]{-2, 0, -1}) == 0;
        System.out.println(verified ? "test7 passed" : "test7 failed");
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
