import java.util.Stack;

public class SolutionLeetcode4 {
        public int calculate(String s) {
        int sum = 0, result = 0, sign = 1;
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)) sum = sum * 10 + (ch - '0');
            else{
                result += sum * sign * myStack.peek();
                sum = 0;
                if(ch == '-') sign = -1;
                else if(ch == '+') sign = 1;
                else if(ch == '('){
                    myStack.push(myStack.peek() * sign);
                    sign = 1;
                } else if(ch == ')') myStack.pop();
            }
        }
        return result += sign * sum;
    }
}
