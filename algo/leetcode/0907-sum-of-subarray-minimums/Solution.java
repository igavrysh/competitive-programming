import java.util.Stack;

public class Solution {

    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        int output = 0, M = (int) 1e9 + 7;
        int[] DP = new int[N];
        DP[0] = arr[0];
        output += DP[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (stack.size() > 0 && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            DP[i] = stack.size() == 0
                    ? ((i + 1) * arr[i]) % M
                    : (DP[stack.peek()] + (i - stack.peek()) * arr[i]) % M;
            output = (output + DP[i]) % M;
            stack.push(i);
        }
        return output;
    }

    public static void test1() {
        int[] input = { 3, 1, 2, 4 };
        Solution s = new Solution();
        int output = s.sumSubarrayMins(input);
        boolean passed = output == 17;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] input = { 11, 81, 94, 43, 3 };
        Solution s = new Solution();
        int output = s.sumSubarrayMins(input);
        boolean passed = output == 444;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}
