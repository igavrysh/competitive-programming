package com.company;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(String.valueOf(str.length()));
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        int fromIndex = 0;
        int hashIndex = s.indexOf("#", fromIndex);
        while (hashIndex != -1) {
            String sNum = s.substring(fromIndex, hashIndex);
            int length = Integer.valueOf(sNum);
            String str = s.substring(hashIndex+1, hashIndex+1+length);
            strs.add(str);
            fromIndex = hashIndex+1+length;
            hashIndex = s.indexOf("#", fromIndex);
        }
        return strs;
    }
}