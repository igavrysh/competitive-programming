package com.company;
import java.util.ArrayList;
import java.util.List;

public class CodecFancyDelimExp {
    // Encodes string length to bytes string
    public String intToString(String s) {
        int x = s.length();
        char enc = (char)(x); 
        return new String(new char[]{enc});
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(intToString(s));
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
        char[] chrs = bytesStr.toCharArray();
        return (int)chrs[0];
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, n = s.length();
        List<String> output = new ArrayList<>();
        while (i < n) {
            int length = stringToInt(s.substring(i, i + 1));
            i += 1;
            output.add(s.substring(i, i + length));
            i += length;
        }
        return output;
    }
}