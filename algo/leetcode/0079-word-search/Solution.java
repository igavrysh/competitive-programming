
public class Solution {
    public static void main(String[] args) {
        testSolution1_1();
        testSolution1_2();
        testSolution1_3();
        testSolution1_3();
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i + 1, j, count + 1, word)
            || dfs(board, i - 1, j, count + 1, word)
            || dfs(board, i, j + 1, count + 1, word)
            || dfs(board, i, j - 1, count + 1, word);
        board[i][j] = temp;
        return found;
    }

    public static void testSolution1_1() {
        char[][] board = {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        Solution solution = new Solution();
        boolean passed = true;
        passed = passed && solution.exist(board, "ABCCED") == true;
        passed = passed && solution.exist(board, "SEE") == true;
        passed = passed && solution.exist(board, "ABCB") == false;
        System.out.println("testSolution1_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_2() {
        char[][] board = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        Solution solution = new Solution();
        boolean passed = solution.exist(board, "ABCCED") == true;
        System.out.println("testSolution1_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_3() {
        char[][] board = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        Solution solution = new Solution();
        boolean passed = solution.exist(board, "SEE") == true;
        System.out.println("testSolution1_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_4() {
        char[][] board = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        };
        Solution solution = new Solution();
        boolean passed = solution.exist(board, "ABCB") == false;
        System.out.println("testSolution1_4: " + (passed ? "passed" : "failed"));
    }

}
