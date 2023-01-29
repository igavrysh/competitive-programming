package com.company;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodecFancyDelimExp2 {

    // WARNING!!! Code below is not working!!!
    // NOTE: Approach of using 1 byte to store length (up to 200 characters length, according to problem statment) before string bytes does not work due to couple factors
    //  * UTF8, UTF16 have variable char byte length
    //  * when I do byte[] -> String conversion in encode, java libs add service info ahead of array + treat them different somehow
    // approach below is hacky and uses shortcuts
    private static Charset CHARSET = Charset.forName("UTF-8");

    // Encodes string length to bytes string
    public String intToString(String s) {
        int x = s.length();
        char enc = (char) (x);
        return new String(new char[] { enc });
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        int totalBytes = 0;
        for (String s : strs) {
            //if (s.getBytes(CHARSET).length % 2 == 1) {
            //    return null;
            //}
            int byteLength = s.getBytes(CHARSET).length;
            totalBytes += byteLength;
            totalBytes += 1;
        }
        byte[] a = new byte[totalBytes];
        int i = 0;
        for (String s : strs) {
            byte[] bytes = s.getBytes(CHARSET);
            // UTF-16 is variable length, 2 or 4, don't want to spend time figuring out when its 
            // 4 bytes per char (based on 2 bytes prefix for string), so using 2 bytes here
            int currByteLength = bytes.length;
            //a[i++] = (byte)(currByteLength/2);
            a[i++] = (byte)(currByteLength);
            for (int j = 0; j < bytes.length; j++) {
                a[i] = bytes[j];
                i++;
            }
        }
        return new String(a, CHARSET);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> output = new ArrayList<>();
        byte[] bytes = s.getBytes(CHARSET);
        int i = 0;
        while (i < bytes.length) {
            int length = 
                ((0 & 0xFF) << 24) |
                ((0 & 0xFF) << 16) |
                ((0 & 0xFF) << 8) |
                ((bytes[i++] & 0xFF) << 0);
            //output.add(new String(Arrays.copyOfRange(bytes, i, length*2), CHARSET));
            output.add(new String(Arrays.copyOfRange(bytes, i, i+length), CHARSET));

            i += length;
        }
        return output;
    }
}
