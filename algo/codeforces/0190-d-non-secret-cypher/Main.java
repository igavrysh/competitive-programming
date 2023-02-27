import java.util.HashMap;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        
    }

    private int numberOfSubarraysWithKEqualNums(int[] a, int k) {
        HashMap<Integer, Integer> fq = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> rFq = new HashMap<>();
        fq.put(a[0], 1);
        int l=0,r=0;
        rFq.put(1, new HashSet<>(){{add(a[0]);}});
        int output=0;
        while (r<a.length) {

            if (rFq.get(k)!= null && rFq.get(k).size() != 0 || l==r) {
                if (rFq.get(k)!= null && rFq.get(k).size() != 0) {
                    output++;
                }
                r++;
                if (r<a.length) {
                    int pFq = fq.getOrDefault(a[r], 0);
                    fq.put(a[r], fq.getOrDefault(a[r], 0)+1);
                    HashSet<Integer> currRFq = rFq.getOrDefault(pFq, new HashSet<>());
                    currRFq.remove(a[r]);
                    HashSet<Integer> newRFq = rFq.getOrDefault(pFq+1, new HashSet<>());
                    newRFq.add(a[r]);
                    rFq.put(pFq+1, newRFq);
                }
            } else {
                int pFq = fq.getOrDefault(a[l], 0);

                l++;
            } 
        }

        return 0;
    }
}