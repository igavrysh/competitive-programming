import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class SolutionSkipEval {
    // 12+34+5-6+7*89
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        BT(0, 0, 0, 1, false, false, num, target, new StringBuilder(), result);
        return result;
    }

    private void BT(int pos, long val, long lastChange, long rightPart, boolean isMultInvolved, boolean lastChangeIsOp, 
        String num, int target, StringBuilder acc, List<String> result
    ) {
        if (pos == num.length()) {
            if (val == target) {
                result.add(acc.toString());
            }
            return;
        }

        char chr = num.charAt(pos);

        if ((!lastChangeIsOp || (lastChangeIsOp && rightPart != 0)) && !(pos == 1 && !lastChangeIsOp && val == 0)) {
            long rollback = val - lastChange;
            long rightMult = rightPart;
            long lastChangeNoOp = 0;
            if (!isMultInvolved) {
                lastChangeNoOp = (Math.abs(lastChange*10) + (chr-'0')) * (lastChange >= 0 ? 1 : -1);
            } else {
                long left = lastChange / rightPart;
                rightMult = rightPart*10 +(chr-'0'); 
                lastChangeNoOp = left * rightMult;
            }
            acc.append(chr);
            BT(pos+1, rollback+lastChangeNoOp, lastChangeNoOp, rightMult, isMultInvolved, false, num, target, acc, result);
            acc.deleteCharAt(acc.length()-1);
        }

        if (pos != 0) {
            acc.append(new char[]{'+', chr});
            BT(pos+1, val+(chr-'0'), chr-'0', chr-'0', false, true, num, target, acc, result);
            acc.delete(acc.length()-2, acc.length());

            acc.append(new char[]{'-', chr});
            BT(pos+1, val-(chr-'0'), -(chr-'0'), chr-'0', false, true, num, target, acc, result);
            acc.delete(acc.length()-2, acc.length());

            acc.append(new char[]{'*', chr});
            long rollback = val - lastChange;
            long lastChangeOp = lastChange * (chr-'0');
            BT(pos+1, rollback+lastChangeOp, lastChangeOp, chr-'0', true, true, num, target, acc, result);
            acc.delete(acc.length()-2, acc.length());
        }
    }

    public static void main(String[] args) {
        test7();
        test6();
        test5();
        test3();
        test1();
        test2();
        test4();
    }

    public static void test3() {
        String num = "3456237490";
        int target = 9191;
        String[] expOutput = {};
        SolutionSkipEval sol = new SolutionSkipEval();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test3: " + (passed == true ? "true" : "false"));
    }

    public static void test1() {
        String num = "123";
        int target = 6;
        String[] expOutput = {"1*2*3","1+2+3"};
        SolutionSkipEval sol = new SolutionSkipEval();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test1: " + (passed == true ? "true" : "false"));
    }

    public static void test2() {
        String num = "232";
        int target = 8;
        String[] expOutput = {"2*3+2","2+3*2"};
        SolutionSkipEval sol = new SolutionSkipEval();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test2: " + (passed == true ? "true" : "false"));
    }

    public static boolean compAnL(String[] expOutput, List<String> outputL) {
        HashSet<String> set1 = new HashSet<>();
        for (int i = 0; i < expOutput.length; i++) {
            set1.add(expOutput[i]);
        }
        HashSet<String> set2 = new HashSet<>();
        for (int i = 0; i < outputL.size(); i++) {
            set2.add(outputL.get(i));
        }
        return set1.equals(set2);
    }

    public static void test4() {
        String num = "105";
        int target = 5;
        String[] expOutput = {"1*0+5","10-5"};
        SolutionSkipEval sol = new SolutionSkipEval();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test4: " + (passed == true ? "true" : "false"));
    }

    public static void test5() {
        String num = "123456789";
        int target = 45;
        String[] expOutput = {
            "1*2*3*4*5-6-78+9","1*2*3*4+5+6-7+8+9","1*2*3+4+5+6+7+8+9","1*2*3+4+5-6*7+8*9","1*2*3+4-5*6+7*8+9",
            "1*2*3+4-5*6-7+8*9","1*2*3-4*5+6*7+8+9","1*2*3-4*5-6+7*8+9","1*2*3-4*5-6-7+8*9","1*2*3-45+67+8+9",
            "1*2*34+56-7-8*9","1*2*34-5+6-7-8-9","1*2+3*4-56+78+9","1*2+3+4+5*6+7+8-9","1*2+3+4-5+6*7+8-9",
            "1*2+3+4-5-6+7*8-9","1*2+3+45+67-8*9","1*2+3-45+6+7+8*9","1*2+34+5-6-7+8+9","1*2+34+56-7*8+9",
            "1*2+34-5+6+7-8+9","1*2+34-56+7*8+9","1*2+34-56-7+8*9","1*2-3*4+5+67-8-9","1*2-3+4-5-6*7+89",
            "1*2-3-4*5+67+8-9","1*2-3-4+56-7-8+9","1*2-34+5*6+7*8-9","1*23+4*5-6+7-8+9","1*23-4-56-7+89",
            "1+2*3*4*5+6+7-89","1+2*3*4+5*6+7-8-9","1+2*3*4-5+6*7-8-9","1+2*3+4*5*6+7-89","1+2*3+4*5-6+7+8+9",
            "1+2*3-4-5-6*7+89","1+2*34-5*6+7+8-9","1+2+3*4*5+6-7-8-9","1+2+3*4+5+6*7-8-9","1+2+3*45-6-78-9",
            "1+2+3+4+5+6+7+8+9","1+2+3+4+5-6*7+8*9","1+2+3+4-5*6+7*8+9","1+2+3+4-5*6-7+8*9","1+2+3-4*5+6*7+8+9",
            "1+2+3-4*5-6+7*8+9","1+2+3-4*5-6-7+8*9","1+2+3-45+67+8+9","1+2-3*4*5+6+7+89","1+2-3*4+5*6+7+8+9",
            "1+2-3*4-5+6*7+8+9","1+2-3*4-5-6+7*8+9","1+2-3*4-5-6-7+8*9","1+2-3+4*5+6*7-8-9","1+2-3+45+6-7-8+9",
            "1+2-3+45-6+7+8-9","1+2-3-4-5*6+7+8*9","1+2-3-45-6+7+89","1+2-34+5+6+7*8+9","1+2-34+5+6-7+8*9",
            "1+2-34-5-6+78+9","1+23*4+5-6-7*8+9","1+23*4-5-6*7+8-9","1+23*4-56+7-8+9","1+23+4+5+6+7+8-9",
            "1+23+4-5*6+7*8-9","1+23+4-5-67+89","1+23-4*5+6*7+8-9","1+23-4*5-6+7*8-9","1+23-4-5+6+7+8+9",
            "1+23-4-5-6*7+8*9","1+23-45+67+8-9","1-2*3*4+5-6+78-9","1-2*3*4-5-6+7+8*9","1-2*3+4*5+6+7+8+9",
            "1-2*3+4*5-6*7+8*9","1-2*3+4+5+6*7+8-9","1-2*3+4+5-6+7*8-9","1-2*3+4+56+7-8-9","1-2*3+45-67+8*9",
            "1-2*3-4+5*6+7+8+9","1-2*3-4-5+6*7+8+9","1-2*3-4-5-6+7*8+9","1-2*3-4-5-6-7+8*9","1-2*34+5*6-7+89",
            "1-2+3*4*5-6-7+8-9","1-2+3+4-5*6+78-9","1-2+3+45+6-7+8-9","1-2+3-4*5-6+78-9","1-2+3-45+6-7+89",
            "1-2-3*4+5+6+7*8-9","1-2-3*4-5-6+78-9","1-2-3+4-5+67-8-9","1-2-3+45-6-7+8+9","1-2-34+5+6+78-9",
            "1-2-34+56+7+8+9","1-2-34-5+6+7+8*9","1-23*4+5+6*7+89","1-23+4*5-6*7+89","1-23+4-5+67-8+9",
            "1-23+45-67+89","1-23-4+5+67+8-9","1-23-4-5-6-7+89","12*3*4-5*6-78+9","12*3+4+5+6-7-8+9",
            "12*3+4+5-6+7+8-9","12*3-4-5-6+7+8+9","12*3-4-56+78-9","12+3*4+5+6-7+8+9","12+3*45-6-7-89",
            "12+3+4-56-7+89","12+3-4*5+67-8-9","12+3-45+6+78-9","12+34-5-6-7+8+9","12-3*4*5+6+78+9",
            "12-3*4-5+67-8-9","12-3+4*5+6-7+8+9","12-3+4+56-7-8-9","12-3-4+5*6-7+8+9","12-3-4-56+7+89",
            "12-3-45-6+78+9"};
        SolutionSkipEval sol = new SolutionSkipEval();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test5: " + (passed == true ? "true" : "false"));
    }

    public static void test6() {
        String num = "00";
        int target = 0;
        String[] expOutput = {"0*0","0+0","0-0"};
        SolutionSkipEval sol = new SolutionSkipEval();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test6: " + (passed == true ? "true" : "false"));
    }

    public static void test7() {
        String num = "010";
        int target = 0;
        String[] expOutput = {"0*1*0","0*1+0","0*1-0","0*10","0+1*0","0-1*0"};
        SolutionSkipEval sol = new SolutionSkipEval();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test7: " + (passed == true ? "true" : "false"));
        
    }
}
