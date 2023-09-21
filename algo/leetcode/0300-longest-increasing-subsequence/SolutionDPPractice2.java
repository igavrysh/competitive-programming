
public class SolutionDPPractice2 {
    public int lengthOfLIS(int[] nums) {
        int n  = nums.length;
        // DP[i] = longest incr subsequence that ends with nums[i]
        int[] DP = new int[n]; 
        int output = 1;
        for (int i = 0; i < n; i++) {
            int longest = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    longest = Math.max(longest, DP[j]);
                }
            }
            DP[i] = 1+longest;
            output = Math.max(output, DP[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        testSolutionDPPractice2_1();
        testSolutionDPPractice2_2();
        testSolutionDPPractice2_3();
    }

    private static void testSolutionDPPractice2_1() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int expOutput = 4;
        SolutionDPPractice2 sol = new SolutionDPPractice2();
        int output = sol.lengthOfLIS(nums);
        boolean passed = output == expOutput;
        System.out.println("testSolutionDPPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_2() {
        int[] nums = {0,1,0,3,2,3};
        int expOutput = 4;
        SolutionDPPractice2 sol = new SolutionDPPractice2();
        int output = sol.lengthOfLIS(nums);
        boolean passed = output == expOutput;
        System.out.println("testSolutionDPPractice2_2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDPPractice2_3() {
        int[] nums = {7,7,7,7,7,7,7};
        int expOutput = 1;
        SolutionDPPractice2 sol = new SolutionDPPractice2();
        int output = sol.lengthOfLIS(nums);
        boolean passed = output == expOutput;
        System.out.println("testSolutionDPPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
