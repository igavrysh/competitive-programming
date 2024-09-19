import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numBusesToDestination(int[][] routes_input, int source, int target) {
        long nanoTime = 0;
        long nanoTimeSt = System.nanoTime();
        nanoTime = System.nanoTime();
        //System.out.println("d0: " + (nanoTime-nanoTimeSt));

        if (source == target) {
            return 0;
        }
        HashMap<Integer, HashSet<Integer>> routes = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> station_to_route = new HashMap<>();
        boolean[][] edges = new boolean[500][500];
        int r_id = 0;
        for (int i = 0; i < routes_input.length; i++) {
            for (int j = 0; j < routes_input[i].length; j++) {
                HashSet<Integer> station_routes = station_to_route.getOrDefault(
                        routes_input[i][j], new HashSet<>());
                for (Integer other_r_id : station_routes) {
                    edges[r_id][other_r_id] = true;
                    edges[other_r_id][r_id] = true;
                }
                station_routes.add(r_id);
                station_to_route.put(routes_input[i][j], station_routes);
            }
            r_id++;
        }

        nanoTime = System.nanoTime();
        //System.out.println("d1: " + (nanoTime-nanoTimeSt));

        // stataions: 10^6, routes:500x500=250000~10^5, O(n^11)

        for (int i = 0; i < routes_input.length; i++) {
            routes.put(i, new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j]) {
                    routes.get(i).add(j);
                    routes.get(j).add(i);
                }
            }
        }
           
        nanoTime = System.nanoTime();
        //System.out.println("d2: " + (nanoTime-nanoTimeSt));

        HashSet<Integer> r_trgt = station_to_route.get(target);
        if (r_trgt == null) {
            return -1;
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> routes_source = station_to_route.get(source);
        if (routes_source == null) {
            return -1;
        }
        for (int r_src : routes_source) {
            visited.add(r_src);
            q.offer(r_src);
        }
        int jumps = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int curr = q.poll();
                if (r_trgt.contains(curr)) {

                    nanoTime = System.nanoTime();
                    //System.out.println("d3: " + (nanoTime-nanoTimeSt));

                    return jumps;
                }
                HashSet<Integer> ngbrs = routes.get(curr);
                if (ngbrs == null) {
                    continue;
                }
                for (Integer ngbr : ngbrs) {
                    if (visited.contains(ngbr)) {
                        continue;
                    }
                    visited.add(ngbr);
                    q.offer(ngbr);
                }
            }
            jumps++;
        }
        nanoTime = System.nanoTime();
        //System.out.println("d3: " + (nanoTime-nanoTimeSt));

        return -1;
    }

    public static void main(String[] args) {
        test47();
    }

    public static void test47() {
        ArrayList<ArrayList<Integer>> inputrows = new ArrayList<>();

        // Replace "input.txt" with the path to your input file
        String input_filepath = "test47.in";

        try (BufferedReader reader = new BufferedReader(new FileReader(input_filepath))) {
            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {
                ArrayList<Integer> numbers = new ArrayList<>();

                line = line.trim(); // Trim leading and trailing spaces from the line

                // Split each line by commas
                String[] numberStrings = line.split(",");

                // Process each number in the line
                for (String numStr : numberStrings) {
                    numStr = numStr.trim(); // Trim spaces around the number

                    if (!numStr.isEmpty()) { // Ensure the string is not empty
                        try {
                            numbers.add(Integer.parseInt(numStr)); // Parse the number and add to the list
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number ignored: " + numStr);
                        }
                    }
                }
                inputrows.add(numbers);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        String output_filepath = "test47-out";
        int exp_output = 0;
        try (BufferedReader reader2 = new BufferedReader(new FileReader(output_filepath))) {
            String line = reader2.readLine();
            line = line.trim(); // Trim leading and trailing spaces from the line
            exp_output = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        int[][] routes = new int[inputrows.size()-2][];
        for (int i = 0; i < routes.length; i++) {
            routes[i] = new int[inputrows.get(i).size()];
            for (int j = 0; j < routes[i].length; j++) {
                routes[i][j] = inputrows.get(i).get(j);
            }
        }
        int source = inputrows.get(inputrows.size()-2).get(0);
        int target = inputrows.get(inputrows.size()-1).get(0);
        Solution sol = new Solution();
        int output = sol.numBusesToDestination(routes, source, target);
        boolean passed = output == exp_output;
        System.out.println("test47: " + (passed ? "passed" : "failed"));
    }
}