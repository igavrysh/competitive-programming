import java.util.HashMap;
class Solution {
    HashMap<Character, Integer> dict = new HashMap<>() {{
        put('a', 0); put('e', 1); put('o', 2); put('i', 3); put('u', 4);
    }};
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        long res = 0;

        // prefix sum: # of vowels in substrings 0..i, i=0..n-1
        // prefix sum: # of cons in substrings word[0..i], i=0..n-1
        int[][] vowels_a = new int[n][5];
        int[] cons_a = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            vowels_a[i] = new int[5];
            for (int j=0; j<5;j++) {
                vowels_a[i][j] = i>0 ? vowels_a[i-1][j] : 0;    
            }
            cons_a[i] = i>0 ? cons_a[i-1] : 0;
            if (dict.get(ch) != null) {
                vowels_a[i][dict.get(ch)]++;
            } else {
                cons_a[i]++;
            }
        }

        for (int r = 0; r < n; r++) {
            int left_bound = r+1;
            int right_bound = -1;

            // first binary search, find right bound for a valid
            // substring, e.g.
            // # of vowels should be minimal
            // AND # of diff vowels should be 5
            // AND # of cons = k
            int good = r+1;
            int bad = -1;
            int vowels = 0;
            int cons = 0;
            // bad: cons>k, vowels full set
            // good: cons<=k, vowels full st
            int last_valid_idx = -1;
            while (good-bad>1) {
                int m = bad+(good-bad)/2;
                vowels = 0;
                cons = 0;

                // using prefix sum
                // find the # of diff vowels (max 5)
                // find # of cons 
                // in a substring word[m..r]
                for (int j=0; j < 5; j++) {
                    if (vowels_a[r][j]-(m-1>=0 ? vowels_a[m-1][j]: 0) > 0) {
                        vowels++;
                    }
                }
                cons = cons_a[r] - (m-1>=0 ? cons_a[m-1] : 0);

                // good...bad
                if (vowels == 5 && cons > k) {
                    bad = m;
                } else if (vowels < 5 && cons < k) {
                    good = m;
                } else if (vowels == 5 && cons < k) {
                    good = m;
                } else if (vowels < 5 && cons > k) {
                    break;
                } else if (vowels == 5 && cons == k) {
                    last_valid_idx = m;
                    bad = m;
                } else if (vowels < 5 && cons == k)  {
                    good = m;
                } else {
                    throw new RuntimeException("unreachable state"+ "vowels:"+vowels+";cons:"+cons);
                }
            }
            if (last_valid_idx != -1) {
                right_bound = last_valid_idx;
            } else {
                continue;
            }

            // second binary search, find left bound for a valid
            // substring, e.g.
            // # of vowels should be maximal
            // AND # of diff vowels should be 5
            // AND # of cons = k
            last_valid_idx = -1;
            good = right_bound+1;
            bad = -1;
            vowels = 0;
            cons = 0;
            while (good-bad>1) {
                int m = bad+(good-bad)/2;
                vowels = 0;
                cons = 0;

                // using prefix sum
                // find the # of diff vowels (max 5)
                // find # of cons 
                // in a substring word[m..r]
                for (int j=0; j < 5; j++) {
                    if (vowels_a[r][j]-(m-1>=0 ? vowels_a[m-1][j]: 0) > 0) {
                        vowels++;
                    }
                }
                cons = cons_a[r] - (m-1>=0 ? cons_a[m-1] : 0);
                
                if (vowels == 5 && cons > k) {
                    bad = m;
                } else if (vowels < 5 && cons < k) {
                    good = m;
                } else if (vowels == 5 && cons < k) {
                    good = m;
                } else if (vowels < 5 && cons > k) {
                    break;
                } else if (vowels == 5 && cons == k) {
                    last_valid_idx = m;
                    good = m;
                } else if (vowels < 5 && cons == k)  {
                    good = m;
                } else {
                    throw new RuntimeException("unreachable state2:" + "vowels:"+vowels+";cons:"+cons);
                }
            }
            if (last_valid_idx != -1) {
                left_bound = last_valid_idx;
            }

            // if the is a valid left and right bound - we found
            // working solution, need to calculate delta add
            // to res
            if (left_bound != r+1 && right_bound != -1 && left_bound <= right_bound) {
                res += (right_bound-left_bound+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        test715();
        test1();
        test3();
    }
    public static void test1() {
        String word = "aeiou";
        int k = 0;
        int exp_output = 1;
        Solution sol = new Solution();
        long output = sol.countOfSubstrings(word, k);
        boolean passed = output == exp_output;
        System.out.println("test1:"+(passed?"passed":"failed"));
    }
    public static void test3() {
        String word = "ieaouqqieaouqq";
        int k = 1;
        long exp_output = 3;
        Solution sol = new Solution();
        long output = sol.countOfSubstrings(word, k);
        boolean passed = output == exp_output;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }
    public static void test715() {
        String word = "baiidoadceubddcbuuuoeuedebidododaoobauaociecbbaaedueouoaiiddaeiooobcabbiuudceccaubbobacbuuioabiaubuedicccbuudeuoooeaocobdobdbooccdeoaciucddcoieoiuacudoaaboiaiciabaocaaaccidbuaiciocbecubuaiiaeboiecioidiiiiducacbduouaooduaudibcieoibdcdebdicaeocbouooiuiduucbieaaacaodboucbiduadaceiacecccbaiaoadcoeubeiiaibeecuboacobcubduacbuiaobouceuibouaoibeduuaaueidabcoidbiiueeeiaecbbeuecocacubecdiodeoaoeccuibdboboaeuoduuuebcdedaeaubiuddeeiiaoauuiieociadbcidieuuebbdbcciiccdeubudcbecoieeuiauooibabdoooduibeiacdccidiaebaudaiioeeicdbeeaiaidebbdcbuaidcbadaicoocoaaobbobdeieeiiieicoudieaauebaoedbecdbuocoudaeiibiioedaacidadaiiabddcauueibbduueaocdaoeiaeceoiibucieideaauobbudobecbocueaeiieeiacoadiuudcaoeidoeiddaiiiioeeiebdbdubobcbeouideabbeiuabeuobabedddceooocbudceaeoecbeciuuoocaiiuieodeiuuouidboeuioadoboaiaeaeebbcdbcoaadoadciiioiebicaoodouiuibecuuboeaecedeiubududuoiebdoidbiacadudiiieboeduuuiuuaueuoeeabcaeceucacaaeoaubeuoodiucidoidaaddbuaeeaucaiabeebucedddccuaiaubidoduocoeeiiuoieodudoaddbobeidcauaiobbuiccubcibdiaeoaiocedccooauueducbdbabdeodaaaeoieaicbaeibiuoueiieaebiucdaooiabuobiebaoiecoebouueueuieeiciiioeaiideceueobdcbuocaicoaoibooccoudbceaeucocbidouiddubaodeccoocubicbbaciodeeooiabdeuoiuuaoooiboidoodecdbcdbidbaciueibouuuiaidbdueaudeaeeeeiebceduabceedddedabcaobdaidudceaoabebobcdeiceaccecubiducoiadbdaacebiaididbboedouuuiiiiaoaiduaeaboaiaibbeecoccodbeddueacbioeebdeddaocacbdaaoaciaeaeuboidiebauucoebeaiidibaocieaboeadbdueiuueaduceaduadauaceaiucibadeeuaiedaiodbiuddcbcodaoodcoeiuebdiceucaddouoocodbbacdiceoibdaoeooboboobuibbaeiddbeubecacidcdubciaiibbccaecuubboucibaacceicebaccbaocucucbedcedcadcdeoaeeaiubaoacbobuciibcddeaaeeeouaoccacduiidaeuaebbdioieuabeoiuouieedoeciuoicicuudcuuuecbiibadbicoeeciuedcdibciuoeodbecaaadbcoodaububaoueubeadeddoaocceoaeccuduceoudeioicuauoecuaeccuibeiebooaucoiaabeebuecceeocaeccoaadeabueadccuaubdodbbcibuaiooecuceabecacbdecdcbcbddodcecueudecodieibdcoeaidaodbaaububebacciibdbcbeeaeoedbeudoabedoddooebeucoebaaaeiiuceduuueabduibbeddibocbiiiauocadeddciiceuaoaeiudaacidaaudubdobieuaiuoabacdeiadedubuduuauuaoucaaiobeoedbcbcobeebuuouebeboudiaoaoaccoouacaiibecciuabuuaabiocdcioibuioodbbbbdbboauebiodcaaiduuoubbeouaiddbiieuuueoiiudbciiiedaaeuoouiceboaieucaidaeoboabaacadooabedideddccbicuuaiceedddbcbdeuaadbcuacodibudeaeiebuouidbduucabuacuabbceooceouedeibccacbuedieaiieibubeeuodcdbbddoiudaiaducdidecouoicceeeuuuabbabeodcdiiiouddcddaaucdeoacidcbeibioadadicocbeioeoaibuddoccbidaaebacdebuuucadccdoibuduuuodoueabeuioduucbceccbeouicbbabibaddiaidcaododbadoeeobidicubuoaciaudcebioaciboioboideiucodaiducaceuoiodaiacbadaaddooucoieocococaccucdcoiaoacoeiidbeduueaibouaebcbeabaoeudbdoccecoueaiciiebbidcdudiiobaeuidoeaudoabdubooacbbcoeuouibceiaciiduodiecdcicobicuabuoaaaeidauueoiaooueiecbicoiuuudiiuudiedcdibodeeaiuuuccubcocdieaibicoueeucciaaebdbecuuiibuueooebudubuiiuaaobeoeibuuuodcoeoeoiooacabobuciueeaiodoabuauaddcaicobeouebiadeecoocceauocudeceeddadcauicadbdiuiciaaceecuiuacaeaeiecacdbdbicuuoubucddobeoeaeeubdbobibecedbubduaoeboeoodiiuduaccbdiccouocbdbauccbeobocicuuudcdouabuoucecbuiodaadcabocodaedabdoecdebeaudoiibebbbobodouioeeibicbdoibaudobiuaucacuccodeddideaciuaoaeeouadeaiaiaebdaedaoueidiaboieuebuboeieicociiioaciodbibbueedoacoeiioibiecocddoaeuiuaueaouaibcdciaioiucaaeabeudouduioaoccadbcadeeuueiaaiiuoecdbdcoccooebdecceouedcidcoeducicbabuoucdoibicbueicoduaicaoiicubbudaaaiieiecbdaeddocbaiocddoediubiabaudicciaidbbuebuocaabiodeduubedbciaadduebbbaiuodeduuadaidciobacdibeeauueouaaodbcoideooebcbddducaeeobudducubcdcocibebaacbebceuouiucoceoduobicucuaceuoedidbiedaiiibbcocbaeouadoeduaidaedodudiebdubiaubiddbebidddieedcueeoiuabuacaccoauiddaddiddiadduceaauouioedeabbuadiiiooioebaaedauididciobbdiacicueeoabecbdececaecaaidcioddouaobuuucdaidbaueacduiobadidueiioibdacaeadceucdeacucoocudbcaddoioiciddedebeuuuoddibiabdbicudauddouoccdbcodcibiduibaociiueubaduubdcuebdeubueedciocdccecouuuiooicocdauabdedebadabcdedueccbiuidocouoboeaaibbuiioccebeadobaueudeeaaaodiieieoceoibccboubaubbdubcbduebdabboodeicbebicueiecdaiubeoaoaeeecaaeceaaeddceudadeoadiiboacaecuabbbiiioabuiudociceoaubiieueiodadcbouudeiadeuouabbeeodbeeuaodiacadecbcedbbducdcuiiadueudoadeeeaiodoobobidcuubbouadcebcdidebiudbiuucoodbauacbueodcdceebeddceiuaccddoobabeobaiebdobbcbdiabaaidocudbuucbabcodieacuciecciebcucuddbaoabbobubeabiedbbcbouudciccuobaaebcucaiiibdduaooeboauoibbeudduceidodddaeuuiodbeoubecbiudoebiecdebauuebaacdaaoubiaueoacueuccuoaduboubodiudddadbaeeuauudcbeobuaobacdaeaeeeuuiiubaidociucedboouabcbciiocaoaoacaciboiieaoucieiieiciiocduioeeeeaducaiudcaaicebddccbecaodbbdbidbdebbiidbaddecdudadeudubbboaabdaiabbdeaodacbiuccabcidocedicuicucdeoibedocdoieuaabcauaaeaadcdbcoiedbubdbbecbbcicoiaedbuiaadobucoabocaoauubuuccbeeoeoibcdeddeueieabdcicbccuuocbdudcubbueacuaeiucicoccoeaabubbiiieaeooaboabuuicucudoedbbuuoduibueudiocicicbodcabbdecdabcbduobudbdaedeuucouaeiibcbceioeedocoiuieeobaoiiaoaouebdodoacdodabuabbeiioceauoaoeccouiueideaoubbeuieuucaicaaabeucoacdduiibbbcaoeodcauoabibeabdiabbcieuccdoauediuieedoubueucccboeobioaiiuuaoadaeoioaucbccaudubduuooduoedubbieiecaiiioabboobdoouiabucieeedoedaedebieeioudaeoaidudoibdoicbaboeeebuabuieeobcuddabaoeuadaeobaace";
        int k = 2504;
        long exp_output = 0;
        Solution sol = new Solution();
        long output = sol.countOfSubstrings(word, k);
        boolean passed = output == exp_output;
        System.out.println("test715:" + (passed ? "passed" : "failed"));
    }
}   