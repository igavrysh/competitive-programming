import java.util.HashMap;

import com.company.TimeMap;

import java.util.ArrayList;

class Solution2 {

    private static class Record {
        public String value;
        public int timestamp;
        public Record(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, ArrayList<Record>> map = new HashMap<>();
    
    public Solution2() {}
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Record> d = map.getOrDefault(key, new ArrayList<Record>());
        int pos = bs(timestamp, d) + 1;
        d.add(pos, new Record(value, timestamp));
        map.put(key, d);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Record> d = map.get(key);
        if (d == null) {
            return "";
        }
        int pos = bs(timestamp, d);
        if (pos == -1) {
            return "";
        }
        return d.get(pos).value;
    }

    private int bs(int timestamp, ArrayList<Record> data) {
        int good = data.size();
        int bad = -1;
        while (good - bad > 1) {
            int m = bad + (good-bad)/2;
            if (data.get(m).timestamp > timestamp) {
                good = m;
            } else {
                bad = m;
            }
        }
        return bad;
    }

    public static void main(String[] args) {
        test1(); 
    }

    public static void test1() {
        Solution2 timeMap = new Solution2();
        boolean passed = true;
        timeMap.set("foo", "bar", 1); 
        passed = passed && timeMap.get("foo", 1).equals("bar"); 
        passed = passed && timeMap.get("foo", 3).equals("bar"); 
        timeMap.set("foo", "bar2", 4);
        passed = passed && timeMap.get("foo", 4).equals("bar2");
        passed = passed && timeMap.get("foo", 5).equals("bar2");
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */