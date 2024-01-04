import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class SolutionSkipEval {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        BT(0, 0, 0, 1, false, false, num, target, new StringBuilder(), result);
        return result;
    }

    private void BT(int pos, long val, long lastChange, long rightMult, boolean isMultInvolved, boolean lastChangeIsOp, 
        String num, int target, StringBuilder acc, List<String> result
    ) {
        //String test = acc.toString();
        if (pos == num.length()) {
            if (val == target) {
                result.add(acc.toString());
            }
            return;
        }

        char chr = num.charAt(pos);


        if (!lastChangeIsOp || (lastChangeIsOp && lastChange != 0)) {
            long rollback = val - lastChange;
            long rightMultNew = rightMult;
            long lastChangeNoOp = 0;
            if (!isMultInvolved) {
                lastChangeNoOp = lastChange*10 + (chr-'0');
            } else {
                long left = lastChangeNoOp / rightMult;
                rightMultNew = rightMult*10 +(chr-'0'); 
                lastChangeNoOp = left * rightMultNew;
            }
            acc.append(chr);
            BT(pos+1, rollback+lastChangeNoOp, lastChangeNoOp, rightMultNew, isMultInvolved, false, num, target, acc, result);
            acc.deleteCharAt(acc.length()-1);
        }

        if (pos != 0) {
            acc.append(new char[]{'+', chr});
            BT(pos+1, val+(chr-'0'), chr-'0', 1, false, true, num, target, acc, result);
            acc.delete(acc.length()-2, acc.length());

            acc.append(new char[]{'-', chr});
            BT(pos+1, val-(chr-'0'), -(chr-'0'), 1, false, true, num, target, acc, result);
            acc.delete(acc.length()-2, acc.length());

            acc.append(new char[]{'*', chr});
            long rollback = val - lastChange;
            long lastChangeOp = lastChange * (chr-'0');
            BT(pos+1, rollback+lastChangeOp, lastChangeOp, chr-'0', true, true, num, target, acc, result);
            acc.delete(acc.length()-2, acc.length());
        }

    }

    public static void main(String[] args) {
        test3();
        test1();
        test2();
        test4();
        test5();
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
}
