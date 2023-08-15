import java.util.ArrayList;
import java.util.List;

public class SolutionPractice2 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] a1 = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            a1[i] = num1.charAt(i)-'0';
        }
        int[] a2 = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            a2[i] = num2.charAt(i)-'0';
        }
        List<Integer> prev = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int j = a2.length-1; j >= 0; j--) {
            List<Integer> curr = new ArrayList<>();
            int carry = 0;
            int k = 0;
            for (int i = a1.length-1; i>=0; i--) {
                int n = a1[i]*a2[j] + (k<prev.size() ? prev.get(k++) : 0) + carry;
                curr.add(n%10);
                carry = n/10;
            }
            if (carry > 0) {
                curr.add(carry);
            }
            char ch = (char)(curr.get(0)+'0');
            sb.insert(0, ch);
            curr.remove(0);
            prev = curr;
        }
        
        int i = 0;
        while (i<prev.size()) {
            sb.insert(0, (char)(prev.get(i)+'0'));
            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        test_SolutionPractice2_1();
        test_SolutionPractice2_2();
    }

    public static void test_SolutionPractice2_1() {
        String num1 = "123", num2 = "456";
        SolutionPractice2 s = new SolutionPractice2();
        String actual = s.multiply(num1, num2);
        String expected = "56088";
        boolean passed = actual.equals(expected);
        System.out.println("test_SolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void test_SolutionPractice2_2() {
        String num1 = "9133", num2 = "0";
        SolutionPractice2 s = new SolutionPractice2();
        String actual = s.multiply(num1, num2);
        String expected = "0";
        boolean passed = actual.equals(expected);
        System.out.println("test_SolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }
}
