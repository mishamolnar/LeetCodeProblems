package LeetCode.sorting;

import java.util.Arrays;

//https://leetcode.com/problems/bag-of-tokens/
public class BagOfCoins {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1, score = 0, currScore = 0;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                currScore++;
                score = Math.max(score, currScore);
            } else if (score > 0) {
                currScore--;
                power += tokens[right--];
            } else break;
        }
        return score;
    }


    public static void main(String[] args) {
        BagOfCoins bagOfCoins = new BagOfCoins();
        System.out.println(bagOfCoins.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }
}
