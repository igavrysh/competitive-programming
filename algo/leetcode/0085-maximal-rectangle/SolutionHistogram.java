import java.util.Stack;

public class SolutionHistogram {
    public int maximalRectangle(char[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[] h = new int[M];
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == '1') {
                    h[j] = h[j] + 1;
                } else {
                    h[j] = 0;
                }
            }
            Stack<Integer> S = new Stack<>();
            S.push(-1);
            for (int j = 0; j <= M; j++) {
                while (S.peek() != -1 && (j == M || h[S.peek()] > h[j])) {
                    int currIndex = S.pop();
                    int prevIndex = S.peek();
                    int area = h[currIndex] * (j - prevIndex - 1);
                    if (area > res) {
                        res = area;
                    }
                }
                S.push(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        testSolutionHistogram1();
        testSolutionHistogram2();
        testSolutionHistogram3();
        testSolutionHistogram4();
    }

    public static void testSolutionHistogram1() {
        char[][] input = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        SolutionHistogram s = new SolutionHistogram();
        int output = s.maximalRectangle(input);
        boolean passed = output == 6;
        System.out.println("testSolutionHistogram1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHistogram2() {
        char[][] input = {
                { '0' }
        };
        SolutionHistogram s = new SolutionHistogram();
        int output = s.maximalRectangle(input);
        boolean passed = output == 0;
        System.out.println("testSolutionHistogram2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHistogram3() {
        char[][] input = {
                { '1' }
        };
        SolutionHistogram s = new SolutionHistogram();
        int output = s.maximalRectangle(input);
        boolean passed = output == 1;
        System.out.println("testSolutionHistogram3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHistogram4() {
        char[][] input = {
                { '0', '1', '1', '0', '1' },
                { '1', '1', '0', '1', '0' },
                { '0', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '1' },
                { '0', '0', '0', '0', '0' }
        };
        SolutionHistogram s = new SolutionHistogram();
        int output = s.maximalRectangle(input);
        boolean passed = output == 9;
        System.out.println("testSolutionHistogram4: " + (passed ? "passed" : "failed"));
    }
}
