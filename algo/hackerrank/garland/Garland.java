import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Garland {
    public static void main(String[] args) throws IOException {
        //testSolution_1();
        //testSolution_2();
        Garland garland = new Garland();
        garland.readInput();
        garland.B = garland.minB(garland.N, garland.A);
        garland.writeOutput();
    }

    private int N;
    private double A;
    private double B;

    private double[][] matA;
    private double[] vecB;

    private double minB(int N, double A) {        
        generateMatA(N);
        generateVectB(N, A, 0);
        partialApplyMatAAndVectB(N, matA, vecB);

        double good = A * Math.pow(2, N/2);
        double bad = 0;
        double prevM = A;
        double m = 0;

        double[] H = null;
        while (good-bad >= DELTA && Math.abs(m-prevM)>DELTA) {
            prevM = m;
            m = bad + (good - bad) / 2;

            H = getH(A, m, N);
 
            boolean badSet = false;
            for (int i=0; i<H.length; i++) {
                if (H[i] < 0) {
                    bad = m;
                    i = H.length;
                    badSet = true;
                }
            }
            if (!badSet) {
                good = m;
            }
        }
        return good;      
    }

    /*  matA                       vector H     vect b                
     *  1  0  0  0 ... 0  0  0  0   H1           = A
     *  1 -2  1  1 ... 0  0  0  0   H2           = 2
     *  0  1 -2  1 ... 0  0  0  0   H3           = 2
     *      ...    ...     ...      ...          ...
     *  0  0  0  0 ... 1 -2  1  0   Hn-2         = 2
     *  0  0  0  0 ... 0  1 -2  1   Hn-1         = 2
     *  0  0  0  0 ... 0  0  0  1   Hn           = B
     */
    private void generateMatA(int N) {
        matA = new double[N][N];
        for (int i = 0; i < matA.length; i++) {
            if (i==0 || i==N-1) { matA[i][i] = 1; }
            else {
                if (i>=1 && i <= N-2) { matA[i][i] = -2; }
                if (i>=1) matA[i][i-1] = 1;  
                if (i<=N-2) matA[i][i+1] = 1;
            }
        }
    }

    private void generateVectB(int N, double A, double B) {
        vecB = new double[N];
        for (int i = 0; i < vecB.length; i++) {
            vecB[i] = 2;
            if (i==0) vecB[0] = A;
            if (i==N-1) vecB[N-1] = B;
        }
    }

    private void partialApplyMatAAndVectB(int N, double[][] matA, double[]vecB) {
        for (int i = 0; i<matA.length-2;i++) {
            double k = -1*matA[i][i]/matA[i+1][i];
            for (int j = 0; j<3; j++) {
                if (i+j < N) {
                    matA[i+1][i+j] = k*matA[i+1][i+j]+matA[i][i+j];
                }
            }
            vecB[i+1] = k*vecB[i+1]+vecB[i];
        }
    }

    private double[] getH(double A, double B, int N) {
        double[] res = new double[N];
        res[0] = A;
        res[N-1] = B;

        for (int i = N-2; i >= 1; i--) {
            res[i] = (vecB[i] - matA[i][i+1]*res[i+1]) / matA[i][i];
        }
        return res;
    }

    private static double DELTA = 0.005;

    private void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            N = Integer.parseInt(firstLineStr[0]);
            A = Double.parseDouble(firstLineStr[1]);
        }
    }

    private void writeOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bufferedWriter.write(String.valueOf(B));
            bufferedWriter.newLine();
        }
    }

    private static void testSolution_1() {
        Garland main = new Garland();
        double output = main.minB(8, 15);
        boolean passed = Math.abs(output-9.75)<0.005;
        System.out.println("Solution test1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolution_2() {
        Garland main = new Garland();
        double output = main.minB(692, 532.81);
        boolean passed = Math.abs(output-446113.344348)<0.005;
        System.out.println("Solution test1: " + (passed ? "passed" : "failed"));
    }
}