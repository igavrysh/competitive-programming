import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionLeetcode2 {
    int res = 0;
    public int calculate(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0, curNum = 0, curOp = 1;
        for(char c: s.toCharArray()){
            if(c >= '0' && c <= '9'){
                curNum = curNum * 10 + c- '0';
            }
            else if(c == '+'){
                res += curOp * curNum;
                curOp = 1;
                curNum = 0;
            }
            else if(c == '-'){
                res += curOp * curNum;
                curOp = -1;
                curNum = 0;
            }
            else if(c == '('){
                deque.offerLast(res);
                deque.offerLast(curOp);
                res = 0;
                curOp = 1;
            }
            else if(c == ')'){
                res += curNum * curOp;
                curNum = 0;
                curOp = 1;
                res *= deque.pollLast();
                res += deque.pollLast();
            }
        }
        return res + curNum * curOp;
    }
}
