import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int nPotions = potions.length, nSpells = spells.length;
        int[] pairs = new int[nSpells];
        Arrays.sort(potions);
        for (int i = 0; i < nSpells; i++) {
            pairs[i] = nPotions - bs(potions, spells[i], success);
        }
        return pairs;
    }

    private int bs(int[] potions, int spell, long success) {
        int bad = -1;
        int good = potions.length;
        while (good-bad > 1) {
            int m = (int)(bad + ((good - bad) / 2.0));
            if ((long)potions[m] * spell < success) {
                bad = m;
            } else {
                good = m;
            }
        }
        return good;
    }
}