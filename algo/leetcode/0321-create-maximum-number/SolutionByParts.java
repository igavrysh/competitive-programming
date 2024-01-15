import java.util.Arrays;

public class SolutionByParts {

    private int[] maxNums(int[] num, int k) {
        int n = num.length;
        int size = Math.min(k, n);
        int[] res = new int[size];
        int pos = -1;
        for (int i = 0; i < n; i++) {
            while (pos != -1 && res[pos] < num[i] && n-i-1+(pos)+1 >= size) {
                pos--;
            }
            if (pos == size-1) {
                continue;
            }
            res[++pos] = num[i];
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[n+m];
        int n1 = 0; int n2 = 0;

        boolean lastN1IsGreater = false;
        int lastN1Idx = -1;
        int lastN2Idx = -1;

        while (n1+n2 < res.length) {
            if (n1 == nums1.length) {
                res[n1+n2] = nums2[n2++];
            } else if (n2 == nums2.length) {
                res[n1+n2] = nums1[n1++];
            } else {
                if (nums1[n1] < nums2[n2]) {
                    res[n1+n2] = nums2[n2];
                    n2++;
                } else if (nums1[n1] > nums2[n2]) {
                    res[n1+n2] = nums1[n1];
                    n1++;
                } else {
                    int u = 1;
                    boolean n1IsGreater = true;

                    if (n1+u<=lastN1Idx  && n2+u<=lastN2Idx) {
                        n1IsGreater = lastN1IsGreater;
                    } else {
                        while (n1+u < nums1.length || n2+u < nums2.length) {
                            if (n1+u >= nums1.length) {
                                n1IsGreater = false;
                                break;
                            } else if (n2+u >= nums2.length) {
                                n1IsGreater = true;
                                break;
                            } else if (nums1[n1+u] != nums2[n2+u]) {
                                n1IsGreater = nums1[n1+u] > nums2[n2+u];
                                break;
                            }
                            u++;
                        }
                    }
                    lastN1IsGreater = n1IsGreater;
                    lastN1Idx = Math.min(n1+u, nums1.length);
                    lastN2Idx = Math.min(n2+u, nums2.length);

                    if (n1IsGreater) {
                        res[n1+n2] = nums1[n1];
                        n1++;
                    } else {
                        res[n1+n2] = nums2[n2];
                        n2++;
                    }
                }
            }
        }
        return res;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || k-i > nums2.length) {
                continue;
            }

            int[] maxNums1 = maxNums(nums1, i);
            int[] maxNums2 = maxNums(nums2, k-i);

            int[] local = merge(maxNums1, maxNums2);
            
            int pos = 0;
            boolean newMax = false;
            while (pos < local.length) {
                if (max[pos] < local[pos] && !newMax) {
                    newMax = true;
                } else if (max[pos] > local[pos] && !newMax) {
                    break;
                }
                max[pos] = local[pos++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        test5();
        test2();
        test4();
        test1();
        test3();
    }

    public static void test1() {
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;
        int[] expOutput = {9,8,6,5,3};
        SolutionByParts sol = new SolutionByParts();
        int[] output = sol.maxNumber(nums1, nums2, k);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        int k = 5;
        int[] expOutput = {6,7,6,0,4};
        SolutionByParts sol = new SolutionByParts();
        int[] output = sol.maxNumber(nums1, nums2, k);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] nums1 = {3,9};
        int[] nums2 = {8,9};
        int k = 3;
        int[] expOutput = {9,8,9};
        SolutionByParts sol = new SolutionByParts();
        int[] output = sol.maxNumber(nums1, nums2, k);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int[] nums1 = {2,5,6,4,4,0};
        int[] nums2 = {7,3,8,0,6,5,7,6,2};
        int k = 15;
        int[] expOutput = {7,3,8,2,5,6,4,4,0,6,5,7,6,2,0};
        SolutionByParts sol = new SolutionByParts();
        int[] output = sol.maxNumber(nums1, nums2, k);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        int[] nums1 = {5,6,8};
        int[] nums2 = {6,4,0};
        int k = 3;
        int[] expOutput = {8,6,4};
        SolutionByParts sol = new SolutionByParts();
        int[] output = sol.maxNumber(nums1, nums2, k);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }
}
