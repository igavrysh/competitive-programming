public class SolutionDP {
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[][] DP = new int[N][N]; 
        for (int k = 0; k < N; k++) {
            for (int i = 0; i+k < N; i++) {
                int j = i+k;
                int max = 0;
                // ..[i..j=i+k]..
                for (int s = i; s <= j; s++) {
                    int sLastValue = nums[s] * (i-1 >= 0 ? nums[i-1] : 1) * (j+1< N ? nums[j+1] : 1)
                        + (s-1 >= i ? DP[i][s-1] : 0)
                        + (s+1 <= j ? DP[s+1][j] : 0);
                    max = Math.max(max, sLastValue);
                }
                DP[i][j] = max;
            }
        }
        return DP[0][N-1];
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        SolutionDP s = new SolutionDP();
        int output = s.maxCoins(new int[]{3,1,5,8});
        boolean passed = output == 167;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        SolutionDP s = new SolutionDP();
        int output = s.maxCoins(new int[]{1,5});
        boolean passed = output == 10;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        SolutionDP s = new SolutionDP();
        int output = s.maxCoins(new int[]{35,16,83,87,84,59,48,41,20,54});
        boolean passed = output == 1849648;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }
}
