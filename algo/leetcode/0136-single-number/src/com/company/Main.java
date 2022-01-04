package com.company;

public class Main {

    public static void test1() {
        int[] input = new int[]{2, 2, 1};
        Solution solution = new Solution();
        boolean checked = solution.singleNumber(input) == 1;
        System.out.println("test1:" + (checked ? "passed" : "failed"));
    }

    public static void test2() {
        int[] input = new int[]{4, 1, 2, 1, 2};
        Solution solution = new Solution();
        boolean checked = solution.singleNumber(input) == 4;
        System.out.println("test2:" + (checked ? "passed" : "failed"));
    }

    public static void test3() {
        int[] input = new int[]{2, 2, 1};
        SolutionConstantMemory solution = new SolutionConstantMemory();
        boolean checked = solution.singleNumber(input) == 1;
        System.out.println("test3:" + (checked ? "passed" : "failed"));
    }

    public static void test4() {
        int[] input = new int[]{4, 1, 2, 1, 2};
        SolutionConstantMemory solution = new SolutionConstantMemory();
        boolean checked = solution.singleNumber(input) == 4;
        System.out.println("test4:" + (checked ? "passed" : "failed"));
    }

    public static void test5() {
        int[] input = new int[]{0};
        SolutionConstantMemory solution = new SolutionConstantMemory();
        boolean checked = solution.singleNumber(input) == 0;
        System.out.println("test5:" + (checked ? "passed" : "failed"));
    }

    public static void test6() {
        int[] input = new int[]{0, 0, 1};
        SolutionConstantMemory solution = new SolutionConstantMemory();
        boolean checked = solution.singleNumber(input) == 1;
        System.out.println("test6:" + (checked ? "passed" : "failed"));
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
