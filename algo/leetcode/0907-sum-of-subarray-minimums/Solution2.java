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
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
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
            result += arr[i] * (1 + l[i]) * (1 + r[i]);
            if (result >= max_val) {
                result %= max_val;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        test2();
        test1();
    }

    public static void test1() {
        int[] arr = {3,1,2,4};
        int expOutput = 17;
        Solution2 sol = new Solution2();
        int output = sol.sumSubarrayMins(arr);
        boolean passed = expOutput == output;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
/*

71 
55, 71:55, 55:82, 55:82:55, 71:55:82, 71:55:82:55
82
71:55:82:55, 55:82:55, 82:55, 55


71 + 1
55 * (1 + 1 + 2 + 1 + 1) = 330
82 * (1) = 82
55 * (1 + 1 + 1 + 1) = 220


71, 71:55, 71:55:82, 71:55:82:55
71 + 55 + 55 + 55

55, 55:82, 55:82:55,
3x55

82, 82:55
82, 55

55
55

 */



    public static void test2() {
        int[] arr = {71,55,82,55};
        int expOutput = 593;
        Solution2 sol = new Solution2();
        int output = sol.sumSubarrayMins(arr);
        boolean passed = expOutput == output;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}
