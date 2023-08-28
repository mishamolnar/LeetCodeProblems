package LeetCode.string;

import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] alph = new int[26];
        for (char ch : s.toCharArray()) {
            alph[ch - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> - Integer.compare(a[1], b[1]));
        for (int i = 0; i < 26; i++) {
            if (alph[i] > 0 ) {
                pq.add(new int[]{i, alph[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) (pq.peek()[0] + 'a'));
        int[] used = pq.poll();
        used[1]--;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append((char) (curr[0] + 'a'));
            curr[1]--;
            if (used[1] > 0)
                pq.add(used);
            used = curr;
        }
        return sb.toString().length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aab"));
    }
}
