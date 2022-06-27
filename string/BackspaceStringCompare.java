package LeetCode.string;

//https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int one = s.length() - 1, two = t.length() - 1;
        while (one >= 0 && two >= 0) {
            if (s.charAt(one) != '#' && t.charAt(two) != '#'
                    && s.charAt(one) != t.charAt(two)) return false;
            if (s.charAt(one) != '#' && t.charAt(two) != '#') {
                one--;
                two--;
            }
            one = handleBackspace(s, one);
            two = handleBackspace(t, two);
        }
        return one == two;
    }

    private int handleBackspace(String s, int pointer) {
        int remains = 0;
        while (pointer >= 0 && remains >=0) {
            if (s.charAt(pointer) == '#') {
                remains++;
                pointer--;
            } else {
                if (remains > 0) pointer--;
                remains--;
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare("bxj##tw", "bxo#j##tw"));
    }
}
