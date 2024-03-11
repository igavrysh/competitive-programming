import java.util.HashMap;
import java.util.Map;

public class SnapshotArray3 {
    int snapId;

    HashMap<Integer, Integer>[] arr;

    public SnapshotArray3(int length) {
        snapId = 0;
        arr = new HashMap[length];
    }

    public void set(int index, int val) {
        if (arr[index] == null) arr[index] = new HashMap<>();
        arr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        if (arr[index] == null) return 0;
        Map<Integer, Integer> map = arr[index];
        if (map.containsKey(snap_id)) return map.get(snap_id);
        int minDiff = snapId, idSearch = snap_id;
        for (int sid : map.keySet()) {
            int diff = snap_id - sid;
            if (diff >= 0 && diff < minDiff) {
                minDiff = diff;
                idSearch = sid;
            }
        }
        return idSearch == snap_id ? 0 : map.get(idSearch);
    }
}
