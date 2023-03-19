import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) throws IOException {
        /* 
        test1();
        */

        List<long[]> Q = Solution.readInput();
        List<Long> output = new ArrayList<>();
        Solution s = new Solution();
        for (int i = 0; i < Q.size(); i++) {
            long[] query = Q.get(i);
            if (query[0] == 1l) {
                s.add(query[1]);
            } else if (query[0] == 2l) {
                s.delete(query[1]);
            } else if (query[0] == 3l) {
                long v = s.peek();
                output.add(v);
            }
        }
        Solution.writeOutput(output);
    }

    private ArrayList<Long> data;
    
    public Solution() {
        data = new ArrayList<Long>() {{ add(-1l); }};
    }

    public void add(long v) {
        data.add(v);
        siftup(data.size()-1);
    }

    public void delete(long v) {
        int i = search(1, v);
        if (i == -1) {
            return;
        }

        swap(i, data.size()-1);
        data.remove(data.size()-1);
        siftdown(i);
    }

    public long peek() {
       return data.get(1);
    }

    private int search(int i, long val) {
        if (i>=data.size() || data.get(i) > val) {
            return -1;
        }
        
        if (data.get(i)==val) {
            return i;
        }

        int idx = search(2*i, val);
        if (idx != -1) {
            return idx;
        }

        idx = search(2*i+1, val);
        return idx;
    }

    private void siftup(int i) {
        while (i > 1 && data.get(i) < data.get(i/2)) {
            swap(i, i/2);
            i /= 2;
        }
    }

    private void siftdown(int i) {
        while (2*i < data.size()) {
            int j = i;
            if (data.get(2*i) < data.get(j)) {
                j = 2*i;
            }
            if (2*i+1 < data.size() && data.get(2*i+1) < data.get(j)) {
                j = 2*i+1;
            }
            if (i==j) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    private void swap(int i, int j) {
        long tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }

    public static void test1() {
        boolean passed = true;
        long output = -2l;
        Solution s = new Solution();
        s.add(4l);
        s.add(9l);
        output = s.peek();
        passed = passed && output==4l;
        s.delete(4l);
        output = s.peek();
        passed = passed && output==9l;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static String[] readLineNSpaceSeparate(BufferedReader r) throws IOException {
        return r.readLine().replaceAll("\\s+$", "").split(" ");
    }

    private static List<long[]> readInput() throws IOException {
        List<long[]> Q = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = readLineNSpaceSeparate(br);
            long n = Long.parseLong(firstLine[0]);
            
            for (int i = 0; i < n; i++) {
                String[] nthLine = readLineNSpaceSeparate(br);
                long[] nums = new long[nthLine.length];
                for (int j = 0; j < nthLine.length; j++) {
                    nums[j] = Long.parseLong(nthLine[j]);
                }
                Q.add(nums);
            }
        }
        return Q;
    }

    private static void writeOutput(List<Long> output) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < output.size(); i++) {
                String outputStr = String.valueOf(output.get(i)); 
                bufferedWriter.write(outputStr);
                bufferedWriter.newLine();
            }
        }
    }
}