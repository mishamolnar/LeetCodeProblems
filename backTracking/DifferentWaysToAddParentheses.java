package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            if (curr == '*' || curr == '+' || curr == '-') {
                List<Integer> leftRes = diffWaysToCompute(expression.substring(0, i - 1));
                List<Integer> rightRes = diffWaysToCompute(expression.substring(i + 1));
                for (Integer left : leftRes) {
                    for (Integer right : rightRes) {
                        int num = 0;
                        switch (curr) {
                            case '+': num = left + right;
                                    break;
                            case '-': num = left - right;
                                    break;
                            case '*': num = left * right;
                                    break;
                        }
                        res.add(num);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.parseInt(expression));
        return res;
    }
}
