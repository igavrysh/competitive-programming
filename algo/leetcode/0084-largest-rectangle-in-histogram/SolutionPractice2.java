import java.util.Stack;

public class  SolutionPractice2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer[]> S = new Stack<>();
        S.push(new Integer[]{0, -1});
        int output = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currH = i < heights.length ? heights[i] : 0;
            Integer[] pair = null;
            while (S.peek()[0] > currH) {
                pair = S.pop();
                int area = pair[0]*(i-1-pair[1]+1);
                if (area > output) {
                    output = area;
                }
            }
            if (pair != null) {
                S.push(new Integer[]{currH, pair[1]});
            } else {
                S.push(new Integer[]{currH, i});
            }
        }
        return output;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.largestRectangleArea(heights);
        boolean passed = output == 10;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] heights = { 2, 4 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.largestRectangleArea(heights);
        boolean passed = output == 4;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] heights = { 2, 1, 2 };
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.largestRectangleArea(heights);
        boolean passed = output == 3;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
