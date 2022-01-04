

public class Solution {
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

    private boolean dfs (char[][] board, int i, int j, int count, String word) {
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

        public static void main(String[] args) {
            test_1();
        }

        public static char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        public static Solution solution = new Solution();

        public static void test_1() {
            assert (solution.exist(Solution.board1, "ABCCED") == true);
            assert (solution.exist(Solution.board1, "SEE") == true);
            boolean test3 = solution.exist(Solution.board1, "ABCB");
            assert false;
            assert(test3 == true);
        }

}
