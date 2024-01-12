import java.util.Stack;

public class SolutionLeetcode {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = num.length()+1;
        int targetSize = n-k;
        for (int i = 0; i < num.length(); i++) {
            int currD = num.charAt(i) - '0';
            int toBeAddedFromRight = num.length() - i - 1;

            while (stack.peek() > currD && (stack.size() + toBeAddedFromRight >= targetSize)) {
                stack.pop();
            }
            stack.push(currD);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.size() <= targetSize) {
                int currD = stack.pop();
                char chr = (char)('0' + currD);
                sb.insert(0, chr);
            } else {
                stack.pop();
            }
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }
}
