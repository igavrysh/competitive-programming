import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    private class Pair {
        public int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // the same as Pair, introduced to improve code readability
    private class PairKV {
        public int key, value;
        public PairKV(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<TreeNode, Pair> map = new HashMap<>();
        Pair rootP = new Pair(0, 0);
        dfsMapToPairs(root, rootP, map);

        HashMap<Integer, ArrayList<Integer>> acc = new HashMap<>();
        int[] minMaxColumn = {0, 0};
        bfsMapToColumns(root, map, acc, minMaxColumn);

        List<List<Integer>> output = new ArrayList<>();
        for (int i = minMaxColumn[0]; i <= minMaxColumn[1]; i++) {
            if (acc.get(i) != null) {
                output.add(acc.get(i));
            }
        }

        return output;
    }

    private void dfsMapToPairs(TreeNode node, Pair p, HashMap<TreeNode, Pair> map) {
        if (node == null) {
            return;
        }

        if (node != null) {
            map.put(node, p);
        }
        dfsMapToPairs(node.left, new Pair(p.row+1, p.col-1), map);
        dfsMapToPairs(node.right, new Pair(p.row+1, p.col+1), map);
    }

    private void bfsMapToColumns(TreeNode root, HashMap<TreeNode, Pair> map, HashMap<Integer, ArrayList<Integer>> acc, int[] minMaxColumn) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        minMaxColumn[0] = 0;
        while (!Q.isEmpty()) {
            int l = Q.size();
            List<PairKV> a = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode node = Q.poll();
                Pair p = map.get(node);
                a.add(new PairKV(p.col, node.val));

                minMaxColumn[0] = Math.min(minMaxColumn[0], p.col);
                minMaxColumn[1] = Math.max(minMaxColumn[1], p.col);


                if (node.left != null) {
                    Q.add(node.left);
                }

                if (node.right != null) {
                    Q.add(node.right);
                }
            }

            a.sort((p1, p2) -> (p1.key == p2.key) ? (p1.value - p2.value) : (p1.key - p2.key));
            for (int i = 0; i < a.size(); i++) {
                PairKV el = a.get(i);
                ArrayList<Integer> arr = acc.getOrDefault(el.key, new ArrayList<>());
                arr.add(el.value);
                acc.put(el.key, arr);
            }
        }
    }

    public static void testSolution_1() {
        TreeNode root = new TreeNode(3, 
            new TreeNode(9), 
            new TreeNode(20, 
                new TreeNode(15), 
                new TreeNode(7)));
        Integer[][] expectedOutput = {{9},{3,15},{20},{7}};

        Solution s = new Solution();
        List<List<Integer>> output = s.verticalTraversal(root);
        Integer[][] outputArr = new Integer[output.size()][];
        for (int i = 0; i < output.size(); i++) {
            List<Integer> o = output.get(i);
            Integer[] arr = new Integer[o.size()];
            for (int j = 0; j < o.size(); j++) {
                arr[j] = o.get(j);
            }
            outputArr[i] = arr;
        }

        boolean passed = true;
        for (int i = 0; i < expectedOutput.length; i++) {
            passed =  passed && Arrays.deepEquals(expectedOutput[i], outputArr[i]);
        }

        System.out.println("testSolution_1: " + (passed ? "passed" : "faled"));
    }

    public static void testSolution_2() {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5)), 
            new TreeNode(3, 
                new TreeNode(6), 
                new TreeNode(7)));
        Integer[][] expectedOutput = {{4},{2},{1,5,6},{3},{7}};

        Solution s = new Solution();
        List<List<Integer>> output = s.verticalTraversal(root);
        Integer[][] outputArr = new Integer[output.size()][];
        for (int i = 0; i < output.size(); i++) {
            List<Integer> o = output.get(i);
            Integer[] arr = new Integer[o.size()];
            for (int j = 0; j < o.size(); j++) {
                arr[j] = o.get(j);
            }
            outputArr[i] = arr;
        }

        boolean passed = true;
        for (int i = 0; i < expectedOutput.length; i++) {
            passed =  passed && Arrays.deepEquals(expectedOutput[i], outputArr[i]);
        }

        System.out.println("testSolution_2: " + (passed ? "passed" : "faled"));
    }

    public static void testSolution_3() {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(6)), 
            new TreeNode(3, 
                new TreeNode(5), 
                new TreeNode(7)));
        Integer[][] expectedOutput = {{4},{2},{1,5,6},{3},{7}};

        Solution s = new Solution();
        List<List<Integer>> output = s.verticalTraversal(root);
        Integer[][] outputArr = new Integer[output.size()][];
        for (int i = 0; i < output.size(); i++) {
            List<Integer> o = output.get(i);
            Integer[] arr = new Integer[o.size()];
            for (int j = 0; j < o.size(); j++) {
                arr[j] = o.get(j);
            }
            outputArr[i] = arr;
        }

        boolean passed = true;
        for (int i = 0; i < expectedOutput.length; i++) {
            passed =  passed && Arrays.deepEquals(expectedOutput[i], outputArr[i]);
        }

        System.out.println("testSolution_2: " + (passed ? "passed" : "faled"));
    }

}