class Solution {
    private int[][] pSq = {{}};
    public int minimumSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        pSq = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pSq[i][j] = grid[i][j] 
                    + (i-1 >= 0 ? pSq[i-1][j] : 0)
                    + (j-1 >= 0 ? pSq[i][j-1] : 0)
                    - (i-1 >= 0 && j-1 >=0 ? pSq[i-1][j-1] : 0); 
            }
        }
        int minArea = rows*cols;
        int x = 0, y = 0;

        // split vertically 
        // x
        // -
        // y
        for (int i = 0; i < rows-1; i++) {
            x = minAreaToCoverOnesWith2Rec(0, i, 0, cols-1);
            if (x != -1) {
                y = minAreaToCoverOnes(i+1, rows-1, 0, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
            
            x = minAreaToCoverOnes(0, i, 0, cols-1);
            if (x != -1) {
                y = minAreaToCoverOnesWith2Rec(i+1, rows-1, 0, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        // split horizontally
        // x | y
        for (int j = 0; j < cols-1; j++) {
            x = minAreaToCoverOnesWith2Rec(0, rows-1, 0, j);
            if (x != -1) {
                y = minAreaToCoverOnes(0, rows-1, j, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
            
            x = minAreaToCoverOnes(0, rows-1, 0, j);
            if (x != -1) {
                y = minAreaToCoverOnesWith2Rec(0, rows-1, j+1, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        return minArea;
    }

    private int minAreaToCoverOnesWith2Rec(int sI, int eI, int sJ, int eJ) {
        int rows = pSq.length;
        int cols = pSq[0].length;
        int minArea = rows*cols+1;
        // split vertically
        // x
        // -
        // y
        for (int i = sI; i <= eI-1; i++) {
            int x = minAreaToCoverOnes(sI, i, sJ, eJ);
            if (x != -1) {
                int y = minAreaToCoverOnes(i+1, eI, sJ, eJ);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        // split horizontally
        // x | y
        for (int j = sJ; j <= eJ-1; j++) {
            int x = minAreaToCoverOnes(sI, eI, sJ, j);
            if (x != -1) {
                int y = minAreaToCoverOnes(sI, eI, j+1, eJ);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        return minArea == rows*cols+1 ? -1 : minArea;
    }

    private int minAreaToCoverOnes(int sI, int eI, int sJ, int eJ) {
        int i = sI;
        int j = sJ;
        int topI = -1; 
        int topJ = -1;
        while (i <= eI && j <= eJ) {
            int onesInRowI = pSq[i][eJ] 
                - (i-1>=0 ? pSq[i-1][eJ] : 0)
                - (sJ-1>=0 ? pSq[i][sJ-1] : 0)
                + (i-1>=0 && sJ-1 >= 0 ? pSq[i-1][sJ-1] : 0);
            int onesInColJ = pSq[eI][j]
                - (sI-1>=0 ? pSq[sI-1][j] : 0)
                - (j-1>=0 ? pSq[eI][j-1] : 0)
                + (sI-1>=0 && j-1>=0 ? pSq[sI-1][j-1] : 0);
            if (onesInRowI == 0 && onesInColJ == 0
            ) {
                i++;
                j++;
            } else if (onesInRowI == 0) {
                i++;
            } else if (onesInColJ == 0) {
                j++;
            } else {
                topI = i;
                topJ = j;
                break;
            }
        }
        if (topI == -1 || topJ == -1) {
            return -1;
        }

        int bottomI = -1;
        int bottomJ = -1;
        i = eI;
        j = eJ;

        while (i >= sI && j >= sJ) {
            int onesInRowI = pSq[i][eJ] 
                - (i-1>=0 ? pSq[i-1][eJ] : 0)
                - (sJ-1>=0 ? pSq[i][sJ-1] : 0)
                + (i-1>=0 && sJ-1 >= 0 ? pSq[i-1][sJ-1] : 0);
            int onesInColJ = pSq[eI][j]
                - (sI-1>=0 ? pSq[sI-1][j] : 0)
                - (j-1>=0 ? pSq[eI][j-1] : 0)
                + (sI-1>=0 && j-1>=0 ? pSq[sI-1][j-1] : 0);
            if (onesInRowI == 0 && onesInColJ== 0
            ) {
                i--;
                j--;
            } else if (onesInRowI == 0) {
                i--;
            } else if (onesInColJ == 0) {
                j--;
            } else {
                bottomI = i;
                bottomJ = j;
                break;
            }
        }
        if (bottomI == -1 || bottomJ == -1) {
            return -1;
        }
        return (bottomI-topI+1)*(bottomJ-topJ+1);
    }

    public static void main(String[] args) {
        test3();
        test1();
        test2();
    }

    public static void test1() {
        int[][] grid = {
            {1,0,1},
            {1,1,1}
        };
        int expOutput = 5;
        Solution sol = new Solution();
        int output = sol.minimumSum(grid);
        boolean passed = output == expOutput;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] grid = {
            {1,0,1,0},
            {0,1,0,1}
        };
        int expOutput = 5;
        Solution sol = new Solution();
        int output = sol.minimumSum(grid);
        boolean passed = output == expOutput;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[][] grid = {
            {1,1},
            {1,0}
        };
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.minimumSum(grid);
        boolean passed = output == expOutput;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }
}