import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        int[][] a = new int[N][3];
        for (int i = 0; i < N; i++) {
            a[i][0] = nums[i];
            a[i][2] = i;
        }

        int[][] result = mergeCount(0, nums.length-1, a);
        List<Integer> list = new ArrayList<>(a.length);
        for (int i = 0; i < result.length; i++) {
            list.add(0);
        }
        for (int i = 0; i < result.length; i++) {
            list.set(result[i][2], result[i][1]);
        }
        return list;
    }

    private int[][] mergeCount(int l, int r, int[][] a) {
        if (r==l) {
            int res[][] = new int[1][3];
            res[0] = a[l];
            return res;
        }

        int m = l + (r-l+1)/2;
        int[][] la = mergeCount(l, m-1, a);
        int[][] ra = mergeCount(m, r, a);

        int[][] res = new int[la.length+ra.length][3];
        int i = 0, j = 0;
        while (i < la.length || j < ra.length) {
            if (i == la.length) {
                res[i+j] = ra[j];
                j++;
                continue;
            }
            
            if (j == ra.length) {
                res[i+j] = la[i];
                i++;
                continue;
            }

            if (la[i][0] <= ra[j][0]) {
                res[i+j] = ra[j];
                j++;
            } else {
                res[i+j] = la[i];
                res[i+j][1] += (ra.length-j);
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        test1();
        test3();
        test2();
    }

    public static void test1() {
        int[] nums = {5,2,6,1};
        int[] expOutputA = {2,1,1,0};
        List<Integer> expOutput = new ArrayList<>(nums.length) {{
            for (int i = 0; i < expOutputA.length; i++) {
                add(expOutputA[i]);
            }
        }};
        Solution sol = new Solution();
        List<Integer> output = sol.countSmaller(nums);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {-1,-1};
        int[] expOutputA = {0,0};
        List<Integer> expOutput = new ArrayList<>(nums.length) {{
            for (int i = 0; i < expOutputA.length; i++) {
                add(expOutputA[i]);
            }
        }};
        Solution sol = new Solution();
        List<Integer> output = sol.countSmaller(nums);
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] nums = {2,0,1};
        int[] expOutputA = {2,0,0};
        List<Integer> expOutput = new ArrayList<>(nums.length) {{
            for (int i = 0; i < expOutputA.length; i++) {
                add(expOutputA[i]);
            }
        }};
        Solution sol = new Solution();
        List<Integer> output = sol.countSmaller(nums);
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}