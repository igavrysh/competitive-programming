import java.util.Stack;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> S = new Stack<>();
        S.push(-1);
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (S.peek() != -1 && (i == heights.length || heights[S.peek()] > heights[i])) {
                int idx = S.pop();
                int area = (i - 1 - S.peek()) * heights[idx];
                if (area > res) {
                    res = area;
                }
            }
            if (i != heights.length) {
                S.push(i);
            }
        }
        return res;
    }
}
