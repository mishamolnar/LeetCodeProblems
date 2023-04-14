package LeetCode.stack;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ValidateStackSequences {
    //n2
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean[] popHistory = new boolean[pushed.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pushed.length; i++) {
            map.put(pushed[i], i);
        }
        int max = 0;
        for (int i = 0; i < popped.length; i++) {
            int index = map.get(popped[i]);
            max = Math.max(i, max);
            if (!checkSame(popHistory, index, max)) {
                return false;
            }
            popHistory[index] = true;
        }
        return true;
    }

    private boolean checkSame(boolean[] popHistory, int index, int last) {
        if (index >= last - 1) {
            return true;
        }
        boolean next = popHistory[index + 1];
        for (int i = index + 2; i <= last; i++) {
            if (popHistory[i] != popHistory[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
