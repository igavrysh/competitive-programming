package com.company;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

public class Main {

    private static float MIN_X = (float)(-20* Math.PI);
    private static float MAX_X = (float)(20 * Math.PI); 

    private static double SHARE_OF_DESCRETE = 0.9;


    public static void main(String[] args) {
        experimet();
        testSinTranslate();
    }

    // translate arg value for sin into the range of matching Taylor function args range: [-Math.PI, +Math.PI]
    private static double sinTranslate(double x) {
        int div = Math.abs((int)(x / Math.PI));
        if (x < -Math.PI || x > Math.PI) {
            x = x + (x > 0 ? -1 : 1) * (div%2==0 ? div : div+1) * Math.PI;
        }
        return x;
    }

    private static void sinx(int N, int terms, float[] x, float[] result) {
        for (int i = 0; i < N; i++) {
            float x_i = (float)sinTranslate(x[i]);
            float value = x_i;
            float numer = x_i * x_i * x_i;
            int denom = 6; // 3!
            int sign = -1;
            for (int j = 1; j <= terms; j++) {
                value += sign * numer / denom;
                numer *= x_i * x_i;
                denom *= (2*j+2) * (2*j+3);
                sign *= -1;
            }
            result[i] = value;
        }
    }

    private static void sinxImpr1(int N, int terms, float[] x, float[] result) {
        for (int i = 0; i < N; i++) {
            float x_i = (float)sinTranslate(x[i]);

            
            Integer mapVal = (int)(x_i * Math.pow(10, DESCRETE_MAP_POW));
            if (SINX_MAP.get(mapVal) != null) {
                result[i] = SINX_MAP.get(mapVal);
                continue;
            }
            

            float x_i_sq = x_i * x_i;
            float x_i_trip = x_i_sq * x_i;
            float value = x_i;
            float numer = x_i_trip;
            for (int j = 1; j <= terms; j++) {
                value += numer / DENOM[j];
                numer *= x_i_sq;
            }
            result[i] = value;
        }
    }

    private static void sinGolden(int N, int terms, float[] x, float[] result) {
        for (int i = 0; i < N; i++) {
            result[i] = (float)Math.sin(x[i]);
        }
    }

    private static int[] DENOM = generateDenom(20);
    private static int[] generateDenom(int N) {
        int[] res = new int[N];
        int denom = 1;
        res[0] = 1;
        int sign = -1;
        for (int i = 1; i < res.length; i++) {
            denom *= (2*i) * (2*i+1);
            res[i] = sign * denom;
            // silly as one time optimization, still...
            sign = ~sign + 1;
        }
        return res;
    }

    private static Random r = new Random();
    private static float[] DESCRETE_RADS = generateDescreteRads();
    private static float DELTA = (float)0.00000001;
    private static int DESCRETE_MAP_POW = (int)(Math.log(DELTA) / Math.log(0.1) + 1);
    private static float[] generateDescreteRads() {
        // -2Pi, -2Pi+Pi/12, ..., 0, Pi/12, 2PI/12=Pi/6, 3Pi/12=Pi/4, 4Pi/12, 5Pi/12, 6Pi/12=Pi/2, ..., +2Pi
        // -360Deg, -345Deg, ..., 0, 15Deg, 30Deg, 45Deg, 60Deg, 75Deg, 90Deg, ..., 345Deg, 360Deg 
        float[] res = new float[24*4];
        float delta = (float)(Math.PI/12);
        for (int i = 0; i < res.length/2; i++) {
            res[2*i] = i*delta;
            res[2*i+1] = -i*delta;
        }
        return res;
    }

    private static HashMap<Integer, Float> SINX_MAP = generateSinxMap();
    private static HashMap<Integer, Float>generateSinxMap() {
        HashMap<Integer, Float> res = new HashMap<>();
        for (int i = 0; i < DESCRETE_RADS.length; i++) {
            res.put(
                (int)(DESCRETE_RADS[i] * Math.pow(10, DESCRETE_MAP_POW)), 
                (float)Math.sin(DESCRETE_RADS[i])
            );
        }
        return res;
    }

