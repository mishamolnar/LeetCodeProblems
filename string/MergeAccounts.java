package LeetCode.string;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/accounts-merge/submissions/
public class MergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> mailToName = new HashMap<>();
        HashMap<String, HashSet<String>> neibours = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (List<String> account : accounts) {
            if (account.size() == 2) {
                res.add(account);
                continue;
            }
            String firstMail = account.get(1);
            mailToName.put(firstMail, account.get(0));
            for (int i = 2; i < account.size(); i++) {
                String nextMail = account.get(i);

                neibours.putIfAbsent(firstMail, new HashSet<>());
                neibours.putIfAbsent(nextMail, new HashSet<>());

                neibours.get(firstMail).add(nextMail);
                neibours.get(nextMail).add(firstMail);
            }
        }

        HashSet<String> visited = new HashSet<>();
        for (Map.Entry<String, String> entry : mailToName.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                List<String> curr = new ArrayList<>();
                curr.add(entry.getValue());
                curr.addAll(BFS(entry.getKey(), neibours, visited));
                res.add(curr);
            }
        }
        return res;
    }

    private List<String> BFS(String mail, HashMap<String, HashSet<String>> neibours, HashSet<String> visited) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(mail);
        Set<String> res = new HashSet<>();
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            visited.add(curr);
            res.add(curr);
            for (String neib : neibours.get(curr)) {
                if (!visited.contains(neib)) {
                    queue.add(neib);
                }
            }
        }
        List<String> ans = new ArrayList<>(res);
        ans.sort(String::compareTo);
        return ans;
    }

//[["David","David0@m.co","David4@m.co","David3@m.co"],
// ["David","David5@m.co","David5@m.co","David0@m.co"],
// ["David","David1@m.co","David4@m.co","David0@m.co"],
// ["David","David0@m.co","David1@m.co","David3@m.co"],
// ["David","David4@m.co","David1@m.co","David3@m.co"]]
    public static void main(String[] args) {
        MergeAccounts mergeAccounts = new MergeAccounts();
        System.out.println(mergeAccounts.accountsMerge(List.of(List.of("David","David0@m.co","David4@m.co","David3@m.co"),
                List.of("David","David5@m.co","David5@m.co","David0@m.co"), List.of("David","David1@m.co","David4@m.co","David0@m.co"),
                List.of("David","David0@m.co","David1@m.co","David3@m.co"), List.of("David","David4@m.co","David1@m.co","David3@m.co"))));
    }
}
