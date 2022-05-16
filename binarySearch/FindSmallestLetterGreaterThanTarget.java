package LeetCode.binarySearch;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget findSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
        System.out.println(findSmallestLetterGreaterThanTarget.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'z'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return left > letters.length - 1 ? letters[0] : letters[left];
    }
}
