import java.util.TreeMap;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int N = nums.length;
        TreeMap<Integer, Integer> w = new TreeMap<>();
        int l = 0;
        for (int i = 0; i < N; i++) {
            while ((i-l) > indexDiff) {
                w.compute(nums[l], (key, fq) -> {
                    if (fq == 1) {
                        return null;
                    } else {
                        return fq-1;
                    }
                });
                l++;
            }

            final boolean[] containsSame = {false};

            w.compute(nums[i], (key, fq) -> {
                if (fq == null) {
                    return 1;
                } else {
                    containsSame[0] = true;
                    return fq + 1;
                }
            });
            
            if (containsSame[0]) {
                return true;
            }

            Integer lower = w.lowerKey(nums[i]);
            if (lower != null && Math.abs(nums[i] - lower) <= valueDiff) {
                return true;
            }

            Integer higher = w.higherKey(nums[i]);
            if (higher != null && Math.abs(nums[i] - higher) <= valueDiff) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int[] nums = {1,2,3,1};
        int indexDiff = 3;
        int valueDiff = 0;
        boolean expOutput = true;
        Solution sol = new Solution();
        boolean output = sol.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {1,5,9,1,5,9};
        int indexDiff = 2;
        int valueDiff = 3;
        boolean expOutput = false;
        Solution sol = new Solution();
        boolean output = sol.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}