package com.company;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        experimet();
    }

    private static Function<byte[][], Boolean> slow = (image) -> {
        int N = image.length;
        int count = 0;
        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < N; ++i) {
                int val = (int)(image[i][j] & 0xFF);
                if (val >= 128) {
                    count += 1; 
                }
            } 
        }
        return count < N * N / 2;
    };

    private static Function<byte[][], Boolean> impr1 = (image) -> {
        int N = image.length;
        //int filter = N * N / 2;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = (int)(image[i][j] & 0xFF);
                if (val >= 128) {
                    count += 1; 
                }
                /* 
                // Can use sentinel tech to get rid of that, but cannot modify byte[][] array locally
                // e.g. add MAX_BYTE in the end 
                if (count >= filter) {
                    return false;
                }
                */
            } 
        }
        return count < N * N / 2;
    };


    private static Function<byte[][], Boolean> impr2 = (image) -> {
        int N = image.length;
        int filter = N * N / 2;
        //filterLog = (int)(Math.log(filter) / Math.log(2));
        int count = 0;
        //int offset = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = (int)(image[i][j] & 0xFF);
                count += (val >> 7) & 1;

                //offset = ((count >> filterLog) & 1) * 4096;
                //i += offset;
                //j += offset;
            } 
        }
        return count < N * N / 2;
    };

    private static void experimet() {
        int imgSize = 4096;
        int[] experimentTimes = new int[] {1, 5, 10, 20, 30};

        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);

        for (int i = 0; i < experimentTimes.length; i++) {
            long accTimeSlow = 0, accTimeImpr1 = 0, accTimeImpr2 = 0;
            for (int j = 0; j < experimentTimes[i]; j++) {
                byte[][] img = randomImage(imgSize);

                boolean isDarkSlow = false;
                {
                    long startTime = System.nanoTime();
                    isDarkSlow = slow.apply(img);
                    long stopTime = System.nanoTime();
                    accTimeSlow += stopTime - startTime;
                }

                boolean isDarkImpr1 = false;
                {
                    long startTime = System.nanoTime();
                    isDarkImpr1 = impr1.apply(img);
                    long stopTime = System.nanoTime();
                    accTimeImpr1 += stopTime - startTime;
                }

                boolean isDarkImpr2 = false;
                {
                    long startTime = System.nanoTime();
                    isDarkImpr2 = impr2.apply(img);
                    long stopTime = System.nanoTime();
                    accTimeImpr2 += stopTime - startTime;
                }
                

                if (isDarkImpr1 != isDarkSlow || isDarkImpr2 != isDarkSlow) {
                    System.out.println("ERROR! mismatch in func results");
                }
                
            }

            double avgTimeSlow = accTimeSlow * 1.0 / experimentTimes[i];

            double avgTimeImpr1 = accTimeImpr1 * 1.0 / experimentTimes[i];

            double avgTimeImpr2 = accTimeImpr2 * 1.0 / experimentTimes[i];

           
            System.out.println("Number of experiments: " + experimentTimes[i] 
                + "; avg time slow: \t" + df.format(avgTimeSlow) + " micros" 
            );

            System.out.println("Number of experiments: " + experimentTimes[i] 
                + "; avg time impr1: \t" + df.format(avgTimeImpr1) + " micros" 
            );

            System.out.println("Number of experiments: " + experimentTimes[i] 
                + "; avg time impr2: \t" + df.format(avgTimeImpr2) + " micros" 
            );
        }
    }

    private static byte[][] randomImage(int size) {
        Random random = new Random();
        byte[][] img = new byte[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                img[i][j] = (byte)random.nextInt((int)Math.pow(2, 8));
            }
        }
        return img;
    }
}