import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> c = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            c.add(0);
        }

        if (nums.length > 1) {
            mergeCount(0, nums.length-1, c, nums);
        }
        return c;
    }

    private void mergeCount(int l, int r, List<Integer> c, int[] nums) {
        if (r==l) {
            return;
        }

        int m = l + (r-l+1)/2;
        mergeCount(l, m-1, c, nums);
        mergeCount(m, r, c, nums);

        int i = l;
        int j = m;
        while (i < m && j <= r) {
            if (nums[i] > nums[j]) {
                c.set(i, c.get(i) + c.get(j) + 1);
                i++;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        test3();
        test1();
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