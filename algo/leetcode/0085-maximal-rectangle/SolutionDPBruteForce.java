public class SolutionDPBruteForce {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] DP = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                DP[i][j] = matrix[i][j] == '0'
                        ? 0
                        : 1 + (j > 0 ? DP[i][j - 1] : 0);
            }
        }
        int globalMax = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxW = DP[i][j];
                int maxS = DP[i][j];
                for (int n = i; n >= 0; n--) {
                    maxW = Math.min(maxW, DP[n][j]);
                    int newSize = maxW * (i - n + 1);
                    if (maxS < newSize) {
                        maxS = newSize;
                    }
                    if (globalMax < maxS) {
                        globalMax = maxS;
                    }
                }
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        testSolutionDPBruteForce1();
        testSolutionDPBruteForce2();
        testSolutionDPBruteForce3();
    }

    public static void testSolutionDPBruteForce1() {
        char[][] input = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        SolutionDPBruteForce s = new SolutionDPBruteForce();
        int output = s.maximalRectangle(input);
        boolean passed = output == 6;
        System.out.println("testSolutionDPBruteForce1: " + (passed ? "passed" : "failed"));
      }
    
      public static void testSolutionDPBruteForce2() {
        char[][] input = {
            {'0'}
        };
        SolutionDPBruteForce s = new SolutionDPBruteForce();
        int output = s.maximalRectangle(input);
        boolean passed = output == 0;
        System.out.println("testSolutionDPBruteForce2: " + (passed ? "passed" : "failed"));
      }
    
      public static void testSolutionDPBruteForce3() {
        char[][] input = {
            {'1'}
        };
        SolutionDPBruteForce s = new SolutionDPBruteForce();
        int output = s.maximalRectangle(input);
        boolean passed = output == 1;
        System.out.println("testSolutionDPBruteForce3: " + (passed ? "passed" : "failed"));
      }
}
