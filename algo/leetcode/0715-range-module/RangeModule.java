import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RangeModule {

    TreeMap<Integer, Integer> M;

    public RangeModule() {
        M = new TreeMap<>();
    }

    public boolean queryRange(int left, int right) {
        Integer l = M.floorKey(left);
        if (l == null || M.get(l) < right) {
            return false;
        }
        return true;
    }

    public void addRange(int left, int right) {
        if (left >= right) {
            return;
        }

        Integer l = M.floorKey(left);
        Integer r = M.floorKey(right);
        int addLeft = 0, addRight = 0;
       
        int removeFrom = left;
        int removeTo = right;

        if (l == null) {
            addLeft = left;
        } else {
            if (M.get(l) < left) {
                addLeft = left;
            } else {
                addLeft = l;
                removeFrom = l;
            }
        }

        if (r == null) {
            addRight = right;
        } else {
            if (M.get(r) <= right) {
                addRight = right;
            } else {
                addRight = M.get(r);
            }
        }

        Map<Integer, Integer> subMap = M.subMap(removeFrom, true, removeTo, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        M.keySet().removeAll(set);

        M.put(addLeft, addRight);
    }

    public void removeRange(int left, int right) {
        if (left >= right) {
            return;
        }

        Integer l = M.floorKey(left);
        Integer r = M.floorKey(right);

        Integer toAdd1L = null;
        Integer toAdd1R = null;
        Integer toAdd2L = null;
        Integer toAdd2R = null;
        int removeFrom = left;
        int removeTo = right;
        if (l == null) {
        } else {
            if (M.get(l) > left) {
                toAdd1L = l;
                toAdd1R = left;
                removeFrom = l;
            }
        }

        if (r == null) {
        } else {
            if (M.get(r) > right) {
                int val = M.get(r);
                toAdd2L = right;
                toAdd2R = val;
            }
        }

        Map<Integer, Integer> subMap = M.subMap(removeFrom, true, removeTo, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        M.keySet().removeAll(set);
        
        if (toAdd1L != null && toAdd1R != null) {
            M.put(toAdd1L, toAdd1R);
        }
        if (toAdd2L != null && toAdd2R != null) {
            M.put(toAdd2L, toAdd2R);
        }
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        boolean passed = true;
        RangeModule rm = new RangeModule();
        rm.addRange(10, 20);
        rm.removeRange(14, 16);
        passed &= (rm.queryRange(10, 14) == true);
        passed &= (rm.queryRange(13, 15) == false);
        passed &= (rm.queryRange(16, 17) == true);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}
/*
["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
[[],            [10, 20],   [14, 16],      [10, 14],    [13, 15],       [16, 17]]
Output
[null,          null,       null,           true,       false,          true]
 */


/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */ 
