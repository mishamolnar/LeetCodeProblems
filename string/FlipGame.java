package LeetCode.string;

import java.util.ArrayList;
import java.util.List;


//https://leetcode.com/problems/flip-game/submissions/
public class FlipGame {
    public static void main(String[] args) {
        FlipGame flipGame = new FlipGame();
        System.out.println(flipGame.generatePossibleNextMoves("++++"));
    }

    public List<String> generatePossibleNextMoves(String currentState) {
        StringBuilder stringBuilder = new StringBuilder(currentState);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                stringBuilder.replace(i, i + 2, "--");
                result.add(stringBuilder.toString());
                stringBuilder.replace(i, i + 2, "++");
            }
        }
        return result;
    }
}
