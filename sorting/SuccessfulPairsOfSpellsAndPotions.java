package LeetCode.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //binary search - n log m
        //two pointers n log n + m log m
        int[][] spellsIndex = new int[spells.length][2];
        for (int i = 0; i < spells.length; i++) {
            spellsIndex[i][0] = spells[i];
            spellsIndex[i][1] = i;
        }
        Arrays.sort(spellsIndex, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int potIndex = potions.length - 1;
        for (int i = 0; i < spells.length; i++) {
            while (potions[potIndex] * spellsIndex[i][0] >= success) {
                potIndex++;
            }
            ans[spellsIndex[i][1]] = potions.length - potIndex - 1;
        }
        return ans;
    }
}
