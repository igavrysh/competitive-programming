package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeMap {

    class Value {
        public String value;
        public byte timestamp;
        public Value(String value, byte timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, ArrayList<Value>> M;

    public TimeMap() {
        M = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Value> a = M.getOrDefault(key, new ArrayList<>());
        int idx = BS(a, timestamp, BSResultType.Set);
        if (idx < 0 || idx >= a.size()+1) {
            throw new RuntimeException("cannot find index to set value");
        }
        a.add(idx, new Value(value, (byte)timestamp));
        M.put(key, a);
    }

    public String get(String key, int timestamp) {
        ArrayList<Value> a = M.getOrDefault(key, new ArrayList<>());
        if (a == null) {
            return "";
        }

        int idx = BS(a, timestamp, BSResultType.Get);
        if (idx == -1) {
            return "";
        }

        return a.get(idx).value;
    }

    enum BSResultType {
        Set, 
        Get
    }

    private int BS(ArrayList<Value> a, int timestamp, BSResultType type) {
        if (type == BSResultType.Get
            && (a.size() == 0 || a.get(0).timestamp > timestamp)) {
            return -1;
        }

        if (type == BSResultType.Set 
            && a.size() > 0
            && a.get(a.size()-1).timestamp < timestamp) {
            return a.size();
        }
        int l = 0, r = a.size()-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (a.get(m).timestamp == timestamp) {
                if (type == BSResultType.Set) {
                    return m+1;
                } else if (type == BSResultType.Get) {
                    return m;
                }
                return -1;
            } else if (a.get(m).timestamp < timestamp) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return type == BSResultType.Set ? l : (a.get(l).timestamp <= timestamp ? l : l-1);
    }
}
