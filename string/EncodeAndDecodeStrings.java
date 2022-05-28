package LeetCode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        System.out.println(encodeAndDecodeStrings.encode(List.of("ab", "abc", "a")));
        System.out.println(encodeAndDecodeStrings.decode(encodeAndDecodeStrings.encode(List.of("ab", "abc", "a"))));
        System.out.println((char) ((99999 >> 8) & 0xff));
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder words = new StringBuilder();
        StringBuilder indexes = new StringBuilder();
        int count = 0;
        indexes.append("|").append(0).append(",");
        for (String str : strs) {
            count += str.length();
            indexes.append(count).append(",");
            words.append(str);
        }
        return words.append(indexes).toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        List<Integer> indexes = Arrays.stream(s.substring(s.lastIndexOf("|0,") + 1)
                .split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        for (int i = 0; i < indexes.size() - 1; i++) {
            result.add(s.substring(indexes.get(i), indexes.get(i + 1)));
        }
        return result;
    }
}
