package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void test1() {
        Solution s = new Solution();
        List<String> output = s.restoreIpAddresses("012201");
        List<String> expected = new ArrayList<>() {{
            add("0.1.2.201");
            add("0.1.220.1");
            add("0.122.0.1");
            add("0.12.20.1");
        }};
        boolean passed = output.size() == expected.size() && output.containsAll(expected);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        List<String> output = s.restoreIpAddresses("25525511135");
        List<String> expected = Arrays.asList(new String[] {"255.255.11.135", "255.255.111.35"});
        boolean passed = output.size() == expected.size() && output.containsAll(expected);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        List<String> output = s.restoreIpAddresses("0000");
        List<String> expected = Arrays.asList(new String[] {"0.0.0.0"});
        boolean passed = output.size() == expected.size() && output.containsAll(expected);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        Solution s = new Solution();
        List<String> output = s.restoreIpAddresses("101023");
        List<String> expected = Arrays.asList(new String[] {"1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"});
        boolean passed = output.size() == expected.size() && output.containsAll(expected);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
