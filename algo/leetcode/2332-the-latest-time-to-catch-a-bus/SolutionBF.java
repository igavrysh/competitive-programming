import java.util.Arrays;

public class SolutionBF {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int cap) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int b_ptr = 0;
        int latestTime = 1;
        int qs = 0;
        int prev_pass_t = -1;
        for (int i = 0; i < passengers.length; i++) {
            if (b_ptr >= buses.length) { break; }
            if (buses[b_ptr] < passengers[i]) {
                if (qs < (buses.length-b_ptr)*cap && prev_pass_t != buses[b_ptr]) {
                    latestTime = buses[b_ptr];
                }
                qs = Math.max(0, qs - cap);
                if (qs < (buses.length-(b_ptr+1))*cap && prev_pass_t != buses[b_ptr]) {
                    latestTime = buses[b_ptr];
                }
                b_ptr++;
                i--;
                continue;
            }
            if (passengers[i]-1 != prev_pass_t && qs < (buses.length-b_ptr)*cap) {
                latestTime = passengers[i]-1;
            }
            prev_pass_t = passengers[i];
            qs++;
        }

        while (b_ptr < buses.length && qs < (buses.length - b_ptr)*cap) {
            if (buses[b_ptr] != prev_pass_t) {
                latestTime = buses[b_ptr];
            }
            qs = Math.max(qs-cap, 0);
            b_ptr++;
        }
        return latestTime;
    }

    public static void main(String[] args) {
        test3();
        test1();
        test2();
    }

    public static void test1() {
        int[] buses = {10,20};
        int[] passengers = {2,17,18,19};
        int capacity = 2;
        int expOutput = 16;
        SolutionBF sol = new SolutionBF();
        int output = sol.latestTimeCatchTheBus(buses, passengers, capacity);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] buses = {20,10,30};
        int[] passengers = {19,13,26,4,25,11,21};
        int capacity = 2;
        int expOutput = 20;
        SolutionBF sol = new SolutionBF();
        int output = sol.latestTimeCatchTheBus(buses, passengers, capacity);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        //int[] buses = {2,3,5,7,8,9,12,13,18,20};
        //int[] passengers = {2,4,5,8,10,12,13,14,18,19,30,34};
        int[] busses = {18,8,3,12,9,2,7,13,20,5};
        int[] passengers = {13,10,8,4,12,14,18,19,5,2,30,34}; 
        int capacity = 1;
        int expOutput = 11;
        SolutionBF sol = new SolutionBF();
        int output = sol.latestTimeCatchTheBus(busses, passengers, capacity);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }    
}
