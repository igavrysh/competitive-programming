import java.util.Stack;

public class SolutionLeetcode3 {
        public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, res = 0, sign = 1, index = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) num = num * 10 + c - '0';
             else {
                if(c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1; 
                } else if(c == '+') {
                    res += num * sign;
                    sign = 1;
                    num = 0;
                } else if(c == '-'){
                    res += num * sign;
                    sign = -1;
                    num = 0;
                } else if(c == ')'){
                    res = res + num*sign;
                    res = res * stack.pop() + stack.pop();
                    num = 0;
                    sign = 1;
                }
            }
        }
        if(num != 0) res += num*sign;
        return res;
    }
}
