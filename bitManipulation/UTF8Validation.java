package LeetCode.bitManipulation;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int curr = countFirstOnes(data[i]);
            if (curr == -1) return false;
            else if (curr == 0) continue;
            else {
                int end = i + curr;
                for (i = i + 1; i < end; i++) {
                    if (!checkTen(data[i]))
                        return false;
                }
            }
        }
        return true;
    }

    private int countFirstOnes(int num) {
        int i;
        for (i = 0; i < 8; i++) {
            if ((num & (1 << i)) == 0)
                break;
        }
        if (i == 0) return 0;
        else if (i > 5 || i == 2)
            return -1;
        else return i;
    }

    private boolean checkTen(int n) {
        return ((n & 1) == 1) && ((n ^ 2) == 1);
    }

    public static void main(String[] args) {
        UTF8Validation utf8Validation = new UTF8Validation();
        System.out.println("dddd".contains(""));
        System.out.println(utf8Validation.validUtf8(new int[]{237}));
    }
}
