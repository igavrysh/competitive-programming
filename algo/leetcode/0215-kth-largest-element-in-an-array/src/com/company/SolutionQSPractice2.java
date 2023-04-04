package com.company;

import java.util.Arrays;
import java.util.Random;

public class SolutionQSPractice2 {

    public static void main(String[] args) {
        testQuickSort1();
        testSolutionQSPractice2_1();
        testSolutionQSPractice2_2();
        testSolutionQSPractice2_3();
        testSolutionQSPractice2_4();
    }

    private Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(0, nums.length-1, nums, nums.length-k+1);
    }

    private int findKthLargest(int l, int r, int[] nums, int k) {
        int p = partition(l, r, nums);
        if (p==k-1) {
            return nums[p];
        } else if (p<k-1) {
            return findKthLargest(p+1, r, nums, k);
        } else {
            return findKthLargest(l, p-1, nums, k);
        }
    }

    private int partition(int l, int r, int[] nums) {
        if (l==r) {
            return l;
        }
        int p = l + rand.nextInt(r-l);
        System.out.println("l:" + l + "; r:" + r + "; p:" + p);

        swap(l, p, nums);
        int i = l;
        int j = r+1;
        while (true) {
            while (nums[++i] < nums[l]) {
                if (i==r) {
                    break;
                }
            }
            while (nums[--j] > nums[l]) {
                if (j==l) {
                    break;
                }
            }
            if (i>=j) {
                break;
            }
            swap(i, j, nums);
        }
        swap(l, j, nums);
        return j;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void quickSort(int l, int r, int[] nums) {
        if (l>=r) return;
        int p = partition(l, r, nums);
        quickSort(l, p-1, nums);
        quickSort(p+1, r, nums);
    }

    public void quickSort(int[] nums) {
        quickSort(0, nums.length-1, nums);
    }

    private static void testQuickSort1() {
        SolutionQSPractice2 s = new SolutionQSPractice2();
        int[] a = new int[] {101, 3, 3, 1, 2, 3, 2, 10};
        int[] expectedOutput = Arrays.copyOf(a, a.length);
        Arrays.sort(expectedOutput);
        s.quickSort(a);
        boolean passed = Arrays.equals(a, expectedOutput);
        System.out.println("testQuickSort1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionQSPractice2_1() {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        SolutionQSPractice2 s = new SolutionQSPractice2();
        int output = s.findKthLargest(nums, 2);
        boolean passed = output == 5;
        System.out.println("testSolutionQSPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionQSPractice2_2() {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        SolutionQSPractice2 s = new SolutionQSPractice2();
        int output = s.findKthLargest(nums, 4);
        boolean passed = output == 4;
        System.out.println("testSolutionQSPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionQSPractice2_3() {
        int[] nums = { 7, 6, 5, 4, 3, 2, 1 };
        SolutionQSPractice2 s = new SolutionQSPractice2();
        int output = s.findKthLargest(nums, 2);
        boolean passed = output == 6;
        System.out.println("testSolutionQSPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionQSPractice2_4() {
        int[] nums = { 1 };
        SolutionQSPractice2 s = new SolutionQSPractice2();
        int output = s.findKthLargest(nums, 1);
        boolean passed = output == 1;
        System.out.println("testSolutionQSPractice2_4: " + (passed ? "passed" : "failed"));
    }
    
}
