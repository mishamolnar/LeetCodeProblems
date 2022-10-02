package LeetCode.arrays;

class LUPrefix {
    private boolean[] arr;
    private int pointer;

    public LUPrefix(int n) {
        this.arr = new boolean[n + 2];
        this.pointer = 1;
    }
    
    public void upload(int video) {
        arr[video] = true;
    }
    
    public int longest() {
        while (arr[pointer] && pointer < arr.length - 1 && arr[pointer + 1])
            pointer++;
        return arr[pointer] ? pointer : 0;
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        int[] bits = new int[31];
        for (int i : nums2) {
            for (int j = 0; j < 31; j++) {
                int bit = (int) Math.pow(2, j);
                if ((bit & i) > 0)
                    bits[j]++;
            }
        }
        int res = 0;
        for (int i : nums1) {
            int buff = 0;
            for (int j = 0; j < 31; j++) {
                int bit = (int) Math.pow(2, j);
                int both = bit & i;
                buff += both == 0 ? bits[j] % 2 == 1 ? bit : 0 : ((nums2.length - bits[j]) % 2 == 1) ? bit : 0;
            }
            res ^= buff;
        }
        return res;
    }

    public static void main(String[] args) {
        LUPrefix luPrefix = new LUPrefix(3);
        System.out.println(luPrefix.xorAllNums(new int[]{2, 1, 3}, new int[]{10,2,5,0}));
    }
}