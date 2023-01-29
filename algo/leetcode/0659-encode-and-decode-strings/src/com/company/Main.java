package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testCodec1();
        testCodec2();

        testCodecFancyDelim1();

        testCodecFancyDelimExp1();
        testCodecFancyDelimExp2();

        //testCodecFancyDelimExp21();
        testCodecFancyDelimExp22();
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

    public static void testCodecFancyDelim1() {
        String[] inputA = new String[]{"Hello","ABVWorld"};
        List<String> input = Arrays.asList(inputA);
        CodecFancyDelim codec = new CodecFancyDelim();
        String encoded = codec.encode(input);
        System.out.println("Encoded: " + encoded);

        List<String> output = codec.decode(encoded);
        boolean passed = Arrays.deepEquals(output.toArray(), inputA);
        System.out.println("testCodecFancyDelim1: " + (passed ? "passed" : "failed"));
    }

    public static void testCodecFancyDelimExp1() {
        String[] inputA = new String[]{"Hello","World"};
        List<String> input = Arrays.asList(inputA);
        CodecFancyDelimExp codec = new CodecFancyDelimExp();
        String encoded = codec.encode(input);
        List<String> output = codec.decode(encoded);
        boolean passed = Arrays.deepEquals(output.toArray(), inputA);
        System.out.println("testCodecFancyDelimExp1: " + (passed ? "passed" : "failed"));
    }

    public static void testCodecFancyDelimExp2() {
        String[] inputA = new String[]{
            "I profiled it once using char[], once using String[], and once using Character[].",
            "Is there a difference in size between a String \"a\" and a Char 'a'? Should you use a Char when you need to save single letters or numbers?",
            "There is no size difference between a String of one letter and a char of one letter (referring to the backing char array of the String, that is). Currently, they both require 2 bytes as per UTF-16 enc"};
        List<String> input = Arrays.asList(inputA);
        CodecFancyDelimExp codec = new CodecFancyDelimExp();
        String encoded = codec.encode(input);
        List<String> output = codec.decode(encoded);
        boolean passed = Arrays.deepEquals(output.toArray(), inputA);
        System.out.println("testCodecFancyDelimExp2: " + (passed ? "passed" : "failed"));
    }

    public static void testCodecFancyDelimExp21() {
        String[] inputA = new String[]{"Hello","World"};
        List<String> input = Arrays.asList(inputA);
        CodecFancyDelimExp2 codec = new CodecFancyDelimExp2();
        String encoded = codec.encode(input);
        List<String> output = codec.decode(encoded);
        boolean passed = Arrays.deepEquals(output.toArray(), inputA);
        System.out.println("testCodecFancyDelimExp21: " + (passed ? "passed" : "failed"));
    }

    public static void testCodecFancyDelimExp22() {
        String[] inputA = new String[]{
            "I profiled it once using char[], once using String[], and once using Character[].",
            "Is there a difference in size between a String a and a Char 'a'? Should you use a Char when you need to save single letters or numbers?",
            "There is no size difference between a String of one letter and a char of one letter (referring to the backing char array of the String, that is). Currently, they both require 2 bytes as per UTF-16 enc"};
        List<String> input = Arrays.asList(inputA);
        CodecFancyDelimExp2 codec = new CodecFancyDelimExp2();
        String encoded = codec.encode(input);
        List<String> output = codec.decode(encoded);
        boolean passed = Arrays.deepEquals(output.toArray(), inputA);
        System.out.println("testCodecFancyDelimExp22: " + (passed ? "passed" : "failed"));
    }
}