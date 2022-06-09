package LeetCode.string;

//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
public class ReadNCharactersGivenRead4II extends Reader4 {
    private char[] buffer = new char[4];
    private int buffPointer = 0; // наступний елемент який будемо записувати з баффер масиву
    private int buffCounter = 0; //кількість зчитаних елементів в бафер масиві
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int pointer = 0;
        while (pointer < n) {
            if (buffPointer == 0) { //треба щось зчитати якщо поінтер на початку
                buffCounter = read4(buffer);
            }
            if (buffCounter == 0) break; //якщо зчитали і каунтер 0 - значить більше нічого нема
            while (pointer < n && buffPointer < buffCounter) { // переносимо з одного масиву в інший
                buf[pointer++] = buffer[buffPointer++];
            }
            if (buffPointer == buffCounter) buffPointer = 0; //якщо поінтер досягнув каунтера ставимо поінтер на нуль знову
        }
        return pointer;
    }
}
