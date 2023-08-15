public class Solution {

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] n1 = new int[num1.length()];
        for (int i = 0; i < n1.length; i++) {
            n1[i] = num1.charAt(i) - '0';
        }
        int[] result = new int[len1 + len2];
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                result[i + j] += (n1[len1 - 1 - j]) * (num2.charAt(len2 - 1 - i) - '0');
            }
        }
        int carry = 0;
        for (int i = 0; i < result.length; i++) {
            int tmp = result[i] + carry;
            result[i] = tmp % 10;
            carry = tmp / 10;
        }
        boolean startAppending = false;
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] != 0) {
                startAppending = true;
            }
            if (startAppending) {
                sb.append(result[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static void test1() {
        String num1 = "123";
        String num2 = "456";
        Solution s = new Solution();
        String output = s.multiply(num1, num2);
        boolean passed = output.equals("56088");
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String num1 = "2";
        String num2 = "3";
        Solution s = new Solution();
        String output = s.multiply(num1, num2);
        boolean passed = output.equals("6");
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String num1 = "2";
        String num2 = "0";
        Solution s = new Solution();
        String output = s.multiply(num1, num2);
        boolean passed = output.equals("0");
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String num1 = "9";
        String num2 = "9";
        Solution s = new Solution();
        String output = s.multiply(num1, num2);
        boolean passed = output.equals("81");
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        String num1 = "99";
        String num2 = "99";
        Solution s = new Solution();
        String output = s.multiply(num1, num2);
        boolean passed = output.equals("9801");
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        String num1 = "999";
        String num2 = "99";
        Solution s = new Solution();
        String output = s.multiply(num1, num2);
        boolean passed = output.equals("98901");
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        String num1 = "777";
        String num2 = "0";
        Solution s = new Solution();
        String output = s.multiply(num1, num2);
        boolean passed = output.equals("0");
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }
    
}
