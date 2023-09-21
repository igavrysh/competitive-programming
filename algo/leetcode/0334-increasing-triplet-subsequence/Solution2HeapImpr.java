/* 
 * This is solution is a little improvement over prev solution with Heap. Intuition: the most costly operation is
 * add / remove from the heap that I do n times, so ~O(NlogN). What if I can reduce N, by storing duplicates in 
 * HashMap with frequencies as values, and nums themselves as values
 * Time complexity = O(NlogN) / Space complexity = O(N), & is +- the same, but we can get rid of test cases that have duplicates
 * This solution is now passing leetcode tests / but on the edge
 */

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution2HeapImpr {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int n = nums.length;

        HashMap<Integer, Integer> rightFq = new HashMap<>();
        PriorityQueue<Integer> maxRightHeap = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Integer, Integer> leftFq = new HashMap<>();
        PriorityQueue<Integer> minHeapLeft = new PriorityQueue<>((a, b) -> a - b);

        for (int k = n-1; k >= 1; k--) {
            if (rightFq.getOrDefault(nums[k], 0) == 0) {
                maxRightHeap.add(nums[k]);
            }
            rightFq.put(nums[k], rightFq.getOrDefault(nums[k], 0) + 1);
        }
        minHeapLeft.add(nums[0]);
        leftFq.put(nums[0], 1);

        for (int i = 1; i < n-1; i++) {
            rightFq.put(nums[i], rightFq.get(nums[i])-1);
            if (rightFq.get(nums[i]) == 0) {
                maxRightHeap.remove(nums[i]);
            }

            int right = maxRightHeap.peek();
            int left = minHeapLeft.peek();
            if (left < nums[i] && nums[i] < right) {
                return true;
            }

            if (leftFq.getOrDefault(nums[i], 0) == 0) {
                minHeapLeft.add(nums[i]);
            }
            leftFq.put(nums[i], leftFq.getOrDefault(nums[i], 0) + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        testSolution2Heap1();
        testSolution2Heap2();
        testSolution2Heap3();
        testSolution2Heap4();
    }

    public static void testSolution2Heap1() {
        int[] nums = {1,2,3,4,5};
        Solution2HeapImpr s = new Solution2HeapImpr();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution2Heap1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2Heap2() {
        int[] nums = {5,4,3,2,1};
        Solution2HeapImpr s = new Solution2HeapImpr();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution2Heap2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2Heap3() {
        int[] nums = {2,1,5,0,4,6};
        Solution2HeapImpr s = new Solution2HeapImpr();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution2Heap3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2Heap4() {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution2HeapImpr s = new Solution2HeapImpr();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution2Heap4: " + (passed ? "passed" : "failed"));
    }
}
