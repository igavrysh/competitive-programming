package com.company;

import java.text.DecimalFormat;
import java.util.Random;

public class Main {

    // reduce bounds so that Taylor approximation works correctly
    private static float MIN_X = (float)(-1* Math.PI);
    private static float MAX_X = (float)(1* Math.PI); 

    private static double SHARE_OF_WELL_KNOWN_VALUES = 0.50;
    // although Taylor sequence remainder has upper bound, its not working 
    // for my case, and will use MAX_DELTA here for cases with terms >= 5
    private static double MAX_DELTA = 0.001;

    private static int[] termsSample = new int[]{3, 4, 5, 10, 15};

    private static Random r = new Random();


    public static void main(String[] args) {
        experimet();

        //testSinTranslate();
        //testSinX();
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
            float value = x[i];
            float numer = x[i] * x[i] * x[i];
            // change from `int denom = 6;` as otherwise int overflows with high term values
            float denom = 6; // 3!
            int sign = -1;
            for (int j = 1; j <= terms; j++) {
                value += sign * numer / denom;
                numer *= x[i] * x[i];
                denom *= (2*j+2) * (2*j+3);
                sign *= -1;
            }
            result[i] = (float)value;
        }
    }

    private static void sinxWithTranslation(int N, int terms, float[] x, float[] result) {
        for (int i = 0; i < N; i++) {
            float x_i = (float)sinTranslate(x[i]);
            float value = x_i;
            float numer = x_i * x_i * x_i;
            float denom = 6; // 3!
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

    private static double MathPIDiv12Inv = 12/Math.PI;
    private static double MathPIDiv1 = Math.PI/12;

    private static void sinxImpr1(int N, int terms, float[] x, float[] result) {
        for (int i = 0; i < N; i++) {
            //float x_i = (float)sinTranslate(x[i]);
            float x_i = x[i];

            
            int wellKnownRate = (int)(x_i * MathPIDiv12Inv) ;
            if (Math.abs(x_i -  wellKnownRate * MathPIDiv1) < MAX_DELTA) {
                int idx = wellKnownRate + 12; 
                result[i] = WELL_KNOWN_RAD_SINX_VALS[idx];
                continue;
            }
            

            float x_i_sq = x_i * x_i;
            float x_i_trip = x_i_sq * x_i;
            float value = x_i;
            float numer = x_i_trip;
            for (int j = 1; j <= terms; j++) {
                value += numer * MULT[j];
                numer *= x_i_sq;
            }
            result[i] = value;
        }
    }

    private static void sinxGolden(int N, int terms, float[] x, float[] result) {
        for (int i = 0; i < N; i++) {
            result[i] = (float)Math.sin(x[i]);
        }
    }

    private static float[] MULT = generateMult(100);
    private static float[] generateMult(int N) {
        float[] res = new float[N];
        float denom = 1;
        res[0] = 1;
        int sign = -1;
        for (int i = 1; i < res.length; i++) {
            denom *= (2*i) * (2*i+1);
            res[i] = (float)(sign * 1.0 / denom);
            // silly as one time optimization, still...
            sign = ~sign + 1;
        }
        return res;
    }

    private static float[] WELL_KNOWN_RAD_X_VALS = generateWellKnownRadXVals();
    private static float[] generateWellKnownRadXVals() {
        float[] res = new float[25];
        float delta = (float)(Math.PI / 12);
        for (int i=0; i<res.length; i++) {
            res[i] = (float)(-Math.PI + i*delta);
        }
        return res;
    }

    private static float[] WELL_KNOWN_RAD_SINX_VALS = generateWellKnownSinxVals();
    private static float[] generateWellKnownSinxVals() {
        float[] res = new float[WELL_KNOWN_RAD_X_VALS.length];
        for (int i=0; i<res.length; i++) {
            res[i] = (float)Math.sin(WELL_KNOWN_RAD_X_VALS[i]);
        }
        return res;
    }

    private static float[] randomX(int N) {
        float[] x = new float[N];
        for (int i = 0; i < N; i++) {
            if (r.nextDouble() < SHARE_OF_WELL_KNOWN_VALUES) {
                x[i] = WELL_KNOWN_RAD_X_VALS[r.nextInt(WELL_KNOWN_RAD_X_VALS.length)];
            } else {
                x[i] = MIN_X + r.nextFloat() * (MAX_X - MIN_X);
            }
        }
        return x;
    }

    private static void experimet() {
        int N = 1_000;
        float[] x = randomX(N);
        int SAMPLE_SIZE = 1_000;


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
                    sinxGolden(N, terms, x, sinGolden);
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

                float[] sinImpr1Result = new float[N]; 
                {
                    long startTime = System.nanoTime();
                    sinxImpr1(N, terms, x, sinImpr1Result);
                    long stopTime = System.nanoTime();
                    accTimeImpr1 += stopTime - startTime;
                }

                for (int j = 0; j < N; j++) {
                    // O(|x|^k/k!), where k is next odd number after last used Taylor sequence element
                    // double maxDeltaRemainder = Math.pow(Math.abs(x[j]), 2*termsSample[t]-1) / factorial(2*termsSample[t]-1);
                    // will loose remainder upper bound assesment with MAX_DELTA due to possible errors in calculation
                    double maxDeltaRemainder = termsSample[t] >= 5 ? MAX_DELTA : Math.pow(Math.abs(x[j]), 2*termsSample[t]-3) / factorial(2*termsSample[t]-3);
                    
                    /* 
                    if (Math.abs(sinSlowResult[j]-sinImpr1Result[j]) >= maxDeltaRemainder) {
                        float xJ = x[j];
                        double sinSlowResultJ = sinSlowResult[j];
                        double sinImpr1ResultJ = sinImpr1Result[j];
                        double delta = Math.abs(sinSlowResultJ-sinImpr1ResultJ);


                        System.out.println(
                            String.format("err no match b/w slow & impr sin func:\tx:%s\tbaseline sinx(%s)\tcandidate sinx(%s)\tterms:%s\tdiff:%s\tmaxdelta:%s",
                                xJ, sinSlowResultJ, sinImpr1ResultJ, termsSample[t], Math.abs(sinSlowResult[j]-sinImpr1Result[j]), maxDeltaRemainder));
                    }
                    */
                
                    if (Math.abs(sinGolden[j]-sinImpr1Result[j]) >= maxDeltaRemainder) {
                        float xJ = x[j];
                        double sinGoldenResultJ = sinGolden[j];
                        double sinImpr1ResultJ = sinImpr1Result[j];
                        double delta = Math.abs(sinGoldenResultJ-sinImpr1ResultJ);
                        System.out.println(
                            String.format("err no match b/w golden & impr sin func:\tx:%s\tbaseline sinx(%s)\tcandidate sinx(%s)\tterms:%s\tdiff:%s\tmaxdelta:%s",
                                xJ, sinGoldenResultJ, sinImpr1ResultJ, termsSample[t], delta, maxDeltaRemainder));
                    }
                }
                i++;
            }

            double avgTimeSlow = accTimeSlow * 1.0 / SAMPLE_SIZE;
            double avgTimeImpr1 = accTimeImpr1 * 1.0 / SAMPLE_SIZE;
            double avgTimeGolden = accTimeGolden * 1.0 / SAMPLE_SIZE;

            System.out.println("Terms: " + terms 
                + "; avg time slow: \t" + df.format(avgTimeSlow) + " nanos" 
            );

            System.out.println("Terms: " + terms 
                + "; avg time impr1: \t" + df.format(avgTimeImpr1) + " nanos" 
            );

            System.out.println("Terms: " + terms 
                + "; avg time golden: \t" + df.format(avgTimeGolden) + " nanos" 
            );
        }
    }

    private static void testSinX() {
        float[] x = new float[] {(float)-1.595149, (float)(-1 * Math.PI), (float)(-1 * Math.PI + 0.00001)  };
        float[] resultSinx = new float[x.length];
        float[] resultImpr1Sinx = new float[x.length];

        sinx(1, 15, x, resultSinx);
        sinxImpr1(1, 15, x, resultImpr1Sinx);

        int t = 1;
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

    private static float factorial(int n) {
        float fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}