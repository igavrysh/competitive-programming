import java.util.HashSet;
import java.util.HashMap;

class Solution2 {
    public int countGoodNodes(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> G = new HashMap<>();
        for (int[] e : edges) {
            HashSet<Integer> set = G.getOrDefault(e[0], new HashSet<>());
            set.add(e[1]);
            G.put(e[0], set);
            HashSet<Integer> set2 = G.getOrDefault(e[1], new HashSet<>());
            set2.add(e[0]);
            G.put(e[1], set2);
        }
        int[] acc = {0};
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        helper(0, G, visited, acc);
        return acc[0];
    }
    private int helper(Integer node, HashMap<Integer, HashSet<Integer>> G, HashSet<Integer> visited, int[] acc) {
        int size = 0;
        int first_size = 0;
        boolean all_same = true;
        HashSet<Integer> chs = G.get(node);
        if (chs != null) {
            for (Integer ch : chs) {
                if (visited.contains(ch)) {
                    continue;
                } else {
                    visited.add(ch);
                }
                int ch_size = helper(ch, G, visited, acc);
                if (first_size == 0) {
                    first_size = ch_size;
                } else if (first_size != ch_size) {
                    all_same = false;
                }
                size += ch_size;
            }
        }
        if (all_same) {
            acc[0]++;
        }
        size++;
        return size;
    }

    public static void main(String[] args) {
        test2();
        test1();
    }

    public static void test1() {
        int[][] edges = {
            {0,1},{0,2},{1,3},{1,4},{2,5},{2,6}
        };
        Solution2 sol = new Solution2();
        int output = sol.countGoodNodes(edges);
        int t = 1;
    }

    public static void test2() {
        int[][] edges = {
            {133,0},{162,133},{140,162},{26,140},{16,26},{250,16},{205,250},{147,205},{194,147},{291,205},{7,291},{179,7},{282,179},{88,282},{165,88},{265,88},{192,265},{41,192},{264,88},{145,264},{163,145},{236,163},{112,236},{166,236},{213,282},{269,7},{29,269},{275,269},{180,269},{184,269},{146,269},{62,269},{277,269},{128,269},{284,269},{170,269},{3,269},{173,269},{260,269},{72,205},{13,72},{229,13},{187,229},{152,205},{69,250},{117,69},{79,117},{101,79},{54,101},{80,101},{289,101},{28,101},{111,101},{287,117},{137,287},{142,137},{159,142},{208,142},{99,142},{110,142},{103,142},{31,142},{167,142},{118,142},{150,142},{127,142},{228,142},{237,142},{125,142},{95,142},{45,142},{9,142},{174,142},{4,69},{280,4},{176,4},{47,176},{223,176},{136,223},{175,136},{43,136},{161,223},{55,176},{23,55},{235,4},{114,235},{42,114},{281,114},{217,281},{199,235},{139,199},{21,139},{58,21},{74,139},{276,74},{129,199},{196,129},{119,196},{89,119},{91,119},{6,91},{230,6},{233,196},{193,233},{262,233},{134,262},{61,134},{27,196},{215,27},{258,27},{120,258},{240,27},{124,129},{8,124},{108,8},{242,108},{39,108},{211,124},{116,124},{40,116},{24,116},{52,116},{93,52},{246,52},{245,52},{53,52},{273,52},{132,124},{94,199},{86,94},{33,94},{212,33},{294,33},{160,26},{243,160},{267,243},{87,267},{66,87},{102,66},{156,102},{70,156},{183,66},{216,183},{75,216},{71,267},{220,267},{182,267},{35,182},{201,243},{204,160},{168,204},{257,204},{123,204},{271,204},{286,204},{200,140},{214,200},{190,214},{171,190},{44,171},{34,44},{131,34},{188,34},{206,188},{202,34},{261,44},{60,261},{164,261},{285,171},{25,285},{144,25},{231,144},{46,231},{64,231},{227,231},{76,227},{77,144},{1,77},{65,1},{15,1},{121,15},{222,144},{96,222},{78,96},{138,96},{126,96},{226,285},{169,226},{100,169},{181,169},{151,169},{82,226},{104,82},{10,104},{234,10},{148,285},{189,148},{149,189},{157,189},{254,148},{107,254},{244,107},{17,107},{50,17},{30,50},{195,107},{203,107},{218,148},{158,218},{283,158},{48,214},{266,48},{12,266},{141,12},{143,141},{135,143},{18,135},{221,135},{252,135},{272,252},{248,143},{263,248},{255,263},{224,263},{197,224},{2,266},{73,2},{14,73},{105,14},{130,105},{57,130},{172,57},{293,57},{207,293},{22,57},{81,22},{59,57},{290,57},{177,130},{67,177},{5,67},{232,5},{20,232},{238,177},{90,238},{36,90},{49,177},{98,49},{209,105},{292,14},{178,292},{109,14},{113,109},{185,113},{19,185},{63,113},{155,63},{154,155},{253,73},{210,253},{115,253},{56,48},{198,56},{274,200},{37,274},{97,37},{85,97},{239,85},{259,239},{219,259},{153,239},{68,153},{32,85},{256,32},{225,256},{106,32},{92,106},{270,97},{83,270},{249,274},{11,249},{241,11},{186,241},{268,249},{247,268},{288,268},{279,268},{51,268},{278,268},{251,268},{84,268},{191,249},{38,191},{122,191}
        };
        Solution2 sol = new Solution2();
        int output = sol.countGoodNodes(edges);
        int t = 1;
    }

}