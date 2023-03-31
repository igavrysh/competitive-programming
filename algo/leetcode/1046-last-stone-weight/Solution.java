import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>(stones.length, (s1, s2) -> s2 - s1 );
        for (int i = 0; i < stones.length; i++) {
            PQ.add(stones[i]);
        }
        while (PQ.size() > 1) {
            int s1 = PQ.poll();
            int s2 = PQ.poll();
            if (s1>s2) {
                PQ.offer(s1-s2);
            }
        }
        return PQ.size() > 0 ? PQ.poll() : 0;
    }
}