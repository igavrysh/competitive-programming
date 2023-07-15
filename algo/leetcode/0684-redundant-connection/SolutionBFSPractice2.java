import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFSPractice2 {
    public int[] findRedundantConnection(int[][] edges) {
        int E = edges.length;
        int V = 0;
        for (int i = 0; i < E; i++) {
            V = Math.max(V, Math.max(edges[i][0], edges[i][1]));
        }

        int[] depend = new int[V];
        HashSet<Integer>[] G = new HashSet[V];
        for(int i = 0; i < V; i++) {
            G[i] = new HashSet<>();
        }
        
        for(int[] edge: edges) {
            int v1 = edge[0]-1;
            int v2 = edge[1]-1;
            depend[v1]++;
            depend[v2]++;
            G[v2].add(v1);
            G[v1].add(v2);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int j = 0; j < V; j++) {
            if(depend[j] == 1) queue.add(j);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            depend[cur]--;
            for(int k: G[cur]) {
                depend[k]--;
                G[k].remove(cur);
                if(depend[k] == 1) {
                    queue.add(k);
                }
            }
        }
        for(int m = E-1 ; m >= 0; m--) {
            if(depend[edges[m][0]-1] != 0 && depend[edges[m][1]-1] != 0) {
                return edges[m];
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        testSolutionBFSPractice2_1();
        testSolutionBFSPractice2_2();   
    }

    public static void testSolutionBFSPractice2_1() {
        int[][] edges = {{1,2},{1,3},{2,3}};
        SolutionBFSPractice2 s = new SolutionBFSPractice2();
        int[] output = s.findRedundantConnection(edges);
        int[] expOutput = new int[]{2,3};
        boolean passed = output[0] == expOutput[0] && output[1] == expOutput[1];
        System.out.println("testSolutionBFSPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBFSPractice2_2() {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        SolutionBFSPractice2 s = new SolutionBFSPractice2();
        int[] output = s.findRedundantConnection(edges);
        int[] expOutput = new int[]{1,4};
        boolean passed = output[0] == expOutput[0] && output[1] == expOutput[1];
        System.out.println("testSolutionBFSPractice2_2: " + (passed ? "passed" : "failed"));
    }
}
