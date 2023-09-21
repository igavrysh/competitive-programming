/*
 * Time complexity: O(NlogN) ~ 5*10^5 * log2(5*10^5) ~= 9.8 x 10^6 ~= 10^7
 * e.g. remove from heap is log(N), add to heap is log(N), initially we can do heapify for maxRightHeap with O(N) 
 * but still need to add, remove nums from the heap with log(N) every i, with NlogN total time complexity
 * Time Limit Exceeded as its close to threshold and leetcode has crappy run quotas for non premium access
 * Space complexity: O(N)
 */

import java.util.PriorityQueue;

class Solution2Heap {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int n = nums.length;

        PriorityQueue<Integer> maxRightHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeapLeft = new PriorityQueue<>((a, b) -> a - b);

        for (int k = n-1; k >= 1; k--) {
            maxRightHeap.add(nums[k]);
        }
        minHeapLeft.add(nums[0]);

        for (int i = 1; i < n-1; i++) {
            maxRightHeap.remove(nums[i]);
            int right = maxRightHeap.peek();
            int left = minHeapLeft.peek();
            if (left < nums[i] && nums[i] < right) {
                return true;
            }
            minHeapLeft.add(nums[i]);
        }

        return false;
    }
}