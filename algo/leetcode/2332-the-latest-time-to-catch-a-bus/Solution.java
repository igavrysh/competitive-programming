import java.util.Arrays;

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        /* 
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int[] queueSize = new int[passengers.length];
        int[] eopline = new int[buses.length];
        int currQS = 0;
        int b = 0;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] > buses[b]) {
                currQS = Math.max(0, currQS - capacity);
                eopline[b] = i;
                b++;
            } else { // e.g. if (passengers[p] <= busses[b])
                currQS += 1;
                queueSize[i] = currQS;
                if (passengers[i] == buses[b]) {
                    currQS = Math.max(0, currQS - capacity);
                    eopline[b] = i;
                    b++;
                }
            }
        }
        while (b < buses.length) {
            eopline[b] = passengers.length-1;
            b++;
        }
        */
        return -1;
    }

    private int bs(int l, int r, int capacity, int[] queueSize) {
        return -1;
        /*
        while (r-l > 1) {
            int m = l + (r-l)/2;
            if ()
        }
        */
    }    
}
