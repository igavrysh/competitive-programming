package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * https://github.com/igavrysh/competitive-programming/tree/master/algo/leetcode
 */

public class TimeMapOptimized {

    class Value {
        public String value;
        public byte timestamp;
        public Value(String value, byte timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, ArrayList<Value>> M;
    public TimeMapOptimized() {
        M = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Value> a = M.getOrDefault(key, new ArrayList<>());
        
        a.add(new Value(value, (byte)timestamp));
        M.put(key, a);
    }

    public String get(String key, int timestamp) {
        ArrayList<Value> a = M.getOrDefault(key, new ArrayList<>());
        if (a == null) {
            return "";
        }

        int idx = BS(a, timestamp);
        if (idx == -1) {
            return "";
        }

        return a.get(idx).value;
    }

    private int BS(ArrayList<Value> a, int timestamp) {
        if (a.size() == 0 || a.get(0).timestamp > timestamp) {
            return -1;
        }

        int l = 0, r = a.size()-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (a.get(m).timestamp == timestamp) {
                return m;
            } else if (a.get(m).timestamp < timestamp) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return a.get(l).timestamp <= timestamp ? l : l-1;
    }
}
