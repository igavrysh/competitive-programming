import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] output = new int[k];
        int index = 0;
        int n1Index = 0;
        int n2Index = 0;
        int n1 = nums1.length - 1;
        int n2 = nums2.length - 1;
        while (index < k) {

            if (n1Index < nums1.length && n2Index < nums2.length) {
                if (nums1[n1 - n1Index] >= nums2[n2 - n2Index]) {
                    output[index] = nums1[n1 - n1Index];
                    n1Index += 1;
                } else {
                    output[index] = nums2[n2 - n2Index];
                    n2Index += 1;
                }
            } else if (n1Index < nums1.length) {
                output[index] = nums1[n1 - n1Index];
                n1Index += 1;
            } else if (n2Index < nums2.length) {
                output[index] = nums2[n2 - n2Index];
                n2Index += 1;
            }
            index++;
        }
        return output;
    }

    public static void test1() {
        int[] nums1 = new int[] { 3, 4, 6, 5 };
        int[] nums2 = new int[] { 9, 1, 2, 5, 8, 3 };
        Solution solution = new Solution();
        int[] output = solution.maxNumber(nums1, nums2, 5);
        boolean passed = output.length == 5
                && output[0] == 9
                && output[1] == 8
                && output[2] == 6
                && output[3] == 5
                && output[4] == 3;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums1 = new int[] { 6, 7 };
        int[] nums2 = new int[] { 6, 0, 4 };
        Solution solution = new Solution();
        int[] output = solution.maxNumber(nums1, nums2, 5);
        boolean passed = output.length == 5
                && output[0] == 6
                && output[1] == 7
                && output[2] == 6
                && output[3] == 0
                && output[4] == 4;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] nums1 = new int[] { 3, 9 };
        int[] nums2 = new int[] { 8, 9 };
        Solution solution = new Solution();
        int[] output = solution.maxNumber(nums1, nums2, 3);
        boolean passed = output.length == 3
                && output[0] == 9
                && output[1] == 8
                && output[2] == 9;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
