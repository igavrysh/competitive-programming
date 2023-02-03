package com.company;
/**
 * algo for quick find: 
 * 1) use first elem as pivot
 * 2) put pivot into last position by swapping it with last elem
 * 3) two indexes i=[s]tart, j=[s]tart
 *  3.1) iterate over j from [s]tart to [e]nd-1, on each iteration compare nums[j] & nums[e] (nums[e] aka pivot)
 *      3.1.1) if nums[j] > nums[e], then i++
 *      3.1.2) if nums[j] <= nums[e], then swap nums[i] & nums[j]; i++; j++
 *  3.2) after j ends itereating over [s..e-1], i will be the perfect palce for pivot (nums[e]), 
 *    swap nums[i] & nums[e] to place pivot into right spot
 *  3.3) continue algo if i != k by either left part {nums[s],...,nums[i-1]} 
 *    or right part {nums[i+1],...,nums[e]} + modify k in case of right part, 
 *    jump to step 1) with s and e reduction
 */
public class SolutionQuickFind {
    // Time: O(N)
    // Space: O(1), with input array modifications
    public int majorityElement(int[] nums) {
        int k = nums.length / 2;
        quickFind(0, nums.length-1, k, nums);
        return nums[k];
    }

    private void quickFind(int s, int e, int k, int[] nums) {
        if (s > e) { return; }
        swap(s, e, nums);
        int i = s, j = s;
        while (j < e) {
            if (nums[j] <= nums[e]) {
                swap(i, j, nums);
                i++;
            }
            j++;
        }
        swap(i, e, nums);

        if (i == k) {
            return;
        }

        if (i < k) {
            quickFind(i+1, e, k-(i-s+1), nums);
        } else {
            quickFind(s, i-1, k, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        if (i==j) { return; }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

