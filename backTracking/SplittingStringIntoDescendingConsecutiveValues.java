package LeetCode.backTracking;

public class SplittingStringIntoDescendingConsecutiveValues {
    public boolean splitString(String s) {
        return isRemainingValid(s, null);
    }
    private boolean isRemainingValid(String s, Long previous) {
        long current =0;
        for(int i=0;i<s.length();i++) {
            current = current * 10 + s.charAt(i)-'0';
            if(current >= 10000000000L) return false;   // Avoid overflow
            if(previous == null) {
                if (isRemainingValid(s.substring(i+1), current))
                    return true;
            } else if(current == previous - 1 && (i==s.length()-1 || isRemainingValid(s.substring(i+1), current)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SplittingStringIntoDescendingConsecutiveValues split = new SplittingStringIntoDescendingConsecutiveValues();
        System.out.println(split.splitString("1234"));
        System.out.println(split.splitString("10"));
        System.out.println(Integer.parseInt(null));
    }
}
