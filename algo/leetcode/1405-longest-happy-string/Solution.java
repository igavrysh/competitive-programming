import java.util.PriorityQueue;
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> -1*Integer.compare(p1[1], p2[1]));
        if (a > 0) pq.offer(new int[]{0,a});
        if (b > 0) pq.offer(new int[]{1,b});
        if (c > 0) pq.offer(new int[]{2,c});
        int[] prev_pair = null;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            if (prev_pair != null) {
                pq.offer(prev_pair);
            }
            sb.append((char)(pair[0]+'a'));
            pair[1]--;
            if (pair[1] > 0 && (pq.isEmpty() || pq.peek()[1] <= pair[1])) {
                sb.append((char)(pair[0]+'a'));
                pair[1]--;
            }
            if (pair[1] > 0) {
                prev_pair = pair;
            } else {
                prev_pair = null;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int a = 4;
        int b = 4;
        int c = 3;
        int expLength = 11;
        Solution sol = new Solution();
        String output = sol.longestDiverseString(a, b, c);
        boolean passed = expLength == output.length();
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }
}