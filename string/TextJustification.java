package LeetCode.string;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/text-justification/
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int charCount = 0, wordsCount = 0, start = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            charCount += words[i].length();
            wordsCount++;
            if (i == words.length - 1) {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j <= i; j++) {
                    sb.append(words[j]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(" ".repeat(maxWidth - sb.length()));
                res.add(sb.toString());
                break;
            }
            if (charCount + wordsCount + words[i + 1].length() > maxWidth) {
                res.add(justify(words, maxWidth, start, i + 1, charCount));
                charCount = 0;
                wordsCount = 0;
                start = i + 1;
            }
        }
        return res;
    }

    private String justify(String[] words, int maxWidth, int start, int end, int wordsLength) {
        StringBuilder sb = new StringBuilder();
        int totalSpaces = maxWidth - wordsLength, spaces = Math.max(1, end - start - 1);
        for (int i = start; i < end; i++) {
            int spacesUsed = (int) Math.ceil(totalSpaces / (double) (spaces));
            sb.append(words[i]).append(" ".repeat(spacesUsed));
            totalSpaces -= spacesUsed;
            spaces--;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        System.out.println(textJustification.fullJustify(new String[]
                {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16));
    }
}
