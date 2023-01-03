package LeetCode.string;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return word.chars().allMatch(Character::isUpperCase)
                || word.chars().allMatch(Character::isLowerCase)
                || (Character.isUpperCase(word.charAt(0)) && word.chars().filter(Character::isUpperCase).count() == 1);
    }
}
