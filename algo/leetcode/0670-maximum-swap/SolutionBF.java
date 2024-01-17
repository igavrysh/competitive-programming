class SolutionBF {
    public int maximumSwap(int num) {
        if (num <= 1) {
            return num;
        }
        int n = (int)(Math.log(num) / Math.log(10));
        while (Math.pow(10, n) < num) {
            n++;
        }

        int[] t = new int[n];
        int[] max = new int[n];

        for (int i = 0; i < n; i++) {
            t[n-1-i] = num%10;
            max[n-1-i] = t[n-1-i];
            num = num / 10;
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (t[j] > t[i]) {
                    int tmp = t[i];
                    t[i] = t[j];
                    t[j] = tmp;

                    if (greater(t, max)) {
                        for (int s = 0; s < n; s++) {
                            max[s] = t[s];
                        }
                    }

                    t[j] = t[i];
                    t[i] = tmp;
                }
            }
        }

        int output = 0;

        for (int i = 0; i < n; i++) {
            output = output * 10 + max[i];
        }
        return output;
    }

    public boolean greater(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] > a2[i]) {
                return true;
            } else if (a1[i] < a2[i]) {
                return false;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        test4();
        test1();
        test2();
    }

    public static void test1() {
        int input = 2736;
        int expOutput = 7236;
        SolutionBF sol = new SolutionBF();
        int output = sol.maximumSwap(input);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int input = 9973;
        int expOutput = 9973;
        SolutionBF sol = new SolutionBF();
        int output = sol.maximumSwap(input);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int input = 1000;
        int expOutput = 1000;
        SolutionBF sol = new SolutionBF();
        int output = sol.maximumSwap(input);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}