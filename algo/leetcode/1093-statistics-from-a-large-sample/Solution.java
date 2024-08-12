class Solution {
    public double[] sampleStats(int[] count) {
        double min = 0;
        int n = count.length;
        for (int i = 0; i < n; i++) {
            if (count[i] != 0) {
                min = i;
                break;
            }
        }
        double max = 0;
        for (int i = n-1; i >= 0; i--) {
            if (count[i] != 0) {
                max = i;
                break;
            }
        }
        double acc = 0;
        double vol = 0;
        int max_fq = 0;
        double mode = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] != 0) {
                acc += (double)(count[i] * (double)i);
                vol += count[i];
                if (count[i] > max_fq) {
                    max_fq = count[i];
                    mode = (double)i;
                }
            }
        }
        double mean = acc*1.0/vol;
        acc = 0;
        double curr_vol = 0;
        double prev_vol = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] != 0) {
                prev_vol = curr_vol;
                curr_vol += count[i];
                if (vol%2 == 1) {
                    if (curr_vol - (vol/2)>= 0 && ((vol/2+1) - prev_vol) > 0) {
                        acc += (double)i;
                        //System.out.println("adding i:"+i);
                        break;
                    }
                }
                if (vol%2 == 0) {
                    if ((curr_vol-vol/2)>=0 && (vol/2 - prev_vol) > 0) {
                        acc += (double)i;

                    }
                    if ((curr_vol-(vol/2+1))>=0 && ((vol/2+1)-prev_vol)>0) {
                        acc += (double)i;
                        break;
                    }
                }
            }
        }
        double median = vol %2==0 ? acc / 2.0 : acc;
        return new double[]{min,max,mean,median,mode};
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] count = {
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        };
        double[] expResult = {
            86.00000,203.00000,126.44444,86.00000,86.00000
        };
        boolean passed = true;
        double delta = 0.00001;
        Solution sol = new Solution();
        double[] result = sol.sampleStats(count);
        for (int i = 0; i < expResult.length; i++) {
            passed &= (Math.abs(result[i]-expResult[i]) < delta);
        }
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[] count = {
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        };
        double[] expResult = {
            86.00000,203.00000,126.44444,86.00000,86.00000
        };
        boolean passed = true;
        double delta = 0.00001;
        Solution sol = new Solution();
        double[] result = sol.sampleStats(count);
        for (int i = 0; i < expResult.length; i++) {
            passed &= (Math.abs(result[i]-expResult[i]) < delta);
        }
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }
}