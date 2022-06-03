package LeetCode.dynamic;

//https://leetcode.com/problems/sentence-screen-fitting/submissions/
public class SentenceScreenFitting {

    //O(h) complexity
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, len = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }

    public static void main(String[] args) {
        SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
        System.out.println(sentenceScreenFitting.wordsTyping(new String[]{"hello", "word"}, 2, 8));
    }
}
