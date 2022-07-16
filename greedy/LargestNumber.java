package LeetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LargestNumber {
    public static void main(String[] args) {
        String[] arr = new String[]{"30", "3", "9"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{8308,8308}));
    }

    public String largestNumber(int[] nums) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int oneLen = o1.length();
                int twoLen = o2.length();
                for (int i = 0; i < o1.length() + o2.length(); i++) {
                    char one = i < o1.length() ? o1.charAt(i) : o2.charAt(i % oneLen);
                    char two = i < o2.length() ? o2.charAt(i) : o1.charAt(i % twoLen);
                    if (one != two) return two - one;
                }
                return 0;
            }
        };
        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted(comparator)
                .parallel()
                .collect(Collectors.joining());
        if (result.charAt(0) == '0') return "0";
        return result;
    }
}
