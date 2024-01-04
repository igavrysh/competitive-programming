public class SolutionIterativeDP {

    public int maxCoins(int[] nums) {
        int[] DP = new int[nums.length];
        int[] S = new int[nums.length];
        DP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            S[0] = nums[i];
            for (int j = 1; j <= i; j++) {
                S[j] = Math.max(
                    nums[j] * (j > 1 ? nums[j - 1] : 1) + DP[j - 1], 
                    nums[j] * (j > 1 ? nums[j - 1] : 1) * (j >= 2 ? nums[j - 2] : 1) + S[j - 1]);
            }
            DP[i] = S[i];
        }
        return DP[nums.length - 1];
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        SolutionIterativeDP s = new SolutionIterativeDP();
        int output = s.maxCoins(new int[]{3,1,5,8});
        boolean passed = output == 167;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        SolutionIterativeDP s = new SolutionIterativeDP();
        int output = s.maxCoins(new int[]{35,16,83,87,84,59,48,41,20,54});
        boolean passed = output == 167;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }
}
