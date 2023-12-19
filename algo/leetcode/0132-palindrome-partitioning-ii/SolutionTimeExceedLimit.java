class SolutionTimeExceedLimit {
    public int minCut(String s) {
        int N = s.length();
        boolean[][] isP = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            isP[i][i] = true;
        }

        for (int z = 1; z < N; z++) {
            for (int jS = z; jS < N; jS++) {
                int _j = jS;
                int _i = jS-z;

                if (_j-1 > _i+1 && !isP[_i+1][_j-1]) {
                    continue;
                }

                if (s.charAt(_i) == s.charAt(_j)) {
                    isP[_i][_j] = true;
                }
            }
        }
        int[][] mem = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mem[i][j] = -1;
            }
        }
        int[] globalMin = {N-1};
        return minCutLR(0, N-1, isP, mem);
    }

    private int minCutLR(int l, int r, boolean[][] isP, int[][] mem) {
        if (isP[l][r]) {
            return 0;
        }

        if (mem[l][r] != -1) {
            return mem[l][r];
        }
        int minCut = r-l;
        for (int i = l+1; i <= r; i++) {
            minCut = Math.min(minCut, 
                1+minCutLR(l, i-1, isP, mem)+minCutLR(i, r, isP, mem));
            if (minCut == 1) {
                break;
            } 
        }
        mem[l][r] = minCut;
        return minCut;
    }

    public static void main(String[] args) {
        test6();
        test5();
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        String s = "aapam";
        SolutionTimeExceedLimit sol = new SolutionTimeExceedLimit();
        int expectedOutput = 2;
        int output = sol.minCut(s);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s = "aab";
        SolutionTimeExceedLimit sol = new SolutionTimeExceedLimit();
        int expectedOutput = 1;
        int output = sol.minCut(s);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s = "a";
        SolutionTimeExceedLimit sol = new SolutionTimeExceedLimit();
        int expectedOutput = 0;
        int output = sol.minCut(s);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String s = "ab";
        SolutionTimeExceedLimit sol = new SolutionTimeExceedLimit();
        int expectedOutput = 1;
        int output = sol.minCut(s);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        String s = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
        SolutionTimeExceedLimit sol = new SolutionTimeExceedLimit();
        int expectedOutput = 42;
        int output = sol.minCut(s);
        boolean passed = output == expectedOutput;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        String s = "fiefhgdcdcgfeibggchibffahiededbbegegdfibdbfdadfbdbceaadeceeefiheibahgececggaehbdcgebaigfacifhdbecbebfhiefchaaheiichgdbheacfbhfiaffaecicbegdgeiaiccghggdfggbebdaefcagihbdhhigdgbghbahhhdagbdaefeccfiaifffcfehfcdiiieibadcedibbedgfegibefagfccahfcbegdfdhhdgfhgbchiaieehdgdabhidhfeecgfiibediiafacagigbhchcdhbaigdcedggehhgdhedaebchcafcdehcffdiagcafcgiidhdhedgaaegdchibhdaegdfdaiiidcihifbfidechicighbcbgibadbabieaafgeagfhebfaheaeeibagdfhadifafghbfihehgcgggffgbfccgafigieadfehieafaehaggeeaaaehggffccddchibegfhdfafhadgeieggiigacbfgcagigbhbhefcadafhafdiegahbhccidbeeagcgebehheebfaechceefdiafgeddhdfcadfdafbhiifigcbddahbabbeedidhaieagheihhgffbfbiacgdaifbedaegbhigghfeiahcdieghhdabdggfcgbafgibiifdeefcbegcfcdihaeacihgdchihdadifeifdgecbchgdgdcifedacfddhhbcagaicbebbiadgbddcbagbafeadhddaeebdgdebafabghcabdhdgieiahggddigefddccfccibifgbfcdccghgceigdfdbghdihechfabhbacifgbiiiihcgifhdbhfcaiefhccibebcahidachfabicbdabibiachahggffiibbgchbidfbbhfcicfafgcagaaadbacddfiigdiiffhbbehaaacidggfbhgeaghigihggfcdcidbfccahhgaffiibbhidhdacacdfebedbiacaidaachegffaiiegeabfdgdcgdacfcfhdcbfiaaifgfaciacfghagceaaebhhibbieehhcbiggabefbeigcbhbcidbfhfcgdddgdffghidbbbfbdhcgabaagddcebaechbbiegeiggbabdhgghciheabdibefdfghbfbfebidhicdhbeghebeddgfdfhefebiiebdchifbcbahaddhbfafbbcebiigadhgcfbebgbebhfddgdeehhgdegaeedfadegfeihcgeefbbagbbacbgggciehdhiggcgaaicceeaefgcehfhfdciaghcbbgdihbhecfbgffefhgiefgeiggcebgaacefidghdfdhiabgibchdicdehahbibeddegfciaeaffgbefbbeihbafbagagedgbdadfdggfeaebaidchgdbcifhahgfdcehbahhdggcdggceiabhhafghegfdiegbcadgaecdcdddfhicabdfhbdiiceiegiedecdifhbhhfhgdbhibbdgafhgdcheefdhifgddchadbdggiidhbhegbdfdidhhfbehibiaacdfbiagcbheabaaebfeaeafbgigiefeaeheabifgcfibiddadicheahgbfhbhddaheghddceedigddhchecaghdegigbegcbfgbggdgbbigegffhcfcbbebdchffhddbfhhfgegggibhafiebcfgeaeehgdgbccbfghagfdbdfcbcigbigaccecfehcffahiafgabfcaefbghccieehhhiighcfeabffggfchfdgcfhadgidabdceediefdccceidcfbfiiaidechhbhdccccaigeegcaicabbifigcghcefaafaefd";
        SolutionTimeExceedLimit sol = new SolutionTimeExceedLimit();
        int expectedOutput = 1345;
        int output = sol.minCut(s);
        boolean passed = output == expectedOutput;
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }
}