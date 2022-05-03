package LeetCode.bitManipulation;


//link - https://leetcode.com/problems/reverse-bits/
public class ReverseBits {

    //complexity - space O(1) time O(1)
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) { // побітовий здвиг дозволяє нам перевірити біт на кожному місці від 1 до 32
                ans |= 1 << 31 - i; // якщо біт це одиничка - ми маємо її поставити не змінивши інші одинички на протилежне місце - якщо в інпуті була на місці 10 то в нас на 22 місці
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }
}
