package com.company;

import java.util.List;

public class Main {

    public static void test1() {
        String input = "a1b2";
        Solution s = new Solution();
        List<String> output = s.letterCasePermutation(input);
        boolean passed = output.size() == 4
            && output.contains("a1b2")
            && output.contains("a1B2")
            && output.contains("A1b2")
            && output.contains("A1B2");
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
	      test1();
    }
}
