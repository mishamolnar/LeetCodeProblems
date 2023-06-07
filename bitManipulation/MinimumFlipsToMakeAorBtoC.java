package LeetCode.bitManipulation;

public class MinimumFlipsToMakeAorBtoC {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int currBit = 1 << i;
            int aBit = a & currBit, bBit = b & currBit, cBit = c & currBit;
            if (cBit == 1 && aBit == 0 && bBit == 0)
                res++;
            else if (cBit == 0) {
                res += aBit > 0 ? 1 : 0;
                res += bBit > 0 ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 1);
        System.out.println(new MinimumFlipsToMakeAorBtoC().minFlips(2, 6, 5));
    }
}
