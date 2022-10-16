package LeetCode.dynamic;

public class StringCompressionII {

    public int getLengthOfOptimalCompression(String s, int k) {
        //todo: finish this problem
        return 0;
    }

    private int calLen(int len) {
        if (len == 0) return 0;
        else if (len == 1) return 1;
        else if (len < 10) return 2;
        else if (len < 100) return 3;
        else return 4;
    }
}
