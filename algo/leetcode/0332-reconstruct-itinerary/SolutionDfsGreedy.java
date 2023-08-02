import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class SolutionDfsGreedy {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashSet<String> namesS = new HashSet<>();
        for (List<String> ticket : tickets) {
            namesS.addAll(ticket);
        }
        String[] names = namesS.toArray(new String[namesS.size()]);
        int V = names.length;
        int E = tickets.size();
    
        Arrays.sort(names, String::compareTo);
        HashMap<String, Integer> M = new HashMap<>(); 
        ArrayList<Integer>[] G = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            M.put(names[i], i);
            G[i] = new ArrayList<>();
        }
  
        for (List<String> ticket : tickets) {
            Integer key = M.get(ticket.get(0));
            Integer val = M.get(ticket.get(1));
            G[key].add(val);
        }

        for (int i = 0; i < V; i++) {
            G[i].sort(Integer::compare);
        }
        boolean[][] visited = new boolean[V][];
        for (int i = 0; i < V; i++) {
            visited[i] = new boolean[G[i].size()];
        }

        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        Integer startV = M.get("JFK");
        if (startV == null) {
            return result;
        }

        path.add(startV);
        dfs(startV, G, visited, path, E+1);
        
        if (path.size() != E+1) {
            return result;
        }
        for (int i = 0; i < path.size(); i++) {
            result.add(names[path.get(i)]);
        }

        return result;
    }

    private void dfs(Integer curr, ArrayList<Integer>[] G, boolean[][] visited, List<Integer> path, int taget) {
        if (path.size() == taget) {
            return;
        }
        ArrayList<Integer> neighbours = G[curr];
        for (int i = 0; i < neighbours.size(); i++) {
            Integer next = neighbours.get(i);
            if (!visited[curr][i]) {
                visited[curr][i] = true;
                path.add(next);
                dfs(next, G, visited, path, taget);
                if (path.size() == taget) {
                    return;
                }

                visited[curr][i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        testSolutionDfsGreedy_1();
        testSolutionDfsGreedy_2();
    }

    public static void testSolutionDfsGreedy_1() {
        String[][] ticketsA = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        List<List<String>> tickets = new ArrayList<>();
        for (int i = 0; i < ticketsA.length; i++) {
            tickets.add(Arrays.asList(ticketsA[i]));
        }
        SolutionDfsGreedy s = new SolutionDfsGreedy();

        List<String> path = s.findItinerary(tickets);
        String[] output = path.toArray(new String[path.size()]);
        String[] expectedOutput = {"JFK","MUC","LHR","SFO","SJC"};
        boolean passed = Arrays.deepEquals(output, expectedOutput);
        System.out.println("testSolutionDfsGreedy_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDfsGreedy_2() {
        String[][] ticketsA = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> tickets = new ArrayList<>();
        for (int i = 0; i < ticketsA.length; i++) {
            tickets.add(Arrays.asList(ticketsA[i]));
        }
        SolutionDfsGreedy s = new SolutionDfsGreedy();

        List<String> path = s.findItinerary(tickets);
        String[] output = path.toArray(new String[path.size()]);
        String[] expectedOutput = {"JFK","ATL","JFK","SFO","ATL","SFO"};
        boolean passed = Arrays.deepEquals(output, expectedOutput);
        System.out.println("testSolutionDfsGreedy_2: " + (passed ? "passed" : "failed"));
    }
}