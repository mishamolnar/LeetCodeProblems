package LeetCode.string;

//https://leetcode.com/problems/read-n-characters-given-read4/
public class ReadNCharactersGivenRead4 extends Reader4 {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buff = new char[4];
        int pointer = read4(buff), prev = 0;
        while (pointer - prev > 0 && pointer < n + 5) {
            System.arraycopy(buff, 0, buf, prev, Math.min(pointer, n) - prev);
            prev = pointer;
            pointer += read4(buff);
        }
        return Math.min(pointer, n);
    }

    public static void main(String[] args) {

    }

}

