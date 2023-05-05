import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionPQ2 {

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    private class Tuple {
        public int row, col, val;
        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Tuple> PQ = new PriorityQueue<>((Tuple t1, Tuple t2) -> {
            return t1.col != t2.col 
                ? t1.col - t2.col
                : (t1.row != t2.row
                    ? t1.row - t2.row
                    : t1.val - t2.val
                );
        });
        dfsToHeap(root, new Tuple(0, 0, root.val), PQ);
        List<List<Integer>> output = new ArrayList<>();
        while (!PQ.isEmpty()) {
            List<Integer> o = new ArrayList<>();
            Tuple curr = PQ.poll();
            o.add(curr.val);
            while (!PQ.isEmpty() && PQ.peek().col == curr.col) {
                curr = PQ.poll();
                o.add(curr.val);
            }
            output.add(o);
        }
        return output;
    }

    private void dfsToHeap(TreeNode node, Tuple tuple, PriorityQueue<Tuple> pq) {
        if (node == null) {
            return;
        }
        pq.add(tuple);
        if (node.left != null) {
            dfsToHeap(node.left, new Tuple(tuple.row+1, tuple.col-1, node.left.val), pq);
        }
        if (node.right != null) {
            dfsToHeap(node.right, new Tuple(tuple.row+1, tuple.col+1, node.right.val), pq);
        }
    }

    public static void testSolution_1() {
        TreeNode root = new TreeNode(3, 
            new TreeNode(9), 
            new TreeNode(20, 
                new TreeNode(15), 
                new TreeNode(7)));
        Integer[][] expectedOutput = {{9},{3,15},{20},{7}};
        SolutionPQ2 s = new SolutionPQ2();
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

        System.out.println("testSolutionPQ2_1: " + (passed ? "passed" : "failed"));
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
        SolutionPQ2 s = new SolutionPQ2();
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

        System.out.println("testSolutionPQ2_2: " + (passed ? "passed" : "failed"));
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

        SolutionPQ2 s = new SolutionPQ2();
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

        System.out.println("testSolutionPQ2_3: " + (passed ? "passed" : "failed"));
    }

}
