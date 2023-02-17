package com.company;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        experimet();
    }

    private static BiFunction<byte[][], Integer[], Boolean> slow = (image, iters) -> {
        int N = image.length;
        int count = 0;
        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < N; ++i) {
                int val = (int)(image[i][j] & 0xFF);
                if (val >= 128) {
                    count += 1; 
                }

                iters[0] = iters[0]+1;
            } 
        }
        return count < N * N / 2;
    };

    private static BiFunction<byte[][], Integer[], Boolean> impr1 = (image, iters) -> {
        int N = image.length;
        int filter = N * N / 2;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = (int)(image[i][j] & 0xFF);
                if (val >= 128) {
                    count += 1; 
                }

                if (count >= filter) {
                    return false;
                }
                iters[0] = iters[0]+1;
            } 
        }
        return count < N * N / 2;
    };


    private static void experimet() {
        int imgSize = 4096;
        int[] experimentTimes = new int[] {1, 5, 10};

        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);

        for (int i = 0; i < experimentTimes.length; i++) {
            int accItersSlow = 0;
            long accTimeSlow = 0;

            int accItersImpr1 = 0;
            long accTimeImpr1 = 0;

            for (int j = 0; j < experimentTimes[i]; j++) {
                byte[][] img = randomImage(imgSize);

                boolean isDarkSlow = false;
                {
                    Integer[] iters = new Integer[]{0};
                    long startTime = System.nanoTime();
                    isDarkSlow = slow.apply(img, iters);
                    long stopTime = System.nanoTime();
                    accItersSlow += iters[0];
                    accTimeSlow += stopTime - startTime;
                }

                boolean isDarkImpr1 = false;
                {
                    Integer[] iters = new Integer[]{0};
                    long startTime = System.nanoTime();
                    isDarkImpr1 = impr1.apply(img, iters);
                    long stopTime = System.nanoTime();
                    accItersImpr1 += iters[0];
                    accTimeImpr1 += stopTime - startTime;
                }

                if (isDarkImpr1 != isDarkSlow) {
                    System.out.println("ERROR! mismatch in func results");
                }
            }

            double avgTimeSlow = accTimeSlow * 1.0 / experimentTimes[i];
            double avgItersSlow = (accItersSlow * 1.0 / experimentTimes[i]);

            double avgTimeImpr1 = accTimeImpr1 * 1.0 / experimentTimes[i];
            double avgItersImpr1 = (accItersImpr1 * 1.0 / experimentTimes[i]);
           
            System.out.println("Number of experiments: " + experimentTimes[i] 
                + "; avg time slow: \t" + df.format(avgTimeSlow) + " micros" 
                + "; avg iters slow: \t" + df.format(avgItersSlow) 
            );

            System.out.println("Number of experiments: " + experimentTimes[i] 
                + "; avg time impr1: \t" + df.format(avgTimeImpr1) + " micros" 
                + "; avg iters impr1: \t" + df.format(avgItersImpr1) 
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