    private static float[] randomX(int N) {
        float[] x = new float[N];
        for (int i = 0; i < N; i++) {
            if (r.nextDouble() < SHARE_OF_DESCRETE) {
                x[i] = DESCRETE_RADS[r.nextInt(DESCRETE_RADS.length)];
            } else {
                x[i] = MIN_X + r.nextFloat() * (MAX_X - MIN_X);
            }
        }
        return x;
    }

    private static void experimet() {
        int N = 1_000;
        float[] x = randomX(N);
        int SAMPLE_SIZE = 10_000;

        int[] termsSample = new int[]{1, 2, 5, 10, 15};

        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);

        for (int t = 0; t < termsSample.length; t++) {
            int terms = termsSample[t];

            long accTimeSlow = 0;
            long accTimeImpr1 = 0;
            long accTimeGolden = 0;


            int i = 0;
            while (i < SAMPLE_SIZE) {

                float[] sinGolden = new float[N]; 
                {
                    long startTime = System.nanoTime();
                    sinGolden(N, terms, x, sinGolden);
                    long stopTime = System.nanoTime();
                    accTimeGolden += stopTime - startTime;
                }

                float[] sinSlowResult = new float[N]; 
                {
                    long startTime = System.nanoTime();
                    sinx(N, terms, x, sinSlowResult);
                    long stopTime = System.nanoTime();
                    accTimeSlow += stopTime - startTime;
                }

                float[] sinImprResult = new float[N]; 
                {
                    long startTime = System.nanoTime();
                    sinxImpr1(N, terms, x, sinImprResult);
                    long stopTime = System.nanoTime();
                    accTimeImpr1 += stopTime - startTime;
                }

                
                for (int j = 0; j < N; j++) {

                    if (Math.abs(sinSlowResult[j]-sinImprResult[j]) > DELTA) {
                        System.out.println(
                            String.format("error: results of sinx functions are not matching x(%s): baseline sinx(%s); candidate sinx(%s)",
                                x[j], sinSlowResult[j], sinImprResult[j]));
                    }

                    if (Math.abs(sinSlowResult[j]-sinGolden[j]) > 0.1) {
                        //System.out.println(
                        //    String.format("error: results of sinx functions are not matching x(%s): baseline sinx(%s); golden sinx(%s)",
                        //        x[j], sinSlowResult[j], sinGolden[j]));
                    }
                }
                

                i++;
            }

            double avgTimeSlow = accTimeSlow * 1.0 / SAMPLE_SIZE;
            double avgTimeImpr1 = accTimeImpr1 * 1.0 / SAMPLE_SIZE;


            System.out.println("Terms: " + terms 
                + "; avg time slow: \t" + df.format(avgTimeSlow) + " nanos" 
            );

            System.out.println("Terms: " + terms 
                + "; avg time impr1: \t" + df.format(avgTimeImpr1) + " nanos" 
            );
        }

    }

    private static void testSinTranslate() {
        float[] x = randomX(1_000);
        for (int i = 0; i < x.length; i++) {
            float x_i = x[i];
            double sinTranslateX = sinTranslate(x_i);
            if (sinTranslateX > Math.PI || sinTranslateX < -Math.PI) {
                System.out.println(String.format("testSinTranslate failed: x(%s), sinTranslateX(%s)", x_i, sinTranslateX));
            }

            double valCandiadte = Math.sin(sinTranslateX);
            double valBaseline = Math.sin(x_i);
            boolean testSinTranslateTestPassed = Math.abs(valCandiadte - valBaseline) < 0.00001;
            if (!testSinTranslateTestPassed) {
                System.out.println(String.format("testSinTranslate failed: x baseline(%s); x candidate (%s)", x_i, sinTranslateX));
            }
        } 
    }

}