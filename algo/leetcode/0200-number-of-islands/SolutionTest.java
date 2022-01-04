


class SolutionTest {


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        char[][] input = {
          { '1', '1', '1', '1', '0' },
          { '1', '1', '0', '1', '0' },
          { '1', '1', '0', '0', '0' },
          { '0', '0', '0', '0', '0' }
        };
        Solution s = new Solution();
        assert(s.numIslands(input) == 1);
    }
}