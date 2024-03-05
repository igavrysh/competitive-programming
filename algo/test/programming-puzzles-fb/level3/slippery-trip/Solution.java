class Solution {
    public int getMaxCollectableCoins(int R, int C, char[][] G) {
        int acc = 0;
        int maxOutput = 0;
        int[] lAccCoins = new int[C];
        int[] rAccCoins = new int[C];
    
        for (int i = 0; i < R; i++) {
            int lastDwnIdx = -1;
            int toRightCount = 0;

            for (int j = 0; j < C; j++) {
                lAccCoins[j] = (j > 0 ? lAccCoins[j-1] : 0) + (G[i][j] == '*' ? 1 : 0);
                int rj = C-1-j;
                rAccCoins[rj] = (rj < C-1 ? rAccCoins[rj+1] : 0) + (G[i][rj] == '*' ? 1 : 0);
                if (G[i][j] == 'v') {
                    lastDwnIdx = j;
                } else if (G[i][j] == '>') {
                    toRightCount++;
                }
            }

            boolean canGoToNextLevel = toRightCount != C ;

            int[] lDIdx = new int[C];
            for (int j = C-1; j >= 0; j--) {
                if (G[i][j] == 'v') {
                    lastDwnIdx = j;
                }
                lDIdx[j] = lastDwnIdx;
            }

            if (toRightCount != 0 && lastDwnIdx == -1) {
                maxOutput = Math.max(maxOutput, acc+lAccCoins[C-1]);
            }

            if (!canGoToNextLevel) {
                break;
            }

            int maxToGainAndMoveDown = lAccCoins[C-1] > 0 ? 1 : 0; 

            int accOnLevelMoveToRight = 0;

            int prevToRightIdx = -1;
            for (int j = 0; j < C; j++) {
                if (G[i][j] == '>') {
                    if (prevToRightIdx == -1) {
                        prevToRightIdx = j;
                    }
                }

                if (G[i][j] == 'v') {
                    if (prevToRightIdx != -1) {
                        accOnLevelMoveToRight = Math.max(accOnLevelMoveToRight, lAccCoins[j] - lAccCoins[prevToRightIdx]);
                    }
                    prevToRightIdx = -1;
                }
            }

            if (prevToRightIdx != -1) {
                for (int j = 0; j < C; j++) {
                    if (G[i][j] == 'v') {
                        accOnLevelMoveToRight = Math.max(accOnLevelMoveToRight, rAccCoins[prevToRightIdx] + lAccCoins[j]); 
                        break;
                    }
                }
            }

            maxToGainAndMoveDown = Math.max(maxToGainAndMoveDown, accOnLevelMoveToRight);

            acc = acc + maxToGainAndMoveDown;
            maxOutput = Math.max(maxOutput, acc);
        }

        return maxOutput;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        int R = 3;
        int C = 4;
        char[][]G = {
            {'.','*','*','*'},
            {'*','*','v','>'},
            {'.','*','.','.'}
        };
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMaxCollectableCoins(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int R = 3;
        int C = 3;
        char[][]G = {
            {'>','*','*'},
            {'*','>','*'},
            {'*','*','>'}
        };
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMaxCollectableCoins(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int R = 2;
        int C = 2;
        char[][]G = {
            {'>','>'},
            {'*','*'}
        };
        int expectedOutput = 0;
        Solution sol = new Solution();
        int output = sol.getMaxCollectableCoins(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int R = 4;
        int C = 6;
        char[][]G = {
            {'>','*','v','*','>','*'},
            {'*','v','*','v','>','*'},
            {'.','*','>','.','.','*'},
            {'.','*','.','.','*','v'}
        };
        int expectedOutput = 6;
        Solution sol = new Solution();
        int output = sol.getMaxCollectableCoins(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}


/*

{'>','*','>','*','v','*'}, 3
{'*','v','*','v','>','*'}, 2
{'.','*','>','.','.','*'},
{'.','*','.','.','*','v'}


R = 4
C = 6
G = 

>*v*>*
*v*v>*
.*>..*
.*..*v

>*>*v* 3
*v*v>* 2
.*>..* 1
.*..*v 1

>*>*v* 3
*v*v>* 2
*>..*. 1
.*..*v 

 */