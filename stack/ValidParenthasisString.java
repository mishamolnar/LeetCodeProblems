package LeetCode.stack;

public class ValidParenthasisString {
    public boolean checkValidString(String s) {
        int opened = 0, star = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opened++;
            } else if (s.charAt(i) == ')') {
                opened--;
            } else star++;

            if (opened + star < 0) return false;
        }
        return Math.abs(opened) <= star;
    } //**(((())

    public static void main(String[] args) {
        ValidParenthasisString valid = new ValidParenthasisString();
        System.out.println(valid.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        //((((()))))))(())(()))())((*()()(((()((()*(())*(()**)()(())
    }
}
