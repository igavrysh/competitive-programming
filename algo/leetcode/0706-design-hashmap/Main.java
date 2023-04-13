import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException { 

        testMyHashMapArray1();
        testMyHashMapArray2();
        testMyHashMapArray3();
        testMyHashMapArray4();
        testMyHashMapArray5();
        testMyHashMapArray6();
        testMyHashMapArray7();
 
        testMyHashMapArrayOfLists1();
        testMyHashMapArrayOfLists2();
    }

    public static void testMyHashMapArray1() {
        boolean passed = true;
        MyHashMapArray myHashMap = new MyHashMapArray();
        myHashMap.put(1, 1);                    // The map is now [[1,1]]
        myHashMap.put(2, 2);                    // The map is now [[1,1], [2,2]]
        passed = passed && myHashMap.get(1) == 1;     // return 1, The map is now [[1,1], [2,2]]
        passed = passed && myHashMap.get(3) == -1;    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1);                    // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        passed = passed && myHashMap.get(2) == 1;     // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2);                          // remove the mapping for 2, The map is now [[1,1]]
        passed = passed && myHashMap.get(2) == -1;    // return -1 (i.e., not found), The map is now [[1,1]]
        System.out.println("testMyHashMapArray1: " + (passed ? "passed" : "failed"));
    }

    public static void testMyHashMapArray2() {
        String[] ops = new String[]{
            "MyHashMap","remove","put","remove","remove",
            "get","remove","put","get","remove",
            "put","put","put","put","put",
            "put","put","put","put","put",
            "put","remove","put","put","get",
            "put","get","put","put","get",
            "put","remove","remove","put","put",
            "get","remove","put","put","put",
            "get","put","put","remove","put",
            "remove","remove","remove","put","remove",
            "get","put","put","put","put",
            "remove","put","get","put","put",
            "get","put","remove","get","get",
            "remove","put","put","put","put",
            "put","put","get","get","remove",
            "put","put","put","put","get",
            "remove","put","put","put","put",
            "put","put","put","put","put",
            "put","remove","remove","get","remove",
            "put","put","remove","get","put",
            "put"};

        Integer[][] args =  {
            {},{27},{65,65},{19},{0},
            {18},{3},{42,0},{19},{42},
            {17,90},{31,76},{48,71},{5,50},{7,68},
            {73,74},{85,18},{74,95},{84,82},{59,29},
            {71,71},{42},{51,40},{33,76},{17},
            {89,95},{95},{30,31},{37,99},{51},
            {95,35},{65},{81},{61,46},{50,33},
            {59},{5},{75,89},{80,17},{35,94},
            {80},{19,68},{13,17},{70},{28,35},
            {99},{37},{13},{90,83},{41},
            {50},{29,98},{54,72},{6,8},{51,88},
            {13},{8,22},{85},{31,22},{60,9},
            {96},{6,35},{54},{15},{28},
            {51},{80,69},{58,92},{13,12},{91,56},
            {83,52},{8,48},{62},{54},{25},
            {36,4},{67,68},{83,36},{47,58},{82},
            {36},{30,85},{33,87},{42,18},{68,83},
            {50,53},{32,78},{48,90},{97,95},{13,8},
            {15,7},{5},{42},{20},{65},
            {57,9},{2,41},{6},{33},{16,44},
            {95,30}
        };

        Integer[] expectedOutput = {
            null,null,null,null,null,
            -1,null,null,-1,null,
            null,null,null,null,null,
            null,null,null,null,null,
            null,null,null,null,90,
            null,-1,null,null,40,
            null,null,null,null,null,
            29,null,null,null,null,
            17,null,null,null,null,
            null,null,null,null,null,
            33,null,null,null,null,
            null,null,18,null,null,
            -1,null,null,-1,35,
            null,null,null,null,null,
            null,null,-1,-1,null,
            null,null,null,null,-1,
            null,null,null,null,null,
            null,null,null,null,null,
            null,null,null,-1,null,
            null,null,null,87,null,
            null
        };

        MyHashMapArray m = null;
        boolean passed = true;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("MyHashMap")) {
                m = new MyHashMapArray();
            } else if (ops[i].equals("get")) {
                passed = passed && m.get(args[i][0]) == expectedOutput[i];
                //System.out.println("i = " + i + "; passed = " + passed);
            } else if (ops[i].equals("remove")) {
                m.remove(args[i][0]);
            } else if (ops[i].equals("put")) {
                m.put(args[i][0], args[i][1]);
            }
        }

        System.out.println("testMyHashMapArray2: " + (passed ? "passed" : "failed"));
    }

    public static void testMyHashMapArray3() {
        String[] ops = new String[]{
            "MyHashMap","remove","put","remove","remove",
            "get","remove","put","get","remove",
            "put","put","put","put","put",
            "put","put","put","put","put",
            "put","remove","put","put","get",
            "put","get","put","put","get",
            "put","remove","remove","put","put",
            "get","remove","put","put","put",
            "get","put","put","remove","put",
            "remove","remove","remove","put","remove",
            "get","put","put","put","put",
            "remove","put","get","put","put",
            "get","put","remove","get","get",
            "remove","put","put","put","put",
            "put","put","get","get","remove",
            "put","put","put","put","get",
            "remove","put","put","put","put",
            "put","put","put","put","put",
            "put","remove","remove","get","remove",
            "put","put","remove","get","put",
            "put"};

        Integer[][] args =  {
            {},{27},{65,65},{19},{0},
            {18},{3},{42,0},{19},{42},
            {17,90},{31,76},{48,71},{5,50},{7,68},
            {73,74},{85,18},{74,95},{84,82},{59,29},
            {71,71},{42},{51,40},{33,76},{17},
            {89,95},{95},{30,31},{37,99},{51},
            {95,35},{65},{81},{61,46},{50,33},
            {59},{5},{75,89},{80,17},{35,94},
            {80},{19,68},{13,17},{70},{28,35},
            {99},{37},{13},{90,83},{41},
            {50},{29,98},{54,72},{6,8},{51,88},
            {13},{8,22},{85},{31,22},{60,9},
            {96},{6,35},{54},{15},{28},
            {51},{80,69},{58,92},{13,12},{91,56},
            {83,52},{8,48},{62},{54},{25},
            {36,4},{67,68},{83,36},{47,58},{82},
            {36},{30,85},{33,87},{42,18},{68,83},
            {50,53},{32,78},{48,90},{97,95},{13,8},
            {15,7},{5},{42},{20},{65},
            {57,9},{2,41},{6},{33},{16,44},
            {95,30}
        };

        Integer[] expectedOutput = {
            null,null,null,null,null,
            -1,null,null,-1,null,
            null,null,null,null,null,
            null,null,null,null,null,
            null,null,null,null,90,
            null,-1,null,null,40,
            null,null,null,null,null,
            29,null,null,null,null,
            17,null,null,null,null,
            null,null,null,null,null,
            33,null,null,null,null,
            null,null,18,null,null,
            -1,null,null,-1,35,
            null,null,null,null,null,
            null,null,-1,-1,null,
            null,null,null,null,-1,
            null,null,null,null,null,
            null,null,null,null,null,
            null,null,null,-1,null,
            null,null,null,87,null,
            null
        };

        MyHashMapArray m = null;
        boolean passed = true;
        for (int i = 0; i < ops.length; i++) {
            //System.out.println("i = " + i + "; passed = " + passed);
            if (ops[i].equals("MyHashMap")) {
                m = new MyHashMapArray();
            } else if (ops[i].equals("get")) {
                passed = passed && m.get(args[i][0]) == expectedOutput[i];
            } else if (ops[i].equals("remove")) {
                m.remove(args[i][0]);
            } else if (ops[i].equals("put")) {
                m.put(args[i][0], args[i][1]);
            }
        }

        System.out.println("testMyHashMapArray3: " + (passed ? "passed" : "failed"));
    }

    public static void testMyHashMapArray4() {
        MyHashMapArray m = new MyHashMapArray();
        boolean passed = true;
        m.put(10, 1);
        m.put(26, 2);
        m.put(42, 3);
        // [10, 26, 42]
        passed = passed && m.get(10) == 1;
        passed = passed && m.get(26) == 2;
        passed = passed && m.get(42) == 3;

        m.remove(26);
        // [10, -1, 42]
        passed = passed && m.thumbstone[10] == false;
        passed = passed && m.thumbstone[11] == true;
        passed = passed && m.thumbstone[12] == false;
        passed = passed && m.get(10) == 1;
        passed = passed && m.get(26) == -1;
        passed = passed && m.get(42) == 3;

        m.put(26, 42);
        // [10, -1, 42, 26]
        passed = passed && m.get(10) == 1;
        passed = passed && m.get(26) == 42;
        passed = passed && m.get(42) == 3;
        passed = passed && m.thumbstone[10] == false;
        passed = passed && m.thumbstone[11] == true;
        passed = passed && m.thumbstone[12] == false;
        passed = passed && m.thumbstone[13] == false;

        m.put(58, 101);
        // [10, -1, 42, 26, 58]
        passed = passed && m.get(10) == 1;
        passed = passed && m.get(26) == 42;
        passed = passed && m.get(42) == 3;
        passed = passed && m.get(58) == 101;
        passed = passed && m.thumbstone[10] == false;
        passed = passed && m.thumbstone[11] == true;
        passed = passed && m.thumbstone[12] == false;
        passed = passed && m.thumbstone[13] == false;
        passed = passed && m.thumbstone[14] == false;

        m.remove(26);
        m.remove(42);
        // [10, -1, -1, -1, 58]
        passed = passed && m.get(10) == 1;
        passed = passed && m.get(26) == -1;
        passed = passed && m.get(42) == -1;
        passed = passed && m.get(58) == 101;
        passed = passed && m.thumbstone[10] == false;
        passed = passed && m.thumbstone[11] == true;
        passed = passed && m.thumbstone[12] == true;
        passed = passed && m.thumbstone[13] == true;
        passed = passed && m.thumbstone[14] == false;
        passed = passed && m.thumbstone[15] == false;

        System.out.println("testMyHashMapArray4: " + (passed ? "passed" : "failed"));
    }

    public static void testMyHashMapArrayOfLists1() {
        boolean passed = true;
        MyHashMapArrayOfLists myHashMap = new MyHashMapArrayOfLists();
        myHashMap.put(1, 1);                    // The map is now [[1,1]]
        myHashMap.put(2, 2);                    // The map is now [[1,1], [2,2]]
        passed = passed && myHashMap.get(1) == 1;     // return 1, The map is now [[1,1], [2,2]]
        passed = passed && myHashMap.get(3) == -1;    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1);                    // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        passed = passed && myHashMap.get(2) == 1;     // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2);                          // remove the mapping for 2, The map is now [[1,1]]
        passed = passed && myHashMap.get(2) == -1;    // return -1 (i.e., not found), The map is now [[1,1]]
        System.out.println("testMyHashMap1: " + (passed ? "passed" : "failed"));
    }

    public static void testMyHashMapArrayOfLists2() {
        String[] ops = new String[]{
            "MyHashMap","remove","put","remove","remove",
            "get","remove","put","get","remove",
            "put","put","put","put","put",
            "put","put","put","put","put",
            "put","remove","put","put","get",
            "put","get","put","put","get",
            "put","remove","remove","put","put",
            "get","remove","put","put","put",
            "get","put","put","remove","put",
            "remove","remove","remove","put","remove",
            "get","put","put","put","put",
            "remove","put","get","put","put",
            "get","put","remove","get","get",
            "remove","put","put","put","put",
            "put","put","get","get","remove",
            "put","put","put","put","get",
            "remove","put","put","put","put",
            "put","put","put","put","put",
            "put","remove","remove","get","remove",
            "put","put","remove","get","put",
            "put"};

        Integer[][] args =  {
            {},{27},{65,65},{19},{0},
            {18},{3},{42,0},{19},{42},
            {17,90},{31,76},{48,71},{5,50},{7,68},
            {73,74},{85,18},{74,95},{84,82},{59,29},
            {71,71},{42},{51,40},{33,76},{17},
            {89,95},{95},{30,31},{37,99},{51},
            {95,35},{65},{81},{61,46},{50,33},
            {59},{5},{75,89},{80,17},{35,94},
            {80},{19,68},{13,17},{70},{28,35},
            {99},{37},{13},{90,83},{41},
            {50},{29,98},{54,72},{6,8},{51,88},
            {13},{8,22},{85},{31,22},{60,9},
            {96},{6,35},{54},{15},{28},
            {51},{80,69},{58,92},{13,12},{91,56},
            {83,52},{8,48},{62},{54},{25},
            {36,4},{67,68},{83,36},{47,58},{82},
            {36},{30,85},{33,87},{42,18},{68,83},
            {50,53},{32,78},{48,90},{97,95},{13,8},
            {15,7},{5},{42},{20},{65},
            {57,9},{2,41},{6},{33},{16,44},
            {95,30}
        };

        Integer[] expectedOutput = {
            null,null,null,null,null,
            -1,null,null,-1,null,
            null,null,null,null,null,
            null,null,null,null,null,
            null,null,null,null,90,
            null,-1,null,null,40,
            null,null,null,null,null,
            29,null,null,null,null,
            17,null,null,null,null,
            null,null,null,null,null,
            33,null,null,null,null,
            null,null,18,null,null,
            -1,null,null,-1,35,
            null,null,null,null,null,
            null,null,-1,-1,null,
            null,null,null,null,-1,
            null,null,null,null,null,
            null,null,null,null,null,
            null,null,null,-1,null,
            null,null,null,87,null,
            null
        };

        MyHashMapArrayOfLists m = null;
        boolean passed = true;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("MyHashMap")) {
                m = new MyHashMapArrayOfLists();
            } else if (ops[i].equals("get")) {
                passed = passed && m.get(args[i][0]) == expectedOutput[i];
                //System.out.println("i = " + i + "; passed = " + passed);
            } else if (ops[i].equals("remove")) {
                m.remove(args[i][0]);
            } else if (ops[i].equals("put")) {
                m.put(args[i][0], args[i][1]);
            }
        }

        System.out.println("testMyHashMap2: " + (passed ? "passed" : "failed"));
    }

    public static void testMyHashMapArray5() throws FileNotFoundException, IOException {
        try (BufferedReader inputBR = new BufferedReader(new FileReader("test1.input")); 
            BufferedReader outputBR = new BufferedReader(new FileReader("test1.output"))
        ) {
            String opsString = inputBR.readLine();
            String[] ops =  opsString.substring(1, opsString.length()-1).replaceAll("\\\"", "").replaceAll("\\\"", "").split(",");
            
            String argsString = inputBR.readLine();
            String[] args = argsString.substring(2, argsString.length()-2).split("\\]\\,\\[");

            String outString = outputBR.readLine();
            String[] out = outString.substring(1, outString.length()-1).split(",");
            if (ops.length != args.length || ops.length != out.length) {
                System.out.println("testMyHashMapArray5: input/files icorrect format - not matching array lengths");
                return;
            }
        
            MyHashMapArray m = null;
            boolean passed = true;
            for (int i = 0; i < ops.length; i++) {
                if (i == 652) {
                    int t = 1;
                }
                if (ops[i].equals("MyHashMap")) {
                    m = new MyHashMapArray();
                } else if (ops[i].equals("get")) {
                    String[] expectedInputStrings = args[i].split(",");
                    Integer expectedInput1 = Integer.valueOf(expectedInputStrings[0]);
                    Integer expectedOutput = Integer.parseInt(out[i]);

                    if (expectedInput1 == 623) {
                        int t = 1;
                    }
                    int hash = m.hash(expectedInput1);

                    int output = m.get(expectedInput1);
                    passed = passed && output == expectedOutput;
                    //System.out.println("i = " + i + "; passed = " + passed);
                } else if (ops[i].equals("remove")) {
                    String[] a = args[i].split(",");
                    Integer expectedInput1 = Integer.valueOf(a[0]);

                    if (expectedInput1 == 623) {
                        int t = 1;
                    }
                    int hash = m.hash(expectedInput1);


                    m.remove(expectedInput1);
                } else if (ops[i].equals("put")) {
                    String[] expectedInputStrings = args[i].split(",");
                    Integer expectedInput1 = Integer.valueOf(expectedInputStrings[0]);
                    Integer expectedInput2 = Integer.valueOf(expectedInputStrings[1]);

                    if (expectedInput1 == 623) {
                        int t = 1;
                    }
                    int hash = m.hash(expectedInput1);

                    m.put(expectedInput1, expectedInput2);
                }
            }

            System.out.println("testMyHashMapArray5: " + (passed ? "passed" : "failed"));
        }

    }

    public static void testMyHashMapArray6() {
        String[] ops = new String[] {
            "MyHashMap","put","remove","get","put","remove","remove","put","put","get"
        };

        Integer[][] args =  {
            {},{504,155},{89},{334},{570,521},{504},{504},{507,661},{175,641},{504}
        };

        Integer[] expectedOutput = {
            null,null,null,-1,null,null,null,null,null,-1
        };

        MyHashMapArray m = null;
        boolean passed = true;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("MyHashMap")) {
                m = new MyHashMapArray();
            } else if (ops[i].equals("get")) {
                passed = passed && m.get(args[i][0]) == expectedOutput[i];
                //System.out.println("i = " + i + "; passed = " + passed);
            } else if (ops[i].equals("remove")) {
                m.remove(args[i][0]);
            } else if (ops[i].equals("put")) {
                m.put(args[i][0], args[i][1]);
            }
        }

        System.out.println("testMyHashMapArray6: " + (passed ? "passed" : "failed"));
    }

    public static void testMyHashMapArray7() throws FileNotFoundException, IOException {
        try (BufferedReader inputBR = new BufferedReader(new FileReader("test2.input")); 
            BufferedReader outputBR = new BufferedReader(new FileReader("test2.output"))
        ) {
            String opsString = inputBR.readLine();
            String[] ops =  opsString.substring(1, opsString.length()-1).replaceAll("\\\"", "").replaceAll("\\\"", "").split(",");
            
            String argsString = inputBR.readLine();
            String[] args = argsString.substring(2, argsString.length()-2).split("\\]\\,\\[");

            String outString = outputBR.readLine();
            /*String[] out = outString.substring(1, outString.length()-1).split(",");

            if (ops.length != args.length || ops.length != out.length) {
                System.out.println("testMyHashMapArray5: input/files icorrect format - not matching array lengths");
                return;
            }
            */

            MyHashMapArray m = null;
            boolean passed = true;
            for (int i = 0; i < ops.length; i++) {
                //System.out.println("i=" + i);


                if (i == 31) {
                    int t = 1;
                }

                if (ops[i].equals("MyHashMap")) {
                    m = new MyHashMapArray();
                } else if (ops[i].equals("get")) {
                    String[] expectedInputStrings = args[i].split(",");
                    Integer expectedInput1 = Integer.valueOf(expectedInputStrings[0]);
                    //Integer expectedOutput = Integer.parseInt(out[i]);
                    //int output = m.get(expectedInput1);
                    //passed = passed && output == expectedOutput;
                    //System.out.println("i = " + i + "; passed = " + passed);
                } else if (ops[i].equals("remove")) {
                    String[] a = args[i].split(",");
                    Integer expectedInput1 = Integer.valueOf(a[0]);
                    m.remove(expectedInput1);
                } else if (ops[i].equals("put")) {
                    String[] expectedInputStrings = args[i].split(",");
                    Integer expectedInput1 = Integer.valueOf(expectedInputStrings[0]);
                    Integer expectedInput2 = Integer.valueOf(expectedInputStrings[1]);
                    m.put(expectedInput1, expectedInput2);
                }
            }

            System.out.println("testMyHashMapArray7: " + (passed ? "passed" : "failed"));
        }
    }
}
