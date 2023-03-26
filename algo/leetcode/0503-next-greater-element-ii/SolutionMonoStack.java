import java.util.Stack;

public class SolutionMonoStack {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output = new int[nums.length];
        if (n == 1) {
            output[0] = -1;
            return output;
        }
        boolean[] set = new boolean[n];
        Stack<Integer> S = new Stack<>();
        S.push(0);
        int i = 1;
        while (!S.isEmpty() && i != S.peek() ) {
            while (!S.isEmpty() && nums[S.peek()] < nums[i]) {
                int j = S.pop();
                output[j] = nums[i];
                set[j] = true;
            }
        
            if (!S.isEmpty() && S.peek()==i) {
                break;
            }

            if (!set[i]) {
                S.push(i);
                set[i] = true;
            }

            i = (i+1)%n;
        }
        while (!S.isEmpty()) {
            output[S.pop()] = -1;
        }
        return output;
    }
}
