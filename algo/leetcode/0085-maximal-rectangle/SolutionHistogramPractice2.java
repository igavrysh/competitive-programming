import java.util.Stack;
public class SolutionHistogramPractice2 {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] h = new int[cols+1];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                h[j] = matrix[i][j] == '1' ? h[j]+1 : 0;
            }
            h[cols] = 0;
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(-1);
            for (int j = 0; j < h.length; j++) {
                while (stack.peek() != -1 && h[stack.peek()] > h[j]) {
                    int idx = stack.pop();
                    int prevIdx = stack.peek();
                    maxArea = Math.max(maxArea, (j-prevIdx-1) * h[idx]);
                }
                stack.push(j);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        test2();
        test1();
    }

    public static void test1() {
        char[][] input = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        SolutionHistogramPractice2 s = new SolutionHistogramPractice2();
        int output = s.maximalRectangle(input);
        boolean passed = output == 6;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        char[][] input = {
                { '1', '0' },
                { '1', '0' }
        };
        SolutionHistogramPractice2 s = new SolutionHistogramPractice2();
        int output = s.maximalRectangle(input);
        boolean passed = output == 2;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}
