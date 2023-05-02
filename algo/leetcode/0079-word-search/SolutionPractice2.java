public class SolutionPractice2 {

    public static void main(String[] args) {
        testSolutionPractice2_7();
        testSolutionPractice2_6();
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
        testSolutionPractice2_4();
        testSolutionPractice2_5();
    }

    public boolean exist(char[][] board, String word) {
        int[] fqBoard = new int[26*2];  // account for uppercase and lowercase letters by provided constraint
        int[] fqWord = new int[26*2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                fqBoard[idxForChar(board[i][j])]++;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            fqWord[idxForChar(word.charAt(i))]++;
        }
        for (int i = 0; i < fqWord.length; i++) {
            if (fqBoard[i] < fqWord[i]) {
                return false;
            }
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int idxForChar(char c) {
        return c-'A' >= 0 && c-'A' < 26 ? c-'A' : c-'a'+26;
    }

    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    private boolean dfs(int i, int j, int wIdx, char[][] board, String word, boolean[][] visited) {
        visited[i][j] = true;

        if (board[i][j] != word.charAt(wIdx)) {
            visited[i][j] = false;
            return false;
        } 

        wIdx++;
        if (wIdx == word.length()) {
            visited[i][j] = false;
            return true; // case for single characcter on board, e.g. {{'a'}}
        }
        
        for (int k = 0; k < dirs.length; k++) {
            int nextI = i + dirs[k][0], nextJ = j + dirs[k][1];
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length && !visited[nextI][nextJ]) {
                boolean found = dfs(nextI, nextJ, wIdx, board, word, visited);
                visited[nextI][nextJ] = false;
                if (found) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void testSolutionPractice2_1() {
        char[][] board = {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        SolutionPractice2 solution = new SolutionPractice2();
        boolean passed = true;
        passed = passed && solution.exist(board, "ABCB") == false;
        passed = passed && solution.exist(board, "ABCCED") == true;
        passed = passed && solution.exist(board, "SEE") == true;
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        char[][] board = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        SolutionPractice2 solution = new SolutionPractice2();
        boolean passed = solution.exist(board, "ABCCED") == true;
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        char[][] board = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        SolutionPractice2 solution = new SolutionPractice2();
        boolean passed = solution.exist(board, "SEE") == true;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        char[][] board = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        SolutionPractice2 solution = new SolutionPractice2();
        boolean passed = solution.exist(board, "ABCB") == false;
        System.out.println("testSolutionPractice2_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_5() {
        char[][] board = new char[][] {
            { 'a' }
        };
        SolutionPractice2 solution = new SolutionPractice2();
        boolean passed = true;
        passed = passed && solution.exist(board, "a") == true;
        passed = passed && solution.exist(board, "A") == false;
        passed = passed && solution.exist(board, "b") == false;
        System.out.println("testSolutionPractice2_5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_6() {
        char[][] board = {
            { 'A', 'A', 'A' }, 
            { 'A', 'a', 'a' },
            { 'A', 'a', 'A' },
            { 'a', 'a', 'A'}
        };
        String word = "AAAAAA";
        SolutionPractice2 solution = new SolutionPractice2();
        boolean passed = solution.exist(board, word) == false;
        System.out.println("testSolutionPractice2_6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_7() {
        char[][] board = {
            { 'a', 'b' }
        };
        String word = "ba";
        SolutionPractice2 solution = new SolutionPractice2();
        boolean passed = solution.exist(board, word) == true;
        System.out.println("testSolutionPractice2_7: " + (passed ? "passed" : "failed"));
    }

}
