package LeetCode.string;

import java.util.HashSet;

public class NamingACompany {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] groups = new HashSet[26];
        for (String idea : ideas) {
            groups[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int numberOfCommonSuffixes = 0;

                for (String suffix : groups[i]) {
                    if (groups[j].contains(suffix)) {
                        numberOfCommonSuffixes++;
                    }
                }
                res += (groups[i].size() - numberOfCommonSuffixes) * (groups[j].size() - numberOfCommonSuffixes) * 2;
            }
        }
        return res;
    }
}
