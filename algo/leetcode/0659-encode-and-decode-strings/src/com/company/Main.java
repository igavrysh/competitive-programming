package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testCodec1();
        testCodec2();
    }

    public static void testCodec1() {
        String[] inputA = new String[]{"Hello","World"};
        List<String> input = Arrays.asList(inputA);
        Codec codec = new Codec();
        String encoded = codec.encode(input);
        List<String> output = codec.decode(encoded);
        boolean passed = Arrays.deepEquals(output.toArray(), inputA);
        System.out.println("testCodec1: " + (passed ? "passed" : "failed"));
    }

    public static void testCodec2() {
        String[] inputA = new String[]{""};
        List<String> input = Arrays.asList(inputA);
        Codec codec = new Codec();
        String encoded = codec.encode(input);
        List<String> output = codec.decode(encoded);
        boolean passed = Arrays.deepEquals(output.toArray(), inputA);
        System.out.println("testCodec2: " + (passed ? "passed" : "failed"));
    }
}