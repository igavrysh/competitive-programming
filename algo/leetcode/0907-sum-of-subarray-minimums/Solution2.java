import java.util.Stack;

public class Solution2 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] r = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int idx = stack.pop();
                r[idx] = i-idx-1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            r[idx] = n-1-idx;
        }
        int[] l = new int[n];
        stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int idx = stack.pop();
                l[idx] = idx-(i+1);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            l[idx] = idx;
        }
        int result = 0;
        int max_val = (int)(Math.pow(10, 9) + 7);
        for (int i = 0; i < n; i++) {
            result += arr[i] * (1 + (l[i] + r[i] + l[i] * r[i]));
            if (result >= max_val) {
                result %= max_val;
            }
        }
        return result;
    }

    public static void test1() {
        int[] arr = {3,1,2,4};
        int expOutput = 17;
        Solution2 sol = new Solution2();
        int output = sol.sumSubarrayMins(arr);
        boolean passed = expOutput == output;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
    }
}
