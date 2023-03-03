import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AutoLoan {

    private double P;
    private double MP;
    private int term;
    private double output;

    public static void main(String[] args) throws IOException {
        /* 
        testAutoLoan_1();
        testAutoLoan_2();
        testAutoLoan_3();
        */
        AutoLoan autoLoan = new AutoLoan();
        autoLoan.readInput();
        autoLoan.output = AutoLoan.rateForMonthlyPmntTermNPrice(autoLoan.P, autoLoan.MP, autoLoan.term);
        autoLoan.writeOutput();
    }

    private static double DELTA = 0.000000001;

    private static double rateForMonthlyPmntTermNPrice(double P, double MP, int term) {
        // badLRate can be [(MP*term/P)^(1/term) - 1] but skip that for improving performance
        double badLRate = 0;  
        double goodRRate = MP*term/P - 1;
        
        while (goodRRate - badLRate > DELTA/100/12) {
            double mRate = badLRate + (goodRRate - badLRate)/2.0;
            double rPart = 0;
            double currRIncr = 1;
            double rMult = 1.0/(1.0+mRate);
            for (int i = 0; i < term; i++) {
                currRIncr *= rMult;
                rPart += currRIncr;
            }
            double res = MP * rPart - P;
            if (res > 0) {
                badLRate = mRate;
            } else {
                goodRRate = mRate;
            }
        }
        return goodRRate*12.0*100.0;
    }

    private void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            P = Double.parseDouble(firstLineStr[0]);
            MP = Double.parseDouble(firstLineStr[1]);
            term = Integer.parseInt(firstLineStr[2]);
        }
    }

    private void writeOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bufferedWriter.write(String.valueOf(output));
            bufferedWriter.newLine();
        }
    }

    private static void testAutoLoan_1() {
        double output = AutoLoan.rateForMonthlyPmntTermNPrice(6800, 100, 68);
        boolean passed = Math.abs(output - 0.000000000000133) < DELTA;
        System.out.println("testAutoLoan_1: " + (passed ? "passed" : "failed"));
    }

    private static void testAutoLoan_2() {
        double output = AutoLoan.rateForMonthlyPmntTermNPrice(2000, 510, 4);
        boolean passed = Math.abs(output - 9.562054624583681) < DELTA;
        System.out.println("testAutoLoan_2: " + (passed ? "passed" : "failed"));
    }

    private static void testAutoLoan_3() {
        double output = AutoLoan.rateForMonthlyPmntTermNPrice(15000.00, 364.00, 48);
        boolean passed = Math.abs(output - 7.687856394581649) < DELTA;
        System.out.println("testAutoLoan_3: " + (passed ? "passed" : "failed"));
    }
}
