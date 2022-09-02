package LeetCode.string;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        char[] first = start.toCharArray();
        char[] second = end.toCharArray();
        boolean firstEnd = true;
        for (int i = 0; i < first.length; i++) {
            if (first[i] == second[i])
                continue;
            if (i < first.length - 1 && ((first[i] == 'X' && first[i + 1] == 'L')
                    || (first[i] == 'R' && first[i + 1] == 'X')))
                swap(first, i, i + 1);
            else firstEnd = false;
        }
        if (firstEnd) return true;
        for (int i = first.length - 1; i >= 0; i--) {
            if (first[i] == second[i])
                continue;
            if (i > 0 && ((first[i] == 'L' && first[i - 1] == 'X')
                    || (first[i] == 'X' && first[i - 1] == 'R')))
                swap(first, i, i - 1);
            else return false;
        }
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
    }

    public static void main(String[] args) {
        SwapAdjacentInLRString swapAdjacentInLRString = new SwapAdjacentInLRString();
        System.out.println(swapAdjacentInLRString.canTransform("XXXL", "LXXR"));
    }
}
