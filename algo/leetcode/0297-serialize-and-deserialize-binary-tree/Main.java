public class Main {

    public static void main(String[] args) {
        testSolution1_1();
        testSolution1_2();
    }

    public static void testSolution1_1() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        Codec ser = new Codec();
        Codec deser = new Codec();
        String str = ser.serialize(root);
        TreeNode ans = deser.deserialize(str);
        boolean passed = ans.val == 1
            && ans.left.val == 2 && ans.left.left == null && ans.left.right == null
            && ans.right.val == 3 && ans.right.left.val == 4 && ans.right.right.val == 5
            && ans.right.left.left == null && ans.right.left.right == null
            && ans.right.right.left == null && ans.right.right.right == null;
        System.out.println("testSolution1_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_2() {
        TreeNode root = null;
        Codec ser = new Codec();
        Codec deser = new Codec();
        String str = ser.serialize(root);
        TreeNode ans = deser.deserialize(str);
        boolean passed = ans == null;
        System.out.println("testSolution1_2: " + (passed ? "passed" : "failed"));
    }
    
}
