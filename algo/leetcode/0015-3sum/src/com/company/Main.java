package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
        testSolutionPractice2_6();
        testSolutionPractice2_7();
        testSolutionPractice2_8();
        testSolutionPractice2_9();
    }

    public static void test1() {
        Solution s = new Solution();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 2
                && output.contains(Arrays.asList(new Integer[] { -1, -1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        List<List<Integer>> output = s.threeSum(new int[] {});
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        List<List<Integer>> output = s.threeSum(new int[] { 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 2
                && output.contains(Arrays.asList(new Integer[] { -1, -1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] {});
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("testSolutionPractice2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 0;
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { 0, 0, 0, 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 1
                && output.contains(Arrays.asList(new Integer[] { 0, 0, 0 }));
        System.out.println("testSolutionPractice2_4:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_5() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { 1, -1, -1, 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 1
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_5:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_6() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 0 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 1
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_6:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_7() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -2, 0, 1, 1, 2 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 2
                && output.contains(Arrays.asList(new Integer[] { -2, 0, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -2, 1, 1 }));
        System.out.println("testSolutionPractice2_7:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_8() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 });
        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == 9
                && output.contains(Arrays.asList(new Integer[] { -4, 0, 4 }))
                && output.contains(Arrays.asList(new Integer[] { -4, 1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -3, -1, 4 }))
                && output.contains(Arrays.asList(new Integer[] { -3, 0, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -3, 1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -2, -1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -2, 0, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, -1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_8:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_9() {
        int[] input = new int[] {
            34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,
            94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,
            -82,76,26,15,-29,36,-29,10,-70,69,17,49 };
        int[][] expectedArr = new int[][] {
            {-82,-11,93},{-82,13,69},{-82,17,65},{-82,21,61},{-82,26,56},{-82,33,49},
            {-82,34,48},{-82,36,46},{-70,-14,84},{-70,-6,76},{-70,1,69},{-70,13,57},
            {-70,15,55},{-70,21,49},{-70,34,36},{-66,-11,77},{-66,-3,69},{-66,1,65},
            {-66,10,56},{-66,17,49},{-49,-6,55},{-49,-3,52},{-49,1,48},{-49,2,47},
            {-49,13,36},{-49,15,34},{-49,21,28},{-43,-14,57},{-43,-6,49},{-43,-3,46},
            {-43,10,33},{-43,12,31},{-43,15,28},{-43,17,26},{-29,-14,43},{-29,1,28},
            {-29,12,17},{-14,-3,17},{-14,1,13},{-14,2,12},{-11,-6,17},{-11,1,10},{-3,1,2}
        };

        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.threeSum(input);

        output = output.stream().map(x -> {
            Collections.sort(x);
            return x;
        }).collect(Collectors.toList());
        boolean passed = output.size() == expectedArr.length
                && output.contains(Arrays.asList(new Integer[] { -4, 0, 4 }))
                && output.contains(Arrays.asList(new Integer[] { -4, 1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -3, -1, 4 }))
                && output.contains(Arrays.asList(new Integer[] { -3, 0, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -3, 1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -2, -1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { -2, 0, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, -1, 2 }))
                && output.contains(Arrays.asList(new Integer[] { -1, 0, 1 }));
        System.out.println("testSolutionPractice2_9:" + (passed ? "passed" : "failed"));
    }
}
