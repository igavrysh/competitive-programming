import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionPQ3 {
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

    private class Pair {
        public TreeNode node;
        public Tuple tuple;
        public Pair(TreeNode node, Tuple tuple) {
            this.node = node;
            this.tuple = tuple;
        }
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
        bfsToHeap(root, PQ);
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

    private void bfsToHeap(TreeNode root, PriorityQueue<Tuple> PQ) {
        Queue<Pair> Q = new LinkedList<>();
        if (root != null) {
            Tuple tuple = new Tuple(0, 0, root.val);
            Q.add(new Pair(root, tuple));
            PQ.add(tuple);
        }

        while (!Q.isEmpty()) {
            int l = Q.size();
            for (int i = 0; i < l; i++) {
                Pair p = Q.poll();
                if (p.node.left != null) {
                    Tuple tuple = new Tuple(p.tuple.row+1, p.tuple.col-1, p.node.left.val);
                    PQ.add(tuple);
                    Q.add(new Pair(p.node.left, tuple));
                }
                if (p.node.right != null) {
                    Tuple tuple = new Tuple(p.tuple.row+1, p.tuple.col+1, p.node.right.val);
                    PQ.add(tuple);
                    Q.add(new Pair(p.node.right, tuple));
                }
            }
        }
    }
}
