public class SolutionBruteForce {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output = new int[nums.length];
        for (int i = 0; i < n; i++) {
            boolean isSet = false;
            for (int j = 1; j < n; j++) {
                int nextJ = (i+j)%n;
                if (nums[nextJ] > nums[i]) {
                    output[i] = nums[nextJ];
                    isSet = true;
                    break;
                }
            }
            if (!isSet) {
                output[i] = -1;
            }
        }
        return output;
    }
}